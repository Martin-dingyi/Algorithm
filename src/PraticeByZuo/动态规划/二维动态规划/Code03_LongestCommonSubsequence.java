package ByMartinPratice.动态规划.二维动态规划;

// 最长公共子序列
// 给定两个字符串text1和text2
// 返回这两个字符串的最长 公共子序列 的长度
// 如果不存在公共子序列，返回0
// 两个字符串的 公共子序列 是这两个字符串所共同拥有的子序列
// 测试链接 : https://leetcode.cn/problems/longest-common-subsequence/

import java.util.Arrays;

public class Code03_LongestCommonSubsequence {
    public static int longestCommonSubsequence(String text1, String text2) {
        char[] s1 = text1.toCharArray();
        char[] s2 = text2.toCharArray();
        dp = new int[s1.length][s2.length];
        for (int[] ints : dp) {
            Arrays.fill(ints, -1);
        }
        return localMaxValue(s1, s2, 0, 0);
    }

    public static int[][] dp;

    public static int localMaxValue(char[] s1, char[] s2, int index1, int index2) {
        if (index1 == s1.length || index2 == s2.length) {
            return 0;
        }
        if (dp[index1][index2] != -1) {
            return dp[index1][index2];
        }
        if (s1[index1] == s2[index2]) {
            dp[index1][index2] = 1 + localMaxValue(s1, s2, index1 + 1, index2 + 1);
        } else {
            dp[index1][index2] = Math.max(localMaxValue(s1, s2, index1 + 1, index2), localMaxValue(s1, s2, index1, index2 + 1));
        }
        return dp[index1][index2];
    }

    public static int bottomToTop(String text1, String text2) {
        char[] s1 = text1.toCharArray();
        char[] s2 = text2.toCharArray();
        int[][] dp = new int[s1.length][s2.length];
        if (s1[s1.length - 1] == s2[s2.length - 1]) {
            dp[s1.length - 1][s2.length - 1] = 1;
        }
        for (int j = s2.length - 2; j >= 0; j--) {
            int i = s1.length - 1;
            if (s1[i] == s2[j]) {
                dp[i][j] = 1;
            } else {
                dp[i][j] = dp[i][j + 1];
            }
        }
        for (int i = s1.length - 2; i >= 0; i--) {
            int j = s2.length - 1;
            if (s1[i] == s2[j]) {
                dp[i][j] = 1;
            } else {
                dp[i][j] = dp[i + 1][j];
            }
        }
        for (int i = s1.length - 2; i >= 0; i--) {
            for (int j = s2.length - 2; j >= 0; j--) {
                if (s1[i] == s2[j]) {
                    dp[i][j] = 1 + dp[i + 1][j + 1];
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j + 1]);
                }
            }
        }
        return dp[0][0];
    }

    public static int bottomToTopSmaller(String text1, String text2) {
        char[] s1 = text1.toCharArray();
        char[] s2 = text2.toCharArray();
        int[] dp = new int[s2.length + 1];
        for (int i = s1.length - 1; i >= 0; i--) {
            int rightDown = 0, backup;
            for (int j = s2.length - 1; j >= 0; j--) {
                backup = dp[j];
                if (s1[i] == s2[j]) {
                    dp[j] = 1 + rightDown;
                } else {
                    dp[j] = Math.max(dp[j], dp[j + 1]);
                }
                rightDown = backup;
            }
        }
        return dp[0];
    }

    public static void main(String[] args) {
        for (int k = 0; k < 10000; k++) {
            int len1 = (int) (Math.random() * 8 + 3);
            int len2 = (int) (Math.random() * 8 + 3);
            StringBuilder sb = new StringBuilder();
            // a~z 97-122
            for (int i = 0; i < len1; i++) {
                sb.append((char) ((Math.random() * 26) + 97)); // 26
            }
            String text1 = sb.toString();
            sb.delete(0, sb.length());
            for (int i = 0; i < len2; i++) {
                sb.append((char) ((Math.random() * 26) + 97)); // 26
            }
            String text2 = sb.toString();
            int compare = bottomToTopSmaller(text1, text2);
            int ans = longestCommonSubsequence(text1, text2);
            if (compare != ans) {
                System.out.println("错误答案：" + compare);
                System.out.println("正确答案：" + ans);
                System.out.println(text1);
                System.out.println(text2);
                break;
            }
        }
        System.out.println("执行结束");

        String s1 = "ebbacbd";
        String s2 = "adbbc";
        String s11 = "abcde";
        String s22 = "ace";
        System.out.println(bottomToTopSmaller(s1, s2));
        System.out.println(longestCommonSubsequence(s1, s2));
    }
}
