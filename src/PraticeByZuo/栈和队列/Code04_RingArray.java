package ByMartinPratice.栈和队列;

import java.util.Arrays;

// 数组实现（循环）队列
public class Code04_RingArray {
    public static class ArrayToQueue {
        int maxSize;
        int size;
        int begin, end;
        int[] arr;

        public ArrayToQueue(int maxSize) {
            this.maxSize = maxSize;
            size = 0;
            begin = 0;
            end = 0;
            arr = new int[maxSize];
        }

        public void push(int value) {
            if (size == maxSize) {
                throw new RuntimeException("队列满");
            }
            arr[begin] = value;
            if ((begin + 1) < maxSize) {
                begin++;
            } else{
                begin = 0;
            }
            size++;
        }

        public int pop() {
            if (size == 0) {
                throw new RuntimeException("队列空");
            }
            int value = arr[end];
            if ((end + 1) <maxSize) {
                end++;
            } else {
                end = 0;
            }
            size--;
            return value;
        }
    }

    public static void main(String[] args) {
        ArrayToQueue aq = new ArrayToQueue(4);
        for (int i = 0; i < 4; i++) {
            aq.push(i);
        }
        System.out.println(aq.pop());
        aq.push(20);
        for (int i = 0; i < 4; i++) {
            System.out.println(aq.pop());
        }
        System.out.println(Arrays.toString(aq.arr));
    }
}
