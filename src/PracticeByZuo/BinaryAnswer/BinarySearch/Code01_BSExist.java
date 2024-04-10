package PracticeByZuo.BinaryAnswer.BinarySearch;

import PracticeByZuo.Comparator;

import java.util.Arrays;

public class Code01_BSExist {
    public static boolean exist(int[] sortedArr, int num) {
        if (sortedArr == null || sortedArr.length == 0) {
            return false;
        }
        int start = 0;
        int end = sortedArr.length - 1;
        int index = (start + end) >> 1; // 右移一位，也是除以2，比一般的/2要快
        while (end >= start) {
            if (num == sortedArr[index]) {
               return true;
            } else if (num > sortedArr[index]) {
                start = index + 1;
            } else {
                end = index - 1;
            }
            index = start + ((end - start) >> 1); // 这样写等同于(start + end) >> 2，但这样写可以避免溢出
        }
        return false;
    }

    public static boolean comparator(int[] arr , int num) {
        for (int i = 0; i < arr.length; i++) {
            if (num == arr[i]) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int testTime = 50000;
        int maxSize = 10;
        int maxValue = 10;
        boolean success = true;
        Comparator cp = new Comparator();
        for (int i = 0; i < testTime; i++) {
            int[] arr = cp.generateRandomArray(maxSize, maxValue);
            Arrays.sort(arr);
            int value = (int) ((maxValue + 1) * Math.random()) - (int) (maxValue * Math.random());
            if (comparator(arr, value) != exist(arr, value)) {
                success = false;
                System.out.println(Arrays.toString(arr));
                System.out.println(value);
                break;
            }
        }
        System.out.println(success ? "成功" : "失败");
    }
}
