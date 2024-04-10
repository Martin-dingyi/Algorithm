package MartinByZuo.动态规划.二维动态规划;

// 不同的子序列
// 给你两个字符串 s 和 t ，统计并返回在 s 的 子序列 中 t 出现的个数
// 测试链接 : https://leetcode.cn/problems/distinct-subsequences/
public class Code07_DistinctSubsequences {
    public static int numDistinct(String s, String t) {
        char[] base = s.toCharArray();
        char[] compare = t.toCharArray();
        dp = new int[base.length][compare.length];
        for (int i = 0; i < base.length; i++) {
            for (int j = 0; j < compare.length; j++) {
                dp[i][j] = -1;
            }
        }
        return localMax(base, compare, 0, 0);
    }

    public static int[][] dp;

    public static int localMax(char[] s, char[] t, int index1, int index2) {
        if (index2 == t.length) {
            return 1;
        }
        if (index1 == s.length) {
            return 0;
        }
        if (dp[index1][index2] != -1) {
            return dp[index1][index2];
        }
        int ans = localMax(s, t, index1 + 1, index2);
        if (s[index1] == t[index2]) {
            ans += localMax(s, t, index1 + 1, index2 + 1);
        }
        dp[index1][index2] = ans;
        return ans;
    }

    public static int bottomToTop(String s, String t) {
        char[] base = s.toCharArray();
        char[] compare = t.toCharArray();
        int row = base.length;
        int col = compare.length;
        int[][] dp = new int[row + 1][col + 1];
        for (int i = 0; i <= row; i++) {
            dp[i][col] = 1;
        }
        for (int i = row - 1; i >= 0; i--) {
            for (int j = 0; j < col; j++) {
                dp[i][j] = dp[i + 1][j];
                if (base[i] == compare[j]) {
                    dp[i][j] += dp[i + 1][j + 1];
                }
            }
        }
        return dp[0][0];
    }

    public static int bottomToTopSmaller(String s, String t) {
        char[] base = s.toCharArray();
        char[] compare = t.toCharArray();
        int row = base.length;
        int col = compare.length;
        int[] dp = new int[col + 1];
        dp[col] = 1;
        for (int i = row - 1; i >= 0; i--) {
            for (int j = 0; j < col; j++) {
                if (base[i] == compare[j]) {
                    dp[j] += dp[j + 1];
                }
            }
        }
        return dp[0];
    }

    public static void main(String[] args) {
        String s1 = "rabbbit";
        String s2 = "rabbit";
        String s11 = "babgbag";
        String s22 = "bag";
        System.out.println(bottomToTopSmaller(s11, s22));
        System.out.println(bottomToTop(s11, s22));
    }
}
