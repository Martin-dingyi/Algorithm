package PracticeByMyself.class05_图.DFS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Martin
 * @date 2025/1/27 12:50
 * @description <a href="https://leetcode.cn/problems/numbers-with-same-consecutive-differences/">...</a>
 */

public class pb14_连续差相同的数字 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(numsSameConsecDiff(3, 7)));
    }

    static List<Integer> ansList;
    public static int[] numsSameConsecDiff(int n, int k) {
        ansList = new ArrayList<>();
        traverse(n, k, 0, -1, 0);

        int[] ans = new int[ansList.size()];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = ansList.get(i);
        }

        return ans;
    }

    static void traverse(int n, int k, int path, int preNum, int pathSize) {
        if (pathSize == n) {
            ansList.add(path);
            return;
        }

        // 盒子选球的思路
        for (int i = 0; i <= 9; i++) {
            if ((preNum != -1 && Math.abs(preNum - i) != k) || (preNum == -1 && i == 0)) {
                continue;
            }
            traverse(n, k, path * 10 + i, i, pathSize + 1);
        }
    }

}
