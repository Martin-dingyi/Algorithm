package PracticeByZuo.Sort.Practice;

import PracticeByZuo.ComparatorUtils;
/*
题目：一个数组中的一个数，如果左边的数如果大于右边的某个数两倍，则称这两个数为一个翻转对,
求数组中的所有数的翻转对之和
分析：使用归并分治解决
 */

public class ReversePair {
    public static int reversePair(int[] arr, int L, int R) {
        if (L >= R) {
            return 0;
        }
        int mid = L + ((R - L) >> 1);
        return reversePair(arr, L, mid) + reversePair(arr, mid + 1, R) + merge(arr, L, mid, R);
    }

    public static int merge(int[] arr, int L, int M, int R) {
        //  4 5  1 2
        int left = L;
        int right = M + 1; // M是左半部分的最后一位，M+1是右半部分的起始
        int value = 0;
        int ans = 0;
        while (left <= M) {
            while (right <= R && arr[left] > 2*arr[right]) {
                value++;
                right++;
            }
            ans += value;
            left++;
        }
        left = L;
        right = M + 1;
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
        int ans = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] > 2*arr[j]) {
                    ans++;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
//        int[] arr = {4, 5, 1, 2};
//        System.out.println(comparator(arr));
//        System.out.println(reversePair(arr, 0, arr.length - 1));
        ComparatorUtils cp = new ComparatorUtils();
        int textTimes = 500000;
        int maxSize = 10;
        int maxValue = 10;
        boolean success = true;
        for (int i = 0; i < textTimes; i++) {
            int[] arr = cp.generateRandomArray(maxSize, maxValue);
            int[] copyArr = cp.copyArray(arr);
            if (reversePair(arr, 0, arr.length - 1) != comparator(copyArr)) {
                success = false;
                break;
            }
        }
        cp.check(success);
    }
}
