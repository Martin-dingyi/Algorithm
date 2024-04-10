package MartinByZuo.栈和队列;

import java.util.Arrays;
import java.util.Stack;

// 题目：设计一个时间复杂度为1的函数，作用为获得栈中的最小值
public class Code05_GetMinStack {
    public static class MyStack {
        Stack<Integer> stack;
        Stack<Integer> min;
        int preValue;

        public MyStack() {
            stack = new Stack<>();
            min = new Stack<>();
            preValue = -1;
        }

        public void push(int value) {
            stack.push(value);
            if (min.isEmpty() || value < min.peek()) {
                preValue = value;
                min.push(value);
            }
            else
                min.push(preValue);
        }

        public int pop() {

            min.pop();
            return stack.pop();
        }

        public int getMin() {
            if (min.isEmpty())
                throw new RuntimeException("栈空");
            return min.peek();
        }
    }

    public static void main(String[] args) {
        MyStack ms = new MyStack();
        for (int i = 0; i < 10; i++) {
            ms.push((int) (Math.random() * 10));
        }
        for (int i = 0; i < 10; i++) {
            System.out.println("=====新的一趟========");
            ms.pop();
            System.out.println(Arrays.toString(ms.stack.toArray(new Integer[0])));
            System.out.println(ms.getMin());
        }



    }
}
