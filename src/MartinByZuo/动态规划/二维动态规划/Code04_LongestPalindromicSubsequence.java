package MartinByZuo.动态规划.二维动态规划;

// 最长回文子序列
// 给你一个字符串 s ，找出其中最长的回文子序列，并返回该序列的长度
// 测试链接 : https://leetcode.cn/problems/longest-palindromic-subsequence/
public class Code04_LongestPalindromicSubsequence {
    public static int longestPalindromeSubseq(String str) {
        char[] s = str.toCharArray();
        dp = new int[s.length][s.length];
        for (int i = 0; i < s.length; i++) {
            for (int j = 0; j < s.length; j++) {
                dp[i][j] = -1;
            }
        }
        return localMax(s, 0, s.length - 1);
    }

    public static int[][] dp;

    public static int localMax(char[] s, int front, int back) {
        if (front == back) {
            return 1;
        }
        if (front > back) {
            return 0;
        }
        if (dp[front][back] != -1) {
            return dp[front][back];
        }
        if (s[front] == s[back]) {
            dp[front][back] = 2 + localMax(s, front + 1, back - 1);
        } else {
            dp[front][back] = Math.max(localMax(s, front + 1, back), localMax(s, front, back - 1));
        }
        return dp[front][back];
    }

    public static int bottomToTop(String str) {
        char[] s = str.toCharArray();
        int n = s.length;
        int[][] dp = new int[n][n];
        for (int i = n - 1; i >= 0; i--) {
            dp[i][i] = 1;
            for (int j = i + 1; j < n; j++) {
                if (s[i] == s[j]) {
                    dp[i][j] = 2 + dp[i + 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[0][n - 1];
    }

    public static int bottomToTopSmaller(String str) {
        char[] s = str.toCharArray();
        int n = s.length;
        int[] dp = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            dp[i] = 1;
            int leftDown = 0, backup;
            for (int j = i + 1; j < n; j++) {
                backup = dp[j];
                if (s[i] == s[j]) {
                    dp[j] = 2 + leftDown;
                } else {
                    dp[j] = Math.max(dp[j], dp[j - 1]);
                }
                leftDown = backup;
            }
        }
        return dp[n - 1];
    }

    public static void main(String[] args) {
        String s = "bbbab";
        System.out.println(bottomToTop(s));
        System.out.println(bottomToTopSmaller(s));
        System.out.println(longestPalindromeSubseq(s));
    }
}
