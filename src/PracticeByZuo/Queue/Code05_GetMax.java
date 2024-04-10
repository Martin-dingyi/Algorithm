package PracticeByZuo.Queue;

import PracticeByZuo.Comparator;

import java.util.Arrays;

// 使用递归实现获取一个数组中的最大值
public class Code05_GetMax {
    public static int getMax(int[] arr, int L, int R) {
        if (L == R) {
            return arr[L];
        }
        int mid = (L + R) >> 1;
        return Math.max(getMax(arr, L, mid), getMax(arr, mid + 1, R));
    }

    public static void main(String[] args) {
        Comparator cp = new Comparator();
        int[] arr = cp.generateRandomArray(10, 10);
        System.out.println(Arrays.toString(arr));
        System.out.println(getMax(arr, 0, arr.length - 1));
    }
}
