package PracticeByMyself.class05_图.DFS;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Martin
 * @date 2025/1/27 13:31
 * @description <a href="https://leetcode.cn/problems/beautiful-arrangement/">...</a>
 * 思路1：回溯算法
 * 思路2：动态规划
 */

public class pb16_优美的排列 {

    public static void main(String[] args) {
        System.out.println(countArrangement(3)); // 3
    }
    
    static int count;
    static boolean[] used;
    public static int countArrangement(int n) {
        count = 0;
        used = new boolean[n + 1];
        traverse(n, 1);
        return count;
    }

    static void traverse(int n, int index) {
        if (index == n + 1) {
            count++;
            return;
        }

        // 盒子选球，剪枝操作必然将所有不满足条件的部分去掉
        for (int num = 1; num <= n; num++) {
            if (used[num]) {
                continue;
            }
            if (num % index == 0 || index % num == 0) {
                used[num] = true;
                traverse(n, index + 1);
                used[num] = false;
            }
        }
    }

}
