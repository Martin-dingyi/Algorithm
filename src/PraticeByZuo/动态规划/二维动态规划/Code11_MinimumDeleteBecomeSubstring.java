package ByMartinPratice.动态规划.二维动态规划;

// 删除至少几个字符可以变成另一个字符串的子串
// 给定两个字符串s1和s2
// 返回s1至少删除多少字符可以成为s2的子串
// 对数器验证

import java.util.ArrayList;

public class Code11_MinimumDeleteBecomeSubstring {
    public static int getMinDelete(String str1, String str2) {
        char[] s1 = str1.toCharArray();
        char[] s2 = str2.toCharArray();

        return localMin(s1, s2, s1.length, s2.length);
    }

    public static int localMin(char[] s1, char[] s2, int len1, int len2) {
        if (len1 == 0) {
            return 0;
        }
        if (len2 == 0) {
            // 如果len1不为0而len2为零，则只有删除s1剩下的所有字符才行
            return len1;
        }
        int a1 = Integer.MAX_VALUE;
        int a2 = Integer.MAX_VALUE, a3;
        if (s1[len1 - 1] == s2[len2 - 1]) {
            // 相等时，不用删，两指针同时往前移动继续寻找
            a1 = localMin(s1, s2, len1 - 1, len2 - 1);
        } else {
            // 不相等时，要删这个字符，只移动len1然后继续寻找
            a2 = 1 + localMin(s1, s2, len1 - 1, len2);
        }
        // 不管该字符相不相等，都要移动len2尝试寻找合法情况
        a3 = localMin(s1, s2, len1, len2 - 1);
        return Math.min(a1, Math.min(a2, a3));
    }

    public static int btts(String str1, String str2) {
        char[] s1 = str1.toCharArray();
        char[] s2 = str2.toCharArray();
        int n = s2.length;
        int m = s1.length;
        int[] dp = new int[m + 1];
        for (int i = 1; i <= m; i++) {
            dp[i] = i;
        }
        for (int i = 1; i <= n; i++) {
            int leftUp = 0, backup;
            for (int j = 1; j <= m; j++) {
                backup = dp[j];
                if (s1[j - 1] == s2[i - 1]) {
                    dp[j] = Math.min(dp[j], leftUp);
                } else {
                    dp[j] = Math.min(dp[j], 1 + dp[j - 1]);
                }
                leftUp = backup;
            }
        }
        return dp[m];
    }

    public static int compare(String str1, String str2) {
        char[] s1 = str1.toCharArray();
        char[] s2 = str2.toCharArray();
        // 将str2的子串全部列出来
        ArrayList<String> subStr2 = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        subStr2.add("");
        for (int i = 0; i < s2.length; i++) {
            int size = subStr2.size();
            for (int j = 0; j < size; j++) {
                sb.append(subStr2.get(j)).append(s2[i]);
                subStr2.add(sb.toString());
                sb = new StringBuilder();
            }
        }
        // 将str1的子串全部列出来
        ArrayList<String> subStr1 = new ArrayList<>();
        sb = new StringBuilder();
        subStr1.add("");
        for (int i = 0; i < s1.length; i++) {
            int size = subStr1.size();
            for (int j = 0; j < size; j++) {
                sb.append(subStr1.get(j)).append(s1[i]);
                subStr1.add(sb.toString());
                sb = new StringBuilder();
            }
        }
        int ans = s1.length;
        for (String val1 : subStr1) {
            for (String val2 : subStr2) {
                if (val1.equals(val2)) {
                    ans = Math.min(ans, s1.length - val1.length());
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10000; i++) {
            int n = (int) (Math.random() * 10);
            int m = (int) (Math.random() * 20);
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < n; j++) {
                sb.append((char) ((Math.random() * 26) + 97));
            }
            String s1 = sb.toString();
            sb = new StringBuilder();
            for (int j = 0; j < m; j++) {
                sb.append((char) ((Math.random() * 26) + 97));
            }
            String s2 = sb.toString();
            if (btts(s1, s2) != getMinDelete(s1, s2)) {
                System.out.println("出错了，两字符串为：");
                System.out.println(s1);
                System.out.println(s2);
                System.out.println("错误答案：" + btts(s1, s2));
                System.out.println("正确答案："  + getMinDelete(s1, s2));
                break;
            }
        }
        System.out.println("========执行结束=========");
//        String s1 = "z";
//        String s2 = "xaxbxcx";
//        System.out.println(btts(s1, s2));
//        System.out.println(compare(s1, s2));

    }
}
