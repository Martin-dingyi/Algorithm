package MartinByZuo.动态规划.三维动态规划;

// 骑士在棋盘上的概率
// n * n的国际象棋棋盘上，一个骑士从单元格(row, col)开始，并尝试进行 k 次移动
// 行和列从0开始，所以左上单元格是 (0,0)，右下单元格是 (n-1, n-1)
// 象棋骑士有8种可能的走法。每次移动在基本方向上是两个单元格，然后在正交方向上是一个单元格
// 每次骑士要移动时，它都会随机从8种可能的移动中选择一种，然后移动到那里
// 骑士继续移动，直到它走了 k 步或离开了棋盘
// 返回 骑士在棋盘停止移动后仍留在棋盘上的概率
// 测试链接 : https://leetcode.cn/problems/knight-probability-in-chessboard/
public class Code03_KnightProbabilityInChessboard {
    public static double knightProbability(int n, int k, int row, int column) {
        dp = new double[k + 1][n + 1][n + 1];
        for (int i = 0; i <= k; i++) {
            for (int j = 0; j <= n; j++) {
                for (int l = 0; l <= n; l++) {
                    dp[i][j][l] = -1;
                }
            }
        }
        double ans = local(n, k, row, column) / Math.pow(8, k);
        return ans;
    }

    public static double[][][] dp;

    public static double local(int n, int k, int row, int col) {
        if (row >= n || col >= n || row < 0 || col < 0) {
            return 0;
        }
        if (k == 0) {
            return 1;
        }
        if (dp[k][row][col] != -1) {
            return dp[k][row][col];
        }
        dp[k][row][col] = local(n, k - 1, row + 2, col + 1) +
                local(n, k - 1, row - 2, col + 1) +
                local(n, k - 1, row + 1, col + 2) +
                local(n, k - 1, row - 1, col + 2) +
                local(n, k - 1, row + 2, col - 1) +
                local(n, k - 1, row - 2, col - 1) +
                local(n, k - 1, row + 1, col - 2) +
                local(n, k - 1, row - 1, col - 2);
        return dp[k][row][col];
    }

    // 这个题目改成严格依赖动态规划反而会提升时间复杂度，因为三维dp表中有些值是不需要计算的
    public static double btt(int n, int k, int row, int column) {
        double[][][] dp = new double[k + 1][n + 2][n + 2];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                dp[0][i][j] = 1.0;
            }
        }
        for (int i = 1; i <= k; i++) {
            for (int j = 1; j <= n; j++) {
                for (int l = 1; l <= n; l++) {
                    dp[i][j][l] = dp[i - 1][min(j + 2, n + 1)][min(l + 1, n + 1)] +
                            dp[i - 1][max(j - 2, 0)][min(l + 1, n + 1)] +
                            dp[i - 1][min(j + 1, n + 1)][min(l + 2, n + 1)] +
                            dp[i - 1][max(j - 1, 0)][min(l + 2, n + 1)] +
                            dp[i - 1][min(j + 2, n + 1)][max(l - 1, 0)] +
                            dp[i - 1][max(j - 2, 0)][max(l - 1, 0)] +
                            dp[i - 1][min(j + 1, n + 1)][max(l - 2, 0)] +
                            dp[i - 1][max(j - 1, 0)][max(l - 2, 0)];
                    dp[i][j][l] /= 8;
                }
            }
        }
        return dp[k][row + 1][column + 1];
    }

    public static int max(int a, int b) {
        return Math.max(a, b);
    }

    public static int min(int a, int b) {
        return Math.min(a, b);
    }

    public static void main(String[] args) {
        System.out.println(btt(8, 7, 6, 4));
        System.out.println(knightProbability(8, 7, 6, 4));
    }
}
