package MartinByZuo.排序算法.NoEnlightenment;

import MartinByZuo.Comparator;

import java.util.Arrays;

public class Code01_SelectionSort {
    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
    public static void selectionSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        // 用i位置后面的数和i比较，如果后面的数更小，则和i位置上的数交换
        // 直到i位置上所有的数都被遍历
        // 将数组中所有数都作为i遍历一遍
        int minIndex;
        for (int i = 0; i < arr.length; i++) {
            minIndex = i;
            for (int j = i+1; j < arr.length; j++) {
                minIndex = (arr[j] < arr[minIndex]) ? j : minIndex; // 这样可以避免多余的数据交换，增加一点点速度
            }
            swap(arr, i, minIndex);
        }
    }

    public static void main(String[] args) {
        Comparator cp = new Comparator();
        int[] arr = cp.generateRandomArray(100, 10);
        System.out.println("生成的随机数组为：\n" + Arrays.toString(arr));
        int[] copyArr = cp.copyArray(arr);
        cp.comparator(copyArr);
        selectionSort(arr);
//        System.out.println(Arrays.toString(arr));
//        System.out.println(Arrays.toString(copyArr));
        if (cp.isEqual(arr, copyArr)) {
            System.out.println("成功");
        } else {
            System.out.println("失败");
        }
    }
}
