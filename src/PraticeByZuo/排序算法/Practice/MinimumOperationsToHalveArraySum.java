package ByMartinPratice.排序算法.Practice;

import ByMartinPratice.Comparator;

import java.util.PriorityQueue;

/* 题目：将数组所有数的合记为sum，记数组将其中一个数据减半为一个操作
* 求需要多少次这样的操作才能将sum降到一半以下
* 分析：使用堆结构
* */
public class MinimumOperationsToHalveArraySum {
    public static int minimumOpToHalf (int[] arr) {
        double sum = 0;
        double temp = 0;
        int ans = 0;
        PriorityQueue<Double> heap = new PriorityQueue<>((a, b) -> b.compareTo(a));
        for (int i = 0; i < arr.length; i++) {
            heap.add((double) arr[i]);
            sum += arr[i];
        }
        sum /= 2;
        while (sum > 0) {
            temp = heap.poll() / 2;
            sum -= temp;
            heap.add(temp);
            ans++;
        }
        return ans;
    }

    // 提交时把halveArray1改名为halveArray
    public static int halveArray1(int[] nums) {
        // 大根堆
        PriorityQueue<Double> heap = new PriorityQueue<>((a, b) -> b.compareTo(a));
        double sum = 0;
        for (int num : nums) {
            heap.add((double) num);
            sum += num;
        }
        // sum，整体累加和，-> 要减少的目标！
        sum /= 2;
        int ans = 0;
        for (double minus = 0, cur; minus < sum; ans++, minus += cur) {
            cur = heap.poll() / 2;
            heap.add(cur);
        }
        return ans;
    }

    public static void main(String[] args) {
//        int[] arr = {50, 50, 100, 20};
        Comparator cp = new Comparator();
        boolean success = true;
        for (int i = 0; i < 500000; i++) {
            int[] arr = cp.generateRandomArray(10, 10);
            if (minimumOpToHalf(arr) != halveArray1(arr)) {
                cp.print(arr);
                success = false;
                break;
            }
        }
        cp.check(success);
    }
}
