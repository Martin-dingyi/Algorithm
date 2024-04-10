package ByMartinPratice.动态规划.三维动态规划;

// 一和零(多维费用背包)
// 给你一个二进制字符串数组 strs 和两个整数 m 和 n
// 请你找出并返回 strs 的最大子集的长度
// 该子集中 最多 有 m 个 0 和 n 个 1
// 如果 x 的所有元素也是 y 的元素，集合 x 是集合 y 的 子集
// 测试链接 : https://leetcode.cn/problems/ones-and-zeroes/
public class Code01_OnesAndZeroes {
    public static int getZeroCount(String str) {
        int count = 0;
        char[] s = str.toCharArray();
        for (char c : s) {
            if (c == '0') {
                count++;
            }
        }
        return count;
    }

    public static int findMaxForm(String[] strs, int m, int n) {
        dp = new int[strs.length + 1][m + 1][n + 1];
        for (int i = 0; i <= strs.length; i++) {
            for (int j = 0; j <= m; j++) {
                for (int k = 0; k <= n; k++) {
                    dp[i][j][k] = -1;
                }
            }
        }
        return localMax(strs, m, n, 0);
    }

    public static int[][][] dp;

    public static int localMax(String[] strs, int m, int n, int index) {
        if (index == strs.length) {
            return 0;
        }
        if (dp[index][m][n] != -1) {
            return dp[index][m][n];
        }
        int zeroCount = getZeroCount(strs[index]);
        int p1 = localMax(strs, m, n, index + 1);
        int p2 = 0;
        if (zeroCount <= m && strs[index].length() - zeroCount <= n) {
            p2 = 1 + localMax(strs, m - zeroCount, n - (strs[index].length() - zeroCount), index + 1);
        }
        dp[index][m][n] = Math.max(p1, p2);
        return  dp[index][m][n];
    }

    public static int btt(String[] strs, int m, int n) {
        int[][][] dp = new int[strs.length + 1][m + 1][n + 1];
        for (int i = strs.length - 1; i >= 0; i--) {
            for (int j = 0; j <= m; j++) {
                for (int k = 0; k <= n; k++) {
                    int p1 = dp[i + 1][j][k];
                    int p2 = 0;
                    int zeroCount = getZeroCount(strs[i]);
                    // 保证m和n的值大于等于0，防止越界
                    if (zeroCount <= j && strs[i].length() - zeroCount <= k) {
                        p2 = 1 + dp[i + 1][j - zeroCount][k - (strs[i].length() - zeroCount)];
                    }
                    dp[i][j][k] = Math.max(p1, p2);
                }
            }
        }
        return dp[0][m][n];
    }

    public static int btts(String[] strs, int m, int n) {
        int[][] dp = new int[m + 1][n + 1];
        int[] zeroCount = new int[strs.length];
        for (int i = 0; i < zeroCount.length; i++) {
            zeroCount[i] = getZeroCount(strs[i]);
        }
        for (int i = strs.length - 1; i >= 0; i--) {
            for (int j = m; j >= 0 && zeroCount[i] <= j; j--) {
                for (int k = n; k >= 0 && strs[i].length() - zeroCount[i] <= k; k--) {
                    dp[j][k] = Math.max(dp[j][k], 1 + dp[j - zeroCount[i]][k - (strs[i].length() - zeroCount[i])]);
                }
            }
        }
        return dp[m][n];
    }

    public static void main(String[] args) {
        System.out.println(getZeroCount("00001"));
    }
}
