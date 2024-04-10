package MartinByZuo.数组.滑动窗口;

// 加油站
// 测试链接 : https://leetcode.cn/problems/gas-station/


// 这个题还能用贪心做
// 但我这里用的是数学和滑动窗口
// 三个数学证明或题目条件：1.当前窗口不合法时，下一个要验证的起点只可能在right的右侧 2.当滑动窗口内值不合法时，left绝对不会不变或回退 3.要么没有答案，要么答案唯一
// 滑动窗口，要么包含数组全部后内部的值合法；要么包含某个部分时内部值不合法。
// preGasSum一定是负的，而且绝对值越来越大。如果right循环划到左边去了，直接验证cur+pre即可。
// 如果划到最后一位都不合法，那么总的cur+pre一定是负的，没有答案。
public class Code04_GasStation {
    public static int canCompleteCircuit(int[] gas, int[] cost) {
        // startPos作为窗口左指针，i作为窗口右指针
        int startPos = 0;
        // preGasSum记录之前行驶后剩下的汽油总数，preGasSum + curGasSum等于从startPos出发剩下的汽油总数
        int preGasSum = 0, curGasSum = 0;
        for (int i = 0; i < gas.length; i++) {
            curGasSum += gas[i] - cost[i];
            if (curGasSum < 0) {
                preGasSum += curGasSum;
                curGasSum = 0;
                startPos = i + 1;
            }
        }
        // 从startPos出发只是可能满足条件
        if (preGasSum + curGasSum < 0) return -1;
        return startPos;
    }

    public static void main(String[] args) {
        int[] gas1 = {1, 2, 3, 4, 5};
        int[] cost1 = {3, 4, 5, 1, 2};
        int[] gas2 = {2, 3, 4};
        int[] cost2 = {3, 4, 3};
        int[] gas3 = {5, 1, 2, 3, 4};
        int[] cost3 = {4, 4, 1, 5, 1};
        int[] gas4 = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
        int[] cost4 = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
        System.out.println(canCompleteCircuit(gas1, cost1));
        System.out.println(canCompleteCircuit(gas2, cost2));
        System.out.println(canCompleteCircuit(gas3, cost3));
        System.out.println(canCompleteCircuit(gas4, cost4));

    }

}
