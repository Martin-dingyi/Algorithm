package PracticeByMyself.class05_图.DFS;

import java.util.Arrays;
import java.util.HashSet;

/**
 * @author Martin
 * @date 2025/1/28 18:47
 * @description <a href="https://leetcode.cn/problems/matchsticks-to-square/">...</a>
 * 思路1：需要用到集合划分问题，这题暂时不写
 */

public class pb23_火柴拼正方形 {

    public static void main(String[] args) {
        int[] matchsticks = {1,2,3,4,5,6,7,8,9,10,5,4,3,2,1};
        System.out.println(makesquare(matchsticks)); //
    }

    static int[] bucket;
    public static boolean makesquare(int[] matchsticks) {
        int sumLen = 0;

        for (int matchstick : matchsticks) {
            sumLen += matchstick;
        }
        Arrays.sort(matchsticks);
        for (int i = 0, j = matchsticks.length - 1; i < j; i++, j--) {
            int temp = matchsticks[i];
            matchsticks[i] = matchsticks[j];
            matchsticks[j] = temp;
        }
        bucket = new int[4];
        return isMakeSquare(matchsticks, 0, sumLen / 4);
    }

    static boolean isMakeSquare(int[] matchsticks, int index, int target) {
        if (index == matchsticks.length) {
            for (int j : bucket) {
                if (j != target) return false;
            }
            return true;
        }

        for (int i = 0; i < 4; i++) {
            if (bucket[i] + matchsticks[index] > target) continue;
            if (i != 0 && bucket[i] == bucket[i - 1]) continue;
            bucket[i] += matchsticks[index];
            if (isMakeSquare(matchsticks, index + 1, target)) return true;
            bucket[i] -= matchsticks[index];
        }

        return false;
    }
}
