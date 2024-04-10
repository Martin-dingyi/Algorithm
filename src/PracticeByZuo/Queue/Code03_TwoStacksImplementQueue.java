package PracticeByZuo.Queue;

import java.util.Stack;

// 用两个栈实现队列
public class Code03_TwoStacksImplementQueue {
    public static class StackToQueue {
        // 每次放数据时，都将数据压入inStack，每次取数据时，检查outStack是否为空
        // 若是则将inStack的数据按序压入outStack，否则直接从outStack中取数据
        Stack<Integer> inStack, outStack;
        public StackToQueue() {
            inStack = new Stack<>();
            outStack = new Stack<>();
        }

        public void push(int value) {
            inStack.push(value);
        }

        public int pop() {
            if (outStack.isEmpty()) {
                while (!inStack.isEmpty()) {
                    outStack.push(inStack.pop());
                }
            }
            return outStack.pop();
        }
    }

    public static void main(String[] args) {
        StackToQueue stq = new StackToQueue();
        for (int i = 0; i < 10; i++) {
            stq.push(i);
        }
        for (int i = 0; i < 10; i++) {
            System.out.println(stq.pop());
        }
    }
}
