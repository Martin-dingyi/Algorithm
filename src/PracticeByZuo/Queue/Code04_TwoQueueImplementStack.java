package PracticeByZuo.Queue;

import java.util.LinkedList;
import java.util.Queue;

// 题目：使用队列实现栈
public class Code04_TwoQueueImplementStack {
    public static class QueueToStack{
        Queue<Integer> queue, tempQueue;

        public QueueToStack() {
            queue = new LinkedList<>();
            tempQueue = new LinkedList<>();
        }

        public void push(int value) {
            // 每次放数据时，都将queue中的数按序暂时存储在tempQueue中
            if (queue.isEmpty()) {
                queue.add(value);
            } else {
                while(!queue.isEmpty()) {
                    tempQueue.add(queue.remove());
                }
                queue.add(value);
                while(!tempQueue.isEmpty()) {
                    queue.add(tempQueue.remove());
                }
            }
        }

        public int pop() {
            return queue.remove();
        }
    }

    public static void main(String[] args) {
        QueueToStack qts = new QueueToStack();
        for (int i = 0; i < 10; i++) {
            qts.push(i);
        }
        for (int i = 0; i < 10; i++) {
            System.out.println(qts.queue.remove());
        }
    }
}
