package ByMartinPratice.贪心算法.class1;

import java.util.Arrays;

// 两地调度
// 公司计划面试2n个人，给定一个数组 costs
// 其中costs[i]=[aCosti, bCosti]
// 表示第i人飞往a市的费用为aCosti，飞往b市的费用为bCosti
// 返回将每个人都飞到a、b中某座城市的最低费用
// 要求每个城市都有n人抵达
// 测试链接 : https://leetcode.cn/problems/two-city-scheduling/
public class Code02_TwoCityScheduling {
    public static int twoCitySchedCost(int[][] costs) {
        // 1.计算出所有人a城市所需的费用allCost
        int allCost = 0;
        for (int i = 0; i < costs.length; i++) {
            allCost += costs[i][0];
        }
        // 2.计算出所有人从a城切换到b城的代价，用数组toBCityCost存储
        int[] toBCityCost = new int[costs.length];
        for (int i = 0; i < toBCityCost.length; i++) {
            toBCityCost[i] = costs[i][1] - costs[i][0];
        }
        // 3.将toBCityCost从小到大排序，取最小的那一半加到allCost中去
        Arrays.sort(toBCityCost);
        for (int i = 0; i < toBCityCost.length / 2; i++) { // 根据题意，toBCityCost.length一定是偶数
            allCost += toBCityCost[i];
        }
        return allCost;
    }
}
