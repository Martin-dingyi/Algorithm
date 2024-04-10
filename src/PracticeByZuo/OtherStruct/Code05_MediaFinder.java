package PracticeByZuo.OtherStruct;

import java.util.PriorityQueue;

// 题目：快速获得数据流的中位数的结构
// 分析：使用大小根堆分割数据流
public class Code05_MediaFinder {
    static class MedianFinder {
        PriorityQueue<Integer> left;
        PriorityQueue<Integer> right;

        public MedianFinder() {
            left = new PriorityQueue<>((a, b) -> (b - a));
            right = new PriorityQueue<>((a, b) -> (a - b));
        }

        public void addNum(int num) {
            if (left.isEmpty() || num <= left.peek()) {
                left.add(num);
            } else {
                right.add(num);
            }
            if (Math.abs(left.size() - right.size()) == 2) {
                balance();
            }
        }

        public double findMedian() {
            if (left.isEmpty()) {
                return -1;
            }
            int n = left.size() + right.size();
            if (n % 2 != 0) {
                if (left.size() >= right.size()) {
                    return left.peek();
                } else {
                    return right.peek();
                }
            } else {
                return (double) (left.peek() + right.peek()) / 2;
            }
        }

        public void balance() {
            if (left.size() > right.size()) {
                right.add(left.poll());
            } else {
                left.add(right.poll());
            }
        }
    }

    public static void main(String[] args) {
        MedianFinder mf = new MedianFinder();
        mf.addNum(2);
        mf.addNum(3);
//        mf.addNum(4);
        System.out.println(mf.findMedian());
    }
}
