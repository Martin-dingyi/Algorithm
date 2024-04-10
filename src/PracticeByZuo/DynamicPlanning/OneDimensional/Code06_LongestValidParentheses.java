package PracticeByZuo.DynamicPlanning.OneDimensional;

import java.util.Stack;

// 题目：一个字符串只有')'和'('，求当中最大有效括号组的长度。
// 最大有效括号组指的是：()()这种并列结果或者(())或者这种嵌套结构，它们两的长度都是4
// 测试链接 : https://leetcode.cn/problems/longest-valid-parentheses/
public class Code06_LongestValidParentheses {
    public static int longestValidParentheses(String str) {
        if (str.length() < 2) {
            return 0;
        }
        char[] s = str.toCharArray();
        int ans = 0;
        // validLen指的是从右往左数，下标为i的右括号和它匹配的左括号之间有效括号组的长度是多少（包括它本身）
        // 如果i指向的位置是左括号，则值为0。
        int[] validLen = new int[s.length];
        for (int i = 1; i < s.length; i++) {
            if (s[i] == ')') {
                int j = i - 1;
                if (s[j] == '(') {
                    // 需要将改组括号左边邻接位置的有效括号长度一起加进来
                    validLen[i] = 2 + (j - 1 >= 0 ? validLen[j - 1] : 0);
                } else {
                    // 如果该右括号左边一位不是左括号，则需要在左边邻接有效括号组的左边找匹配的左括号。
                    int index = j - validLen[j];
                    if (index >= 0) {
                        if (s[index] == '(') {
                            validLen[i] = 2 + validLen[j] + (index - 1 >= 0 ? validLen[index - 1] : 0);
                        }
                    }
                }
            }
            ans = Math.max(validLen[i], ans);
        }
        return ans;
    }

    public static int longestValidParentheses_Reverse(String str) {
        if (str.length() < 2) {
            return 0;
        }
        char[] s = str.toCharArray();
        int ans = 0;
        // validLen指的是从左往右数，下标为i的左括号和它匹配的右括号之间有效括号组的长度是多少（包括它本身）
        // 如果i指向的位置是右括号，则值为0。
        int[] validLen = new int[s.length];
        for (int i = s.length - 2; i >= 0; i--) {
            if (s[i] == '(') {
                int rightNeighborIndex = i + 1;
                if (s[rightNeighborIndex] == ')') {
                    validLen[i] = 2 + (rightNeighborIndex + 1 < s.length ? validLen[rightNeighborIndex + 1] : 0);
                } else {
                    int possibleRightPare = rightNeighborIndex + validLen[rightNeighborIndex];
                    if (possibleRightPare < s.length && s[possibleRightPare] == ')') {
                        validLen[i] = 2 + validLen[rightNeighborIndex] + (possibleRightPare + 1 < s.length ? validLen[possibleRightPare + 1] : 0);
                    }
                }
            }
            ans = Math.max(ans, validLen[i]);
        }
        return ans;
    }
    public static int comparator(String str) {
        if (str.length() < 2) {
            return 0;
        }
        char[] s = str.toCharArray();
        int ans;
        int last = 0, len = 0;
        // dp表的含义是：这个位置对应的有效括号组长度(向右看）+ 左边和它相邻的有效括号组的长度
        // 其中右括号的值全部都是0，因为右括号不可能组成有效括号组。
        int[] dp = new int[s.length];
        for (int i = 0; i < s.length; i++) {
            if (s[i] == '(') {
                Stack<Character> stack = new Stack<>();
                int j;
                for (j = i + 1; j < s.length; j++) {
                    if (s[j] == '(') {
                        stack.push(s[j]);
                    } else {
                        if (stack.isEmpty()) {
                            stack.push(')');
                            break;
                        } else {
                            len += 2;
                            stack.pop();
                        }
                    }
                }
                if (stack.isEmpty() || stack.peek() == '(') {
                    last = 0;
                } else if (stack.peek() == ')') {
                    dp[i] = len + 2 + last;
                    last = dp[i];
                    i = j;
                }
                len = 0;
            } else {
                last = 0;
            }
        }
        ans = dp[0];
        for (int value : dp) {
            if (value > ans) {
                ans = value;
            }
        }
        return ans;
    }
    public static int comparator2(String str) {
        if (str.length() < 2) {
            return 0;
        }
        char[] s = str.toCharArray();
        int ans = 0, lastValue = 0;
        int[] dp = new int[s.length];
        for (int i = 0; i < s.length; i++) {
            if (s[i] == '(' && i + 1 < s.length) {
                if (dp[i] != 0) {
                    i = i + dp[i] - 1;
                    lastValue = i < s.length ? dp[i] : 0;
                } else if (s[i + 1] == ')') {
                    dp[i] = 2 + lastValue;
                    lastValue = dp[i];
                    ans = Math.max(dp[i], ans);
                    i++;
                } else {
                    // 如果是嵌套，设置整个嵌套结构+前面的有效括号
                    // 如果不嵌套，设为0。且将遍历到的有效结构的长度设置好
                    // 下面两个变量分别代表左右括号的数量
                    int left = 2, right = 0;
                    int index = i + 2;
                    while (left > right && index < s.length) {
                        if (s[index++] == '(') {
                            left++;
                        } else {
                            right++;
                        }
                    }
                    if (left == right) {
                        int temp = i + left * 2 - 1;
                        dp[i] = left * 2 + lastValue;
                        ans = Math.max(dp[i], ans);
                        lastValue = dp[i];
                        i = temp;
                    } else {
                        lastValue = 0;
                    }
                }
            } else {
                lastValue = 0;
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 1; i++) {
            int stringSize = (int) (Math.random() * 200);
            for (int j = 0; j < stringSize; j++) {
                double randomNum = Math.random();
                char randomPare;
                if (randomNum < 0.5) {
                    randomPare = '(';
                } else {
                    randomPare = ')';
                }
                sb.append(randomPare);
            }
            if (longestValidParentheses(sb.toString()) != longestValidParentheses_Reverse(sb.toString())) {
                System.out.println("执行出错");
                System.out.println(sb.toString());
                break;
            }
        }
        System.out.println("执行结束");

        String s1 = "()(()"; // 2
        String s2 = ")()()("; // 4
        String s3 = "(()())"; // (()2
        String s4 = ")()())()()("; // 4
        String s5 = ")(((((()())()()))()(()))("; // 22
        String s6 = "(()(((())))()"; // 12
//        System.out.println(longestValidParentheses(s1));
//        System.out.println(longestValidParentheses(s2));
//        System.out.println(longestValidParentheses(s3));
//        System.out.println(longestValidParentheses(s4));
//        System.out.println(longestValidParentheses(s5));
//        System.out.println(longestValidParentheses(s6));
    }
}
