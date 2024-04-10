package PracticeByZuo.DynamicPlanning.OneDimensional;

import java.util.Arrays;

// 最低票价
// 在一个火车旅行很受欢迎的国度，你提前一年计划了一些火车旅行
// 在接下来的一年里，你要旅行的日子将以一个名为 days 的数组给出
// 每一项是一个从 1 到 365 的整数
// 火车票有 三种不同的销售方式
// 一张 为期1天 的通行证售价为 costs[0] 美元
// 一张 为期7天 的通行证售价为 costs[1] 美元
// 一张 为期30天 的通行证售价为 costs[2] 美元
// 通行证允许数天无限制的旅行
// 例如，如果我们在第 2 天获得一张 为期 7 天 的通行证
// 那么我们可以连着旅行 7 天(第2~8天)
// 返回 你想要完成在给定的列表 days 中列出的每一天的旅行所需要的最低消费
// 测试链接 : https://leetcode.cn/problems/minimum-cost-for-tickets/
public class Code02_MinimumCostForTickets {
    public static int[] ticket = {1, 7, 30};
    public static int[] dp;
    public static int mincostTickets(int[] days, int[] costs) {
        int ans = 0;
        dp = new int[1000];
        ans = topToBottom(days, costs, 0);
        return ans;
    }

    // 递归函数作用：计算在days[index]这一天选择三种票各自需要的费用，从中得到最低费用
    public static int f(int[] days, int[] costs, int index) {
        if (index == days.length) {
            return 0;
        }
        int ans = Integer.MAX_VALUE;
        int cost, day;
        // 找出在days[index]这一天选择1,7,30票型后，下一次需要买票的那一天，用j记录这一天在days中的下标。
        for (int i = 0; i < 3; i++) {
            // 下一次要买票的日期就是days[index]+票持续的天数
            day = days[index] + ticket[i];
            int j = index + 1;
            // 只要days[j]大于或等于day就行了，否则得继续往days[]后面找
            while (j < days.length && days[j] < day) {
                j++;
            }
            // 找到下一次要买票的日期了，计算该票价+那个日期下的最低票价
            cost = costs[i] + f(days, costs, j);
            // 比较三种票型下，哪一个最划算
            ans = Math.min(ans, cost);
        }
        return ans;
    }

    public static int topToBottom(int[] days, int[] costs, int index) {
        if (index == days.length) {
            return 0;
        }
        if (dp[index] != Integer.MAX_VALUE) {
            return dp[index];
        }
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < 3; i++) {
            int day = days[index] + ticket[i];
            int j = index + 1;
            while (j < days.length && day > days[j]) {
                j++;
            }
            ans = Math.min(ans, costs[i] + topToBottom(days, costs, j));
        }
        dp[index] = ans;
        return ans;
    }

    public static int bottomToTop(int[] days, int[] costs) {
        int[] dp = new int[1000];
        for (int i = days.length - 1; i >= 0; i--) {
            int ans = Integer.MAX_VALUE;
            for (int k = 0; k < 3; k++) {
                int day = days[i] + ticket[k];
                int j = i + 1;
                // 找到下一个需要买票的日期在days中的下标
                while (j < days.length && day > days[j]) {
                    j++;
                }
                ans = Math.min(ans, costs[k] + dp[j]);
            }
            dp[i] = ans;
        }
        return dp[0];
    }

    public static void main(String[] args) {
        dp = new int[1000];
        Arrays.fill(dp, Integer.MAX_VALUE);
        int[] days = new int[]{1,2,3,4,5,6,7,8,9,10,30,31};// 1,4,6,7,8,20
        int[] costs = new int[]{2, 7, 15};
        System.out.println(f(days, costs, 0));
        System.out.println(topToBottom(days, costs, 0));
        System.out.println(bottomToTop(days, costs));
    }
}
