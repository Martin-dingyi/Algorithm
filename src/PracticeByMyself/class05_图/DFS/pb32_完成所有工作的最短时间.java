package PracticeByMyself.class05_图.DFS;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Martin
 * @date 2025/1/29 19:34
 * @description <a href="https://leetcode.cn/problems/find-minimum-time-to-finish-all-jobs/">...</a>
 */

public class pb32_完成所有工作的最短时间 {

    public static void main(String[] args) {
        int[] jobs = {3,2,3};
        System.out.println(minimumTimeRequired(jobs, 3));
    }

    static int minTime;
    public static int minimumTimeRequired(int[] jobs, int k) {
        minTime = Integer.MAX_VALUE;
        traverse(jobs,0, k, new int[k], Integer.MIN_VALUE);
        return minTime;
    }

    static void traverse(int[] jobs, int index, int k, int[] eachCost, int curMaxTime) {
        if (index == jobs.length) {
            minTime = Math.min(minTime, curMaxTime);
            return;
        }

        Set<Integer> costSet = new HashSet<>();
        // 把工作分别k个员工，一共有k种决策
        for (int i = 0; i < k; i++) {
            int curCost = eachCost[i] + jobs[index];
            if (curCost >= minTime) continue;
            if (costSet.add(curCost)) {
                eachCost[i] += jobs[index];
                traverse(jobs, index + 1, k, eachCost, Math.max(curMaxTime, curCost));
                eachCost[i] -= jobs[index];
            }
        }
    }
}
