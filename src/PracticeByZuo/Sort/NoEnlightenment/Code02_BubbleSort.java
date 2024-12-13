package PracticeByZuo.Sort.NoEnlightenment;

import PracticeByZuo.ComparatorUtils;

public class Code02_BubbleSort {

    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
    public static void bubbleSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        // 让i和i+1位置上的数进行比较，若后者更小，则交换位置
        // 进行n趟，每一趟都让数组中所有位置都作为i（除了最后一位）
        // 优化，不用进行n趟，当数据不在有变化时，必然排序完毕
        boolean isChange = true;
        while(isChange) {
            isChange = false;
            for (int i = 0; i < arr.length - 1; i++) {
                if (arr[i] > arr[i + 1]) {
                    swap(arr, i, i + 1);
                    isChange = true;
                }
            }
        }
    }

    public static void main(String[] args) {
        int testTime = 50000;
        int maxSize = 100;
        int maxValue = 10;
        boolean success = true;
        ComparatorUtils cp = new ComparatorUtils();
        for (int i = 0; i < testTime; i++) {
            int[] arr = cp.generateRandomArray(maxSize, maxValue);
//        System.out.println("生成的随机数组为：\n" + Arrays.toString(arr));
            int[] copyArr = cp.copyArray(arr);
            cp.comparator(copyArr);
            bubbleSort(arr);
            if (!cp.isEqual(arr, copyArr)) {
                success = false;
                break;
            }
//        System.out.println(Arrays.toString(arr));
//        System.out.println(Arrays.toString(copyArr));
        }
        if (success) {
            System.out.println("成功");
        }
    }
}
