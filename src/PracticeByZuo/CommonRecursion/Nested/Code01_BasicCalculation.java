package PracticeByZuo.CommonRecursion.Nested;

import java.util.Stack;

// 题目：输入一个字符串类型的算式，计算它的值。
// 测试链接 : https://leetcode.cn/problems/basic-calculator-iii/
public class Code01_BasicCalculation {
    public static int calculate(String string) {
        int ans = 0;
        index = 0;
        char[] s = string.toCharArray();
        ans = calBracketValue(s);
        return ans;
    }

    public static int index;

    // 递归函数的作用：计算一对括号内算式的值。（假设原式由一对括号包括）
    public static int calBracketValue(char[] s) {
        int num = 0;
        Stack<Integer> numList = new Stack<>();
        Stack<Character> signList = new Stack<>();
        while (index < s.length && s[index] != ')') {
            if (s[index] >= '0' && s[index] <= '9') {
                // 1.扫描一个n位数
                num = num * 10 + s[index++] - '0';
            } else if (s[index] == '+' || s[index] == '-') {
                // 2.当扫描到符号时，数字一定被扫描完成
                numList.add(num);
                num = 0;
                signList.add(s[index++]);
            } else if (s[index] == '*' || s[index] == '/') {
                // 3.当遇到乘法或除法时，优先将此处的值算出来、
                int handledNum = 0;
                char calSign = s[index++];
                while (index < s.length) {
                    if (s[index] == '(') {
                        index++;
                        handledNum = calBracketValue(s);
                        break;
                    } else if (s[index] >= '0' && s[index] <= '9') {
                        handledNum = handledNum * 10 + s[index++] - '0';
                    } else {
                        break;
                    }
                }
                num = calSign == '*' ? num * handledNum : num / handledNum;
            } else if (s[index] == '(') {
                // 4.当遇到左括号时，说明需要先将括号内的值计算出来，由于计算的可能性有很多，所以使用递归调用。
                index++;
                num = calBracketValue(s);
            }
        }
        // 5.遇到右括号或者表达式扫描结束，退出来计算这组括号内表达式的值
        index++;
        numList.add(num);
        return getAnsByStack(numList, signList);
    }

    // 根据栈中的数据计算答案
    public static int getAnsByStack(Stack<Integer> numList, Stack<Character> signList) {
        int ans = 0;
        while (!signList.isEmpty()) {
            int num = numList.pop();
            ans += (signList.pop() == '+' ? num : -num);
        }
        return ans + numList.pop();
    }

    public static void main(String[] args) {
        String str1 = "36-(4*(3+2*(1-6))+5)+17";  // 76
        String str2 = "4*(3+2*(1-6))"; // -28
        String str3 = "30+16-4+3*2/2*4"; // 54
        System.out.println(calculate(str1));
        System.out.println(calculate(str2));
        System.out.println(calculate(str3));
    }
}
