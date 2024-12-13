package PracticeByZuo.Sort;

import PracticeByZuo.ComparatorUtils;

import java.util.Arrays;

public class PartitionAndQuickSort {
    public static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
    public static void quickSort(int[] arr, int L, int R) {
       if (L >= R || arr.length < 2) {
           return;
       }
       int index = (int) (Math.random() * (R - L + 1) + L);
       int mid = partition(arr, L, R, arr[index]);
       quickSort(arr, L, mid - 1);
       quickSort(arr, mid + 1, R);
    }

    public static int partition(int[] arr, int L, int R, int x) {
        int xIndex = 0;
        int a, i;
        a = L;
        i = L;
        while (i <= R) {
            if (arr[i] <= x) {
                if (arr[i] == x)
                    xIndex = a;
                swap(arr, a, i);
                a++;
            }
            i++;
        }
        if (a != 0) {
            swap(arr, xIndex, a - 1);
        }
        return a - 1;
    }

    // 荷兰国旗问题，更好的实现快速排序
    public static void quickSort_better(int[] arr, int L, int R) {
        if (L >= R || arr.length < 2) {
            return;
        }
        int index = (int) (Math.random() * (R - L + 1) + L);
        int[] mid = betterPartition(arr, L, R, arr[index]);
        quickSort_better(arr, L, mid[0]);
        quickSort_better(arr, mid[1], R);
    }

    // 将数组分为三部分，左边小于x，右边大于x，中间等于x
    public static int[] betterPartition(int[] arr, int L, int R, int x) {
        int xIndex = 0;
        int a, i, b;
        a = L;
        i = L;
        b = R;
        while (i <= b) {
            if (arr[i] < x) {
                swap(arr, a++, i++);
            } else if (arr[i] > x) {
                swap(arr, i, b--);
            } else {
                i++;
            }
        }
        return new int[]{a - 1, i};
    }

    public static void main(String[] args) {
//        int[] arr = {1, 5, 8, 5, 6, 3, 6};
        ComparatorUtils cp = new ComparatorUtils();
        int testTimes = 500000;
        int maxSize = 10;
        int maxValue = 10;
        boolean success = true;
        for (int i = 0; i < testTimes; i++) {
            int[] arr = cp.generateRandomArray(maxSize, maxValue);
            int[] copyArr = cp.copyArray(arr);
            quickSort(arr, 0, arr.length - 1);
            quickSort_better(copyArr, 0, arr.length - 1);
            if (!Arrays.equals(arr, copyArr)) {
                cp.print(arr);
                cp.print(copyArr);
                success = false;
                break;
            }
        }
        cp.check(success);
    }
}
