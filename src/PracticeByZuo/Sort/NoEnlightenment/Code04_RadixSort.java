package PracticeByZuo.Sort.NoEnlightenment;

import PracticeByZuo.Comparator;

import java.util.LinkedList;

public class Code04_RadixSort {
    public static void radixSort (int[] arr) {
        // 处理负数
        int min = getMin(arr);
        if (min < 0) {
            for (int i = 0; i < arr.length; i++) {
                arr[i] += -min;
            }
        }
        // 先假设是一个十进制的数
        LinkedList<Integer>[] lists = new LinkedList[10];
        for (int i = 0; i < 10; i++) {
            lists[i] = new LinkedList<>();
        }
        int a = 1;
        int index, d;
        d = getMaxNum(arr);
        for (int i = 0; i < d; i++) {
            for (int j = 0; j < arr.length; j++) {
                index = arr[j] / a % 10;
                lists[index].add(arr[j]);
            }
            index = 0;
            for (int j = 0; j < 10; j++) {
                while (!lists[j].isEmpty()) {
                    arr[index++] = lists[j].removeFirst();
                }
            }
            a *= 10;
        }
        if (min < 0) {
            for (int i = 0; i < arr.length; i++) {
                arr[i] += min;
            }
        }
    }

    // 获取最大位数
    public static int getMaxNum (int[] arr) {
        if (arr.length < 2) {
            return 0;
        }
        int ans = 0;
        int max = arr[0];
        for (int value : arr) {
            max = Math.max(max, value);
        }
        while (max != 0) {
            max /= 10;
            ans++;
        }
        return ans;
    }

    // 处理负数用的，获取数组中的最小值
    public static int getMin (int[] arr) {
        int ans = arr[0];
        for (int value : arr) {
            ans = Math.min(ans, value);
        }
        return ans;
    }

    public static void main(String[] args) {
//        int[] arr = {1, 5, 6, 5, 6, 3, 6};
        Comparator cp = new Comparator();
        int[] arr = cp.generateRandomArray(10, 1000);
        cp.print(arr);
        radixSort(arr);
        cp.print(arr);
    }
}
