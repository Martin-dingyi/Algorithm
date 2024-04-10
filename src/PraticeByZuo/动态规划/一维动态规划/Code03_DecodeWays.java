package ByMartinPratice.动态规划.一维动态规划;

// 解码方法
// 一条包含字母 A-Z 的消息通过以下映射进行了 编码 ：
// 'A' -> "1"
// 'B' -> "2"
// ...
// 'Z' -> "26"
// 要 解码 已编码的消息，所有数字必须基于上述映射的方法，反向映射回字母（可能有多种方法）
// 例如，"11106" 可以映射为："AAJF"、"KJF"
// 注意，消息不能分组为(1 11 06)，因为 "06" 不能映射为 "F"
// 这是由于 "6" 和 "06" 在映射中并不等价
// 给你一个只含数字的 非空 字符串 s ，请计算并返回 解码 方法的 总数
// 题目数据保证答案肯定是一个 32位 的整数
// 测试链接 : https://leetcode.cn/problems/decode-ways/
public class Code03_DecodeWays {
    public static int[] dp;
    public static int numDecodings(String s) {
        char[] chars = s.toCharArray();
        dp = new int[chars.length + 1];
//        Arrays.fill(dp, 0);
//        return topToBottom(char-s, 0);
        return bottomToTop(chars);
    }

    // 递归函数作用：得到chars数组中index之后的有多少种解码方法
    public static int decodingCountOfNth(char[] chars, int index) {
        if (index == chars.length) {
            return 1;
        }
        int ans = 0;
        int num = chars[index] - '0';
        if (num == 0) {
            return 0;
        }
        if (num >= 1 && num <= 9) {
            ans += decodingCountOfNth(chars, index + 1);
        }
        index++;
        if (index < chars.length) {
            num = num * 10 + chars[index] - '0';
            if (num >= 1 && num <= 26) {
                ans += decodingCountOfNth(chars, index + 1);
            }
        }
        return ans;
    }

    public static int topToBottom(char[] chars, int index) {
        if (index == chars.length) {
            return 1;
        }
        int ans = 0;

        if (dp[index] != 0) {
            return dp[index];
        }

        int num = chars[index] - '0';
        if (num == 0) {
            return 0;
        }
        if (num >= 1 && num <= 9) {
            ans += topToBottom(chars, index + 1);
        }
        index++;
        if (index < chars.length) {
            num = num * 10 + chars[index] - '0';
            if (num >= 1 && num <= 26) {
                ans += topToBottom(chars, index + 1);
            }
        }
        dp[index - 1] = ans;
        return ans;
    }

    public static int bottomToTop(char[] s) {
        int prePrevious = 1, previous = 1;
        // 6 06 10 26 31
        for (int i = s.length - 1; i >= 0; i--) {
            int temp = previous;
            if (s[i] == '0') {
                previous = 0;
            } else if (i + 1 < s.length && (s[i] - '0') * 10 + s[i + 1] - '0' <= 26) {
                previous = prePrevious + previous;
            }
            // 如果num等于10或者大于26，previous不变
            prePrevious = temp;
        }
        return previous;
    }

    public static void main(String[] args) {
        String s1 = "111111111111111111111111111111111111111111111"; // 1836311903
        String s2 = "123123";
        String s3 = "230";
        String s4 = "10";
        System.out.println(numDecodings(s1));
        System.out.println(topToBottom(s1.toCharArray(), 0));
    }


}
