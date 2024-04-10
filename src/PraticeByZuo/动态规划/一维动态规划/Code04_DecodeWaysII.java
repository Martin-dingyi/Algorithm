package ByMartinPratice.动态规划.一维动态规划;

// 解码方法 II
// 一条包含字母 A-Z 的消息通过以下的方式进行了 编码 ：
// 'A' -> "1"
// 'B' -> "2"
// ...
// 'Z' -> "26"
// 要 解码 一条已编码的消息，所有的数字都必须分组
// 然后按原来的编码方案反向映射回字母（可能存在多种方式）
// 例如，"11106" 可以映射为："AAJF"、"KJF"
// 注意，像 (1 11 06) 这样的分组是无效的，"06"不可以映射为'F'
// 除了上面描述的数字字母映射方案，编码消息中可能包含 '*' 字符
// 可以表示从 '1' 到 '9' 的任一数字（不包括 '0'）
// 例如，"1*" 可以表示 "11"、"12"、"13"、"14"、"15"、"16"、"17"、"18" 或 "19"
// 对 "1*" 进行解码，相当于解码该字符串可以表示的任何编码消息
// 给你一个字符串 s ，由数字和 '*' 字符组成，返回 解码 该字符串的方法 数目
// 由于答案数目可能非常大，返回10^9 + 7的模
// 测试链接 : https://leetcode.cn/problems/decode-ways-ii/
public class Code04_DecodeWaysII {
    public static long mod = 1000000007;

    public static int numDecodings(String s) {
        int ans = 0;
        char[] chars = s.toCharArray();
        return ans;
    }

    // 递归函数作用：计算s数组中index之后有多少种解码情况
    public static int f(char[] s, int index) {
        int ans = 0;
        if (s[index] == '0') {
            return 0;
        }
        return ans;
    }

    public static long bottomToTop(String s) {
        char[] chars = s.toCharArray();
        long lastLast = 1, last = 1;
        // 6 06 10 26 31
        for (int i = chars.length - 1; i >= 0; i--) {
            long temp = last;
            // 遇到*x时的处理
            if (chars[i] == '*') {
                if (i == chars.length - 1) {
                    last = 9;
                } else if (chars[i + 1] == '*') {
                    last = last * 9 + lastLast * 15;
                } else if (chars[i + 1] >= '0' && chars[i + 1] <= '6') {
                    last = last * 9 + lastLast * 2;
                } else {
                    last = last * 9 + lastLast;
                }
            } else if (chars[i] == '0') {
                last = 0;
            } else if (i + 1 < chars.length && chars[i + 1] != '*') {
                // 遇到x*的处理
                if (((chars[i] - '0') * 10 + chars[i + 1] - '0' <= 26)) {
                    last = lastLast + last;
                }
                // 如果num等于10或者大于26，last不变
            } else if (i + 1 < chars.length && chars[i + 1] == '*') {
                if (chars[i] == '1') {
                    last = last + 9 * lastLast;
                } else if (chars[i] == '2') {
                    last = last + 6 * lastLast;
                }
            }
            last %= mod;
            lastLast = temp;
        }
        return (int) last;
    }

    // 我觉得这个版本的逻辑性更强一些
    public static long temp(String str) {
        char[] s = str.toCharArray();
        long prePrevious = 0, pre = 1;
        long cur = 0;
        // cur依赖于pp和pre，每次计算cur时，要根据9种实际情况作出调整：
        for (int i = s.length - 1; i >= 0; i--) {
            if (s[i] == '0') {
                cur = 0;
            } else if (s[i] == '*') {
                cur = 9 * pre;
                if (i + 1 < s.length) {
                    if (s[i + 1] == '*') {
                        cur += prePrevious * 15;
                    } else if (s[i + 1] >= '0' && s[i + 1] <= '6') {
                        cur += prePrevious * 2;
                    } else {
                        cur += prePrevious;
                    }
                }
            } else if (i + 1 < s.length && s[i] == '1' && s[i + 1] == '*') {
                cur = pre + 9 * prePrevious;
            } else if (i + 1 < s.length && s[i] == '2' && s[i + 1] == '*') {
                cur = pre + 6 * prePrevious;
            } else if (i + 1 < s.length && s[i + 1] != '*' && (s[i] - '0') * 10 + s[i + 1] - '0' <= 26) {
                cur = pre + prePrevious;
            } else {
                // s[i] >= '3' && s[i] <= '9' 或者 27,28,29
                cur = pre;
            }
            cur %= mod;
            prePrevious = pre;
            pre = cur;
        }
        return (int) cur;
    }

    public static void main(String[] args) {
        String s1 = "*0";
        String s2 = "7*9*3*6*3*0*5*4*9*7*3*7*1*8*3*2*0*0*6*";
        String s3 = "*********";
        String s4 = "123123";
        System.out.println(temp(s1));
        System.out.println(bottomToTop(s1));
    }
}
