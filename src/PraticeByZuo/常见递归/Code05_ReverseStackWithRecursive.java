package ByMartinPratice.常见递归;

import java.util.Stack;

// 题目：用递归函数逆序栈
public class Code05_ReverseStackWithRecursive {
    public static void reverseStack(Stack<Integer> stack) {
        if (stack.isEmpty()) {
            return;
        }
        int num = down(stack);
        reverseStack(stack);
        stack.push(num);
    }

    // 将栈底元素返回，并将所有元素向下压一位（抽掉栈底元素）
    // 假设调用该方法时，栈必不为空
    public static int down(Stack<Integer> stack) {
        int num = stack.pop();
        // 栈为空，说明这个num是栈底元素
        if (stack.isEmpty()) {
            return num;
        }
        int downNum = down(stack);
        stack.push(num);
        return downNum;
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(4);
        stack.push(3);
        stack.push(7);
        stack.push(1);
        stack.push(6);
        for (Integer i : stack) {
            System.out.print(i + ",");
        }
        System.out.println();
        reverseStack(stack);
        for (Integer i : stack) {
            System.out.print(i + ",");
        }
    }
}
