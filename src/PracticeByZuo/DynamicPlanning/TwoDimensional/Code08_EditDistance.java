package PracticeByZuo.DynamicPlanning.TwoDimensional;


// 编辑距离
// 给你两个单词 word1 和 word2
// 请返回将 word1 转换成 word2 所使用的最少代价
// 你可以对一个单词进行如下三种操作：
// 插入一个字符，代价a
// 删除一个字符，代价b
// 替换一个字符，代价c
// 测试链接 : https://leetcode.cn/problems/edit-distance/
public class Code08_EditDistance {
    public static int a = 1, b = 1, c = 1;
    public static int minDistance(String word1, String word2) {
        char[] s1 = word1.toCharArray();
        char[] s2 = word2.toCharArray();
        return localMin(s1, s2, s1.length, s2.length);
    }

    public static int localMin(char[] s1, char[] s2, int len1, int len2) {
        if (len1 == 0) {
            return len2 * a;
        }
        if (len2 == 0) {
            return len1 * b;
        }
        if (s1[len1 - 1] == s2[len2 - 1]) {
            return localMin(s1, s2, len1 - 1, len2 - 1);
        } else {
            // 插入、删除和替换三种处理字符不一致时的方案
            return Math.min(Math.min(localMin(s1, s2, len1, len2 - 1) + a, localMin(s1, s2, len1 - 1, len2 - 1) + c), localMin(s1, s2, len1 - 1, len2) + b);
        }
    }

    public static int btt(String word1, String word2) {
        char[] s1 = word1.toCharArray();
        char[] s2 = word2.toCharArray();
        int n = s1.length;
        int m = s2.length;
        int[][] dp = new int[n + 1][m + 1];
        for (int j = 1; j <= m; j++) {
            dp[0][j] = j * a;
        }
        for (int i = 1; i <= n; i++) {
            dp[i][0] = i * b;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (s1[i - 1] == s2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(Math.min(dp[i][j - 1] + a, dp[i - 1][j - 1] + c), dp[i - 1][j] + b);
                }
            }
        }
        return dp[n][m];
    }

    public static int btts(String word1, String word2) {
        char[] s1 = word1.toCharArray();
        char[] s2 = word2.toCharArray();
        int n = s1.length;
        int m = s2.length;
        int[] dp = new int[m + 1];
        for (int i = 0; i <= m; i++) {
            dp[i] = i * a;
        }
        for (int i = 1; i <= n; i++) {
            int leftUp = dp[0], backup;
            dp[0] += b;
            for (int j = 1; j <= m; j++) {
                backup = dp[j];
                if (s1[i - 1] == s2[j - 1]) {
                    dp[j] = leftUp;
                } else {
                    dp[j] = Math.min(Math.min(dp[j - 1] + a, leftUp + c), dp[j] + b);
                }
                leftUp = backup;
            }
        }
        return dp[m];
    }

    public static void main(String[] args) {
        String word1 = "horse", word2 = "ros";
        System.out.println(btts(word1, word2));
        System.out.println(minDistance(word1, word2));
    }
}
