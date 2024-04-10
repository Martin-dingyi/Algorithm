package ByMartinPratice.常见递归;

import java.util.Stack;

// 题目：用递归实现栈排序，不允许申请像栈、队列、数组这样的大结构
public class Code06_SortStackWithRecursive {
    // 1.获得栈中的最大值
    public static int getMax(Stack<Integer> stack, int size) {
        if (size == 0) {
            return Integer.MIN_VALUE;
        }
        int num = stack.pop();
        int ans = Math.max(num, getMax(stack, size - 1));
        stack.push(num);
        return ans;
    }

    // 2.获得该最大值出现的频次k
    public static int getMaxFrequency(Stack<Integer> stack, int max, int size) {
        if (size == 0) {
            return 0;
        }
        int ans = 0;
        int num = stack.pop();
        if (num == max) {
            ans++;
        }
        ans += getMaxFrequency(stack, max, size - 1);
        stack.push(num);
        return ans;
    }

    // 3.将最大值抽出来，并把它上面的数都压下去一位。抽k次
    public static void banishMax(Stack<Integer> stack, int max, int size) {
        if (size == 0) {
            return;
        }
        int num = stack.pop();
        banishMax(stack, max, size - 1);
        if (num != max) {
            stack.push(num);
        }
    }

    // 4.将所有该最大值放到栈底，且不改变栈元素的相对位置
    public static void pushMax(Stack<Integer> stack, int max, int k, int size) {
        if (size == 0) {
            for (int i = 0; i < k; i++) {
                stack.push(max);
            }
            return;
        }
        int num = stack.pop();
        pushMax(stack, max, k, size - 1);
        stack.push(num);
    }

    public static void sortStack(Stack<Integer> stack, int size) {
        if (size == 0) {
            return;
        }
        int max = getMax(stack, size);
        int k = getMaxFrequency(stack, max, size);
        banishMax(stack, max, size);
        pushMax(stack, max, k, size - k);
        sortStack(stack, size - k);
    }



    public static void main(String[] args) {
        for (int i = 0; i < 500000; i++) {
            Stack<Integer> stack = getRandomStack(10, 10);
            int size = stack.size();
            sortStack(stack, stack.size());
            if (!isSorted(stack)) {
                printStack(stack);
                System.out.println("失败！");
                return;
            }
        }
        System.out.println("成功！");
    }

    public static Stack<Integer> getRandomStack(int maxValue, int maxSize) {
        Stack<Integer> stack = new Stack<>();
        int size = (int) (Math.random() * maxSize);
        for (int i = 0; i < size; i++) {
            int num = (int) ((int) (Math.random() * (maxValue + 1))
                    - (int) (Math.random() * maxValue));
            stack.push(num);
        }
        return stack;
    }

    public static boolean isSorted(Stack<Integer> stack) {
        if (stack.isEmpty()) {
            return true;
        }
        int topNum = stack.pop();
        while (!stack.isEmpty()) {
            if (stack.peek() < topNum) {
                return false;
            }
            topNum = stack.pop();
        }
        return true;
    }

    public static void printStack(Stack<Integer> stack) {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (Integer num : stack) {
            sb.append(num).append(",");
        }
        sb.deleteCharAt(sb.length() - 1);
        sb.append("]");
        System.out.println(sb.toString());
    }
}
