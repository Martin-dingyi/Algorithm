package PracticeByZuo.Sort.NoEnlightenment;

import PracticeByZuo.Comparator;

public class Code03_InsertionSort {
    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void insertionSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        // 第j位置上的数和后面的数比较，如果前面的数更大，则交换两者的位置
        // 一直持续到j前面所有的数都被遍历过
        // 重复这个操作，直到数组中所有数都作为j遍历一次
        for (int i = 1; i < arr.length; i++) {
            for (int j = i - 1; j >= 0 && arr[j] > arr[j+1]; j--) {
                    swap(arr, j, j+1);
            }
        }
    }

    public static void main(String[] args) {
        int testTime = 50000;
        int maxSize = 100;
        int maxValue = 10;
        boolean success = true;
        Comparator cp = new Comparator();
        for (int i = 0; i < testTime; i++) {
            int[] arr = cp.generateRandomArray(maxSize, maxValue);
//        System.out.println("生成的随机数组为：\n" + Arrays.toString(arr));
            int[] copyArr = cp.copyArray(arr);
            cp.comparator(copyArr);
            insertionSort(arr);
            if (!cp.isEqual(arr, copyArr)) {
                success = false;
                break;
            }
//        System.out.println(Arrays.toString(arr));
//        System.out.println(Arrays.toString(copyArr));
        }
        System.out.println(success ? "成功" : "失败");
    }
}
