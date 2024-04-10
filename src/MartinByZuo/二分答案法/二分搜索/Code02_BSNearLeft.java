package MartinByZuo.二分答案法.二分搜索;

import java.util.Arrays;

public class Code02_BSNearLeft {
    public static int getLessIndex(int[] arr, int num) {
        // 二分搜索（二分答案法）的模板。
        // 如果存在多个满足条件的答案，会尽量找最左边的那个。
        // 如果想找最右边那个，将等于号挂到向右缩（改L的条件结构）的条件下。
        int ans = -1;
        int L = 0, R = arr.length - 1;
        int mid;
        while (L <= R) {
            mid = (L + R) >> 1;
            if (num <= arr[mid]) {
                ans = mid;
                R = mid - 1;
            } else {
                L = mid + 1;
            }
        }
        return ans;
    }

    public static int comparator(int[] arr, int num) {
        for (int i = 0; i < arr.length; i++) {
            if (num <= arr[i]) {
                return i;
            }
        }
        return -1;
    }

    public static int[] getRandomArray(int maxSize, int maxValue) {
        int[] arr = new int[(int) (Math.random() * (maxSize + 1))];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * (maxSize + 1)) - (int) (Math.random() * maxSize);
        }
        return arr;
    }

    public static void main(String[] args) {
        int testTime = 50000;
        int maxSize = 10;
        int maxValue = 10;
        boolean success = true;
        int[] arr;
        int num = 0;
        for (int i = 0; i < testTime; i++) {
            num = (int) (Math.random() * (maxSize + 1));
            arr = getRandomArray(maxSize, maxValue);
            Arrays.sort(arr);
            if (getLessIndex(arr, num) != comparator(arr, num)) {
                success = false;
                break;
            }
        }
        System.out.println(success ? "成功" : "失败");
    }
}
