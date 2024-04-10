package PracticeByZuo.DynamicPlanning.ThreeDimensional;

public class Code04_PathsDivisibleByK {
    public static int numberOfPaths(int[][] grid, int k) {
        dp = new int[k][grid.length + 1][grid[0].length + 1];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                for (int l = 0; l < dp[0][0].length; l++) {
                    dp[i][j][l] = -1;
                }
            }
        }
        int ans = localVal(grid, k, 0, 0, 0);
        return ans;
    }


    // dp表定义：不把自己算在内，确定需要的余数，在该余数下，从这个位置到右下角有多少条合法路径。
    public static int[][][] dp;
    public static int mod = 1000000007;
    // 递归函数作用：计算走下面和上面时所有满足条件的路径数，注意初始的value并不相同。
    public static int localVal(int[][] grid, int k, int remainderNeed, int row, int col) {
        if (row == grid.length - 1 && col == grid[0].length - 1) {
            return grid[row][col] % k == remainderNeed ? 1 : 0;
        }
        if (dp[remainderNeed][row][col] != -1) {
            return dp[remainderNeed][row][col];
        }
        int ans = 0;
        int backup = remainderNeed;
        // remainderNeed为接下来的元素需要提供的余数
        remainderNeed = (k - grid[row][col] % k + remainderNeed) % k;
        if (row + 1 < grid.length) {
            ans = (ans + localVal(grid, k, remainderNeed, row + 1, col)) % mod;
        }
        if (col + 1 < grid[0].length) {
            ans = (ans + localVal(grid, k, remainderNeed, row, col + 1)) % mod;
        }
        dp[backup][row][col] = ans;
        return ans;
    }

    public static int btt(int[][] grid, int k_remainder) {
        int n = grid.length;
        int m = grid[0].length;
        int[][][] dp = new int[k_remainder][n][m];
        // 只有还需要的余数正好等于最右下元素可以提供的余数，才有一条合法路径，其他都不合法，为零。
        dp[grid[n - 1][m - 1] % k_remainder][n - 1][m - 1] = 1;
        int remainderNeed;
        for (int i = n - 2; i >= 0; i--) {
            for (int j = 0; j < k_remainder; j++) {
                remainderNeed = (k_remainder - grid[i][m - 1] % k_remainder + j) % k_remainder;
                dp[j][i][m - 1] = dp[remainderNeed][i + 1][m - 1];
            }
        }
        for (int i = m - 2; i >= 0; i--) {
            for (int j = 0; j < k_remainder; j++) {
                remainderNeed = (k_remainder - grid[n - 1][i] % k_remainder + j) % k_remainder;
                dp[j][n - 1][i] = dp[remainderNeed][n - 1][i + 1];
            }
        }
        for (int i = n - 2; i >= 0; i--) {
            for (int j = m - 2; j >= 0; j--) {
                for (int k = 0; k < k_remainder; k++) {
                    remainderNeed = (k_remainder - grid[i][j] % k_remainder + k) % k_remainder;
                    dp[k][i][j] = (dp[remainderNeed][i + 1][j] + dp[remainderNeed][i][j + 1]) % mod;
                }

            }
        }
        return dp[0][0][0];
    }

    public static void main(String[] args) {
//        int[][] grid = {{5, 2, 4}, {3, 0, 5}, {0, 7, 2}};
        int[][] grid = {{0, 0}};
        System.out.println(btt(grid, 3));
        System.out.println(numberOfPaths(grid, 3));
    }
}
