package MartinByZuo.动态规划.二维动态规划;

// 矩阵中的最长递增路径
// 给定一个 m x n 整数矩阵 matrix ，找出其中 最长递增路径 的长度
// 对于每个单元格，你可以往上，下，左，右四个方向移动
// 你 不能 在 对角线 方向上移动或移动到 边界外（即不允许环绕）
// 测试链接 : https://leetcode.cn/problems/longest-increasing-path-in-a-matrix/
public class Code06_LongestIncreasingPath {
    // 这个问题无法使用严格路径依赖，因为dp表中的某一项所依赖的其他项没有明显、易用的规律
    public static int longestIncreasingPath(int[][] matrix) {
        int ans = 0;
        int row = matrix.length;
        int col = matrix[0].length;
        dp = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                ans = Math.max(ans, getLocalMax(matrix, i, j, -1));
            }
        }
        return ans;
    }

    public static int[][] dp;

    // 递归函数作用：求四条可能路径中，长度最大的那条，返回该长度。
    public static int getLocalMax(int[][] matrix, int rowIndex, int colIndex, int lastVal) {
        if (rowIndex == matrix.length || colIndex == matrix[0].length || rowIndex == -1 || colIndex == -1) {
            return 0;
        }
        if (matrix[rowIndex][colIndex] <= lastVal) {
            return 0;
        }
        if (dp[rowIndex][colIndex] != 0) {
            return dp[rowIndex][colIndex];
        }
        lastVal = matrix[rowIndex][colIndex];
        int ans = Math.max(getLocalMax(matrix, rowIndex + 1, colIndex, lastVal), getLocalMax(matrix, rowIndex - 1, colIndex, lastVal));
        ans = Math.max(ans, getLocalMax(matrix, rowIndex, colIndex + 1, lastVal));
        ans = Math.max(ans, getLocalMax(matrix, rowIndex, colIndex - 1, lastVal));
        dp[rowIndex][colIndex] = ans + 1;
        return dp[rowIndex][colIndex];
    }

    public static void main(String[] args) {

    }
}
