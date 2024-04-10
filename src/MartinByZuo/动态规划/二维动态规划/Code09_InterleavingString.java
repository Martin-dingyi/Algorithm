package MartinByZuo.动态规划.二维动态规划;

// 交错字符串
// 给定三个字符串 s1、s2、s3
// 请帮忙验证s3是否由s1和s2交错组成
// 测试链接 : https://leetcode.cn/problems/interleaving-string/
public class Code09_InterleavingString {
    public static boolean isInterleave(String s1, String s2, String s3) {
        char[] chars1 = s1.toCharArray();
        char[] chars2 = s2.toCharArray();
        char[] chars3 = s3.toCharArray();
        return localJudge(chars1, chars2, chars3, chars1.length, chars2.length, chars3.length);
    }

    public static boolean localJudge(char[] s1, char[] s2, char[] s3, int len1, int len2, int len3) {
        if (len1 + len2 != len3) {
            return false;
        } else if (len1 == 0 || len2 == 0) {
            // len1和len2至少有一个为0
            char[] NoZeroStr = len1 != 0 ? s1 : s2;
            int NoZeroLen = len1 != 0 ? len1 : len2;
            while (NoZeroLen > 0 && len3 > 0 && NoZeroStr[NoZeroLen - 1] == s3[len3 - 1]) {
                NoZeroLen--;
                len3--;
            }
            return len3 == 0;
        }
        return (s1[len1 - 1] == s3[len3 - 1] && localJudge(s1, s2, s3, len1 - 1, len2, len3 - 1)) ||
                (s2[len2 - 1] == s3[len3 - 1] && localJudge(s1, s2, s3, len1, len2 - 1, len3 - 1));
    }

    public static boolean bbt(String str1, String str2, String str3) {
        if (str1.length() + str2.length() != str3.length()) {
            return false;
        }
        char[] s1 = str1.toCharArray();
        char[] s2 = str2.toCharArray();
        char[] s3 = str3.toCharArray();
        int n = s1.length;
        int m = s2.length;
        boolean[][] dp = new boolean[n + 1][m + 1];
        dp[0][0] = true;
        for (int i = 1; i <= n; i++) {
            if (s1[i - 1] != s3[i - 1]) {
                break;
            }
            dp[i][0] = true;
        }
        for (int j = 1; j <= m; j++) {
            if (s2[j - 1] != s3[j - 1]) {
                break;
            }
            dp[0][j] = true;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                dp[i][j] = (s1[i - 1] == s3[i + j - 1] && dp[i - 1][j]) || (s2[j - 1] == s3[i + j - 1] && dp[i][j - 1]);
            }
        }
        return dp[n][m];
    }

    public static boolean bbts(String str1, String str2, String str3) {
        if (str1.length() + str2.length() != str3.length()) {
            return false;
        }
        char[] s1 = str1.toCharArray();
        char[] s2 = str2.toCharArray();
        char[] s3 = str3.toCharArray();
        int n = s1.length;
        int m = s2.length;
        boolean[] dp = new boolean[m + 1];
        if (s1.length > 0 && s2.length > 0) {
            dp[0] = s1[0] == s3[0];
        } else if (s1.length == s2.length) {
            dp[0] = true;
        }
        for (int j = 1; j <= m; j++) {
            if (s2[j - 1] != s3[j - 1]) {
                break;
            }
            dp[j] = true;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                dp[j] = (s1[i - 1] == s3[i + j - 1] && dp[j]) || (s2[j - 1] == s3[i + j - 1] && dp[j - 1]);
            }
        }
        return dp[m];
    }
    public static void main(String[] args) {
        String s1 = "aabcc", s2 = "dbbca", s3 = "aadbbcbcac";
        String s11 = "a", s22 = "", s33 = "aa";
        String s111 = "aab", s222 = "dbb", s333 = "aadbbb";
        System.out.println(bbt(s11, s22, s33));
        System.out.println(isInterleave(s11, s22, s33));
//        System.out.println(bbt(s111, s222, s333));
//        System.out.println(isInterleave(s111, s222, s333));
    }
}
