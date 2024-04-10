package MartinByZuo.排序算法.Practice;

import MartinByZuo.Comparator;

import java.util.Arrays;

// 题目：求一个数组中第k大的数
// 其实就是求第n-k+1小的数
// 分析：使用快速排序
public class GetSpecialBig {
    public static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    public static int getK(int[] arr, int L, int R, int K) {
        if (L >= R || arr.length < 2) {
            // 如果分割点在数组的右端，会使得L越界
            if (L == arr.length) {
                L--;
            }
            return arr[L];
        }
        int mid = (int) (Math.random() * (R - L + 1) + L);
        int[] temp = Partition(arr, L, R, arr[mid]);
        // 核心代码
        if (K <= (temp[0] + 1)) {
            return getK(arr, L, temp[0], K);
        } else if (K <= temp[1]) {
            return arr[temp[0] + 1];
        } else {  // (K >= temp[1] + 1))
            return getK(arr, temp[1], R, K);
        }
    }

    public static int[] Partition(int[] arr, int L, int R, int x) {
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
        // Code02_BinaryTreeTraversal-1和i分别为数据中间部分的两端在往外延伸一位的index
        return new int[]{a - 1, i};
    }

    public static int comparator(int[] arr, int K) {
        int ans = 0;
        Arrays.sort(arr);
        return arr[K - 1];
    }

    public static void main(String[] args) {
        int[] test = {1, 5, 8, 5, 6, 3, 6};
//        System.out.println(getK(test, 0, test.length - 1, 7));
        int testTimes = 500000;
        int maxSize = 10;
        int maxValue = 10;
        boolean success = true;
        Comparator cp = new Comparator();
        int[] arr;
        for (int i = 0; i < testTimes; i++) {
            do {
                arr = cp.generateRandomArray(maxSize, maxValue);
            } while (arr.length == 0);
            int[] copy = cp.copyArray(arr);
            int[] copy_2 = cp.copyArray(arr);
            int K = (int) (Math.random() * arr.length + 1);
            int a = getK(arr, 0, arr.length - 1, K);
            int b = comparator(copy, K);
            if (a != b) {
                cp.print(copy_2);
                System.out.println(K);
                System.out.println(a);
                System.out.println(b);
                success = false;
                break;
            }
        }
        cp.check(success);
    }
}
