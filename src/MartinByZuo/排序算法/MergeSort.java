package MartinByZuo.排序算法;

import MartinByZuo.Comparator;

import java.util.Arrays;

import static java.lang.Thread.sleep;

// 题目：递归和非递归方式实现归并排序
public class MergeSort {
    public static void MergeSort(int[] arr, int L, int R) {
        if (L >= R) {
            return;
        }
        int M = (L + R) >> 1;
        MergeSort(arr, L, M);
        MergeSort(arr, M + 1, R);
        merge(arr, L, M, R);
    }

    public static void merge(int[] arr, int L, int M, int R) {
        //  4 5  1 2
        int left = L;
        int right = M + 1; // M是左半部分的最后一位，M+1是右半部分的起始
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
    }

    public static void MergeSort_NoRecursion(int[] arr) {
        // 根据步数d对数组的一个个小部分进行排序
        int d = 2;
        int ptr;
        while (d / 2 <= arr.length) {  // 必须让当d第一次大于等于length时，再执行一次合并，否则可能有的项没进排序
            ptr = 0;
            while (ptr <= arr.length - 1) { // 每次步数d改变，要将数组所有的一个个小部分全部合并
                merge(arr, ptr,
                        ((ptr + d / 2) <= arr.length) ? (ptr + d / 2 - 1) : ptr,
                        (ptr + d) <= arr.length ? (ptr + d - 1) : (arr.length - 1)); // M和R不能越界
                ptr += d;
            }
            d *= 2;
        }
    }

    public static void main(String[] args) {
//        int[] arr = {1, 3, -3};
//        MergeSort_NoRecursion(arr);
//        System.out.println(Arrays.toString(arr));
        Comparator cp = new Comparator();
        int textTimes = 500000;
        int maxSize = 10;
        int maxValue = 10;
        boolean success = true;
        for (int i = 0; i < textTimes; i++) {
            int[] arr = cp.generateRandomArray(10, 10);
            int[] copyArr = cp.copyArray(arr);
            MergeSort(arr, 0, arr.length - 1);
            MergeSort_NoRecursion(copyArr);
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
