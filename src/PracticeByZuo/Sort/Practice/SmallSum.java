package PracticeByZuo.Sort.Practice;

import PracticeByZuo.ComparatorUtils;
/*
 题目：数组中一个数前面的，比它小的数的合叫这个数的最小和
 求数组中所有数的最小和的和
 分析：使用归并分治
* */
public class SmallSum {
    public static int SmallSum(int[] arr, int L, int R) {
        if (L >= R) {
            return 0;
        }
        int mid = (L + R) >> 1;
        return SmallSum(arr, L, mid) + SmallSum(arr, mid + 1, R) + merge(arr, L, mid, R);
    }

    public static int merge(int[] arr, int L, int M, int R) {
        //  4 5  1 2
        int left = L;  // 指向左半部分第一个数字
        int right = M + 1;   // 指向右半部分第一个数字
        int sum = 0;
        int ans = 0;
        while (right <= R) {
            while (left <= M && arr[left] <= arr[right]) {
                sum += arr[left++];
            }
            ans += sum;
            right++;
        }
        left = L;
        right = M + 1;
        // 两部分有序组合
        int[] temp = new int[(R - L) + 1];
        int i = 0;
        while (left <= M && right <= R) {
            temp[i++] = arr[left] <= arr[right] ? arr[left++] : arr[right++];
        }
        // 两组中必有一组没有排序完，将这一组剩下的数据填入temp
        while (left <= M) {
            temp[i++] = arr[left++];
        }
        while (right <= R) {
            temp[i++] = arr[right++];
        }
        left = L;
        for (int j = 0; j < temp.length; j++) {
            arr[left++] = temp[j];
        }
        return ans;
    }

    public static int comparator(int[] arr) {
        int value = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < i; j++) {
                value += arr[j] <= arr[i] ? arr[j] : 0;
            }
        }
        return value;
    }

    public static void main(String[] args) {
//        int[] arr = {1, 3, 8, 5, 6};
        ComparatorUtils cp = new ComparatorUtils();
        int textTimes = 500000;
        int maxValue = 10;
        int maxSize = 10;
        boolean success = true;
        for (int i = 0; i < textTimes; i++) {
            int[] arr = cp.generateRandomArray(maxSize, maxValue);
            int[] copyArr = cp.copyArray(arr);
            if (SmallSum(arr, 0, arr.length - 1) != comparator(copyArr)) {
                cp.print(arr);
                cp.print(copyArr);
                success = false;
            }
        }
        cp.check(success);
    }
}
