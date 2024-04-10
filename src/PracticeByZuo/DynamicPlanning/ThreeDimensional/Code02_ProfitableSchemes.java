package PracticeByZuo.DynamicPlanning.ThreeDimensional;

// 盈利计划(多维费用背包)
// 集团里有 n 名员工，他们可以完成各种各样的工作创造利润
// 第 i 种工作会产生 profit[i] 的利润，它要求 group[i] 名成员共同参与
// 如果成员参与了其中一项工作，就不能参与另一项工作
// 工作的任何至少产生 minProfit 利润的子集称为 盈利计划
// 并且工作的成员总数最多为 n
// 有多少种计划可以选择？因为答案很大，所以 返回结果模 10^9 + 7 的值。
// 测试链接 : https://leetcode.cn/problems/profitable-schemes/
public class Code02_ProfitableSchemes {
    public static int profitableSchemes(int n, int minProfit, int[] group, int[] profit) {
        dp = new int[profit.length + 1][n + 1][minProfit + 1];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                for (int k = 0; k < dp[0][0].length; k++) {
                    dp[i][j][k] = -1;
                }
            }
        }
        return localCount(n, minProfit, group, profit, 0);
    }

    public static int[][][] dp;

    public static int localCount(int n, int minProfit, int[] group, int[] profit, int proIndex) {
        if (proIndex == profit.length) {
            return minProfit == 0 ? 1 : 0;
        }
        if (dp[proIndex][n][minProfit] != -1) {
            return dp[proIndex][n][minProfit];
        }
        // 不选这个项目
        int p1 = localCount(n, minProfit, group, profit, proIndex + 1);
        // 选这个项目
        int p2 = 0;
        if (n - group[proIndex] >= 0) {
            // 确定人够才能选这个项目
            p2 = localCount(n - group[proIndex], Math.max(minProfit - profit[proIndex], 0), group, profit, proIndex + 1);
        }
        dp[proIndex][n][minProfit] = p1 + p2;
        return p1 + p2;
    }

    public static int btt(int n, int minProfit, int[] group, int[] profit) {
        int[][][] dp = new int[profit.length + 1][n + 1][minProfit + 1];
        for (int i = 0; i <= n; i++) {
            dp[profit.length][i][0] = 1;
        }
        for (int i = profit.length - 1; i >= 0; i--) {
            for (int j = 0; j <= n; j++) {
                for (int k = 0; k <= minProfit; k++) {
                    dp[i][j][k] = (dp[i + 1][j][k] + (j - group[i] >= 0 ? dp[i + 1][j - group[i]][Math.max(k - profit[i], 0)] : 0)) % 1000000007;
                }
            }
        }
        return dp[0][n][minProfit];
    }

    public static int btts(int n, int minProfit, int[] group, int[] profit) {
        int[][] dp = new int[n + 1][minProfit + 1];
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 1;
        }
        for (int i = profit.length - 1; i >= 0; i--) {
            for (int j = n; j >= 0 && j - group[i] >= 0; j--) {
                for (int k = minProfit; k >= 0; k--) {
                    dp[j][k] +=  dp[j - group[i]][Math.max(k - profit[i], 0)];
                    dp[j][k]  %= 1000000007;
                }
            }
        }
        return dp[n][minProfit];
    }

    public static void main(String[] args) {
        System.out.println(btts(5, 3, new int[]{2, 2}, new int[]{2, 3}));
        System.out.println(btt(5, 3, new int[]{2, 2}, new int[]{2, 3}));
//        System.out.println(profitableSchemes(5, 3, new int[]{2, 2}, new int[]{2, 3}));
        System.out.println(btts(10, 5, new int[]{2, 3, 5}, new int[]{6, 7, 8}));
        System.out.println(btt(10, 5, new int[]{2, 3, 5}, new int[]{6, 7, 8}));
//        System.out.println(profitableSchemes(10, 5, new int[]{2, 3, 5}, new int[]{6, 7, 8}));
    }
}
