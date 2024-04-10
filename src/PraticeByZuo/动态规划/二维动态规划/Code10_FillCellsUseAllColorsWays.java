package ByMartinPratice.动态规划.二维动态规划;

import java.util.Arrays;

// 有效涂色问题
// 给定n、m两个参数
// 一共有n个格子，每个格子可以涂上一种颜色，颜色在m种里选
// 当涂满n个格子，并且m种颜色都使用了，叫一种有效方法
// 求一共有多少种有效的涂色方法
// 1 <= n, m <= 5000
// 结果比较大请 % 1000000007 之后返回
// 对数器验证
public class Code10_FillCellsUseAllColorsWays {
    public static int compare(int n, int m) {
        if (n == m) {
            return getAAA(n, n);
        }
        if (n < m || n == 0) {
            return 0;
        }
        if (m == 0) {
            return 1;
        }
        return compare(n - 1, m - 1) * n;
    }

    public static int getAAA(int n, int count) {
        if (n == 0 || count == 0) {
            return 1;
        }
        return n * getAAA(n - 1, count - 1);
    }

    public static void main(String[] args) {
//        System.out.println(getAAA(10, 4));
        System.out.println(compare(4, 2));
        System.out.println(ways2(2, 1));
    }
    public static int MAXN = 5001;

    public static int[][] dp = new int[MAXN][MAXN];

    public static int mod = 1000000007;

    public static int ways2(int n, int m) {
        // dp[i][j]:
        // 一共有m种颜色
        // 前i个格子涂满j种颜色的方法数
        for (int i = 1; i <= n; i++) {
            dp[i][1] = m;
        }
        for (int i = 2; i <= n; i++) {
            for (int j = 2; j <= m; j++) {
                dp[i][j] = (int) (((long) dp[i - 1][j] * j) % mod);
                dp[i][j] = (int) ((((long) dp[i - 1][j - 1] * (m - j + 1)) + dp[i][j]) % mod);
            }
        }
        return dp[n][m];
    }
    public static int ways1(int n, int m) {
        return f(new int[n], new boolean[m + 1], 0, n, m);
    }

    // 把所有填色的方法暴力枚举
    // 然后一个一个验证是否有效
    // 这是一个带路径的递归
    // 无法改成动态规划
    public static int f(int[] path, boolean[] set, int i, int n, int m) {
        if (i == n) {
            Arrays.fill(set, false);
            int colors = 0;
            for (int c : path) {
                if (!set[c]) {
                    set[c] = true;
                    colors++;
                }
            }
            return colors == m ? 1 : 0;
        } else {
            int ans = 0;
            for (int j = 1; j <= m; j++) {
                path[i] = j;
                ans += f(path, set, i + 1, n, m);
            }
            return ans;
        }
    }
}
