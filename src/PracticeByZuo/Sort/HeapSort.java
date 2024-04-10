package PracticeByZuo.Sort;

import PracticeByZuo.Comparator;

import java.util.Arrays;

// 题目：堆排序的实现，其中有插入，删除和排序的过程
// 分析：解法使用大根堆
public class HeapSort {
    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static class bigHeap {
        int[] arr;
        int size, maxSize;
        int end; // 用于从底到顶的大根堆创建方式

        public bigHeap(int maxSize) {
            this.maxSize = maxSize;
            arr = new int[maxSize];
            size = -1;
            end = arr.length;
        }

        // 插入方法：每插入一个元素，让该元素在大根堆中上浮
        public void HeapInsert(int value) {
            if (size == maxSize - 1) {
                return;
            }
            int i = ++size;
            arr[size] = value;
            while (arr[i] > arr[(i - 1) / 2]) {
                swap(arr, i, (i - 1) / 2);
                i = (i - 1) / 2;
            }
        }

        // 从底到顶的插入方式，使得插入的时间复杂度更低
        public void heapInsert2(int value) {
            if (size == maxSize - 1) {
                return;
            }
            end--;
            arr[end] = value;
            size++;
        }

        // 删除方法：删除一个元素，实际上是让它和堆数组最后一个元素交换位置,
        // 然后让新来的元素下沉
        public void HeapDelete(int i) {
            if (size == -1) {
                return;
            }
            swap(arr, i, size--);
            int best;
            // i位置的元素需要下沉，检查它的左右孩子
            // 找出三者中最大的那一个，和i交换位置
            // 持续下沉，直到i位置没有左孩子为止
            while ((2 * i + 1) <= size) {
                best = (2 * i + 2) <= size ? (arr[2 * i + 1] < arr[2 * i + 2] ? (2 * i + 2) : (2 * i + 1)) : 2 * i + 1;
                if (arr[i] >= arr[best]) {
                    break;
                } else {
                    swap(arr, i, best);
                    i = best;
                }
            }
        }

        // 堆排序：不断“删除”根部的元素
        public void sort() {
            if (size == -1) {
                return;
            }
            while (size != 0) {
                HeapDelete(0);
            }
        }
    }

    public static void main(String[] args) {
        int[] test = {1, 5, 6, 5, 6, 3, 4};
        Comparator cp = new Comparator();
        int testTimes = 500000;
        int maxSize = 10;
        int maxValue = 10;
        boolean success = true;
        for (int i = 0; i < testTimes; i++) {
            int[] arr = cp.generateRandomArray(maxSize, maxValue);
            bigHeap bh = new bigHeap(arr.length);
            for (int value : arr) {
                bh.HeapInsert(value);
            }
            int[] copy = cp.copyArray(bh.arr);
            bh.sort();
            Arrays.sort(copy);
            if (!Arrays.equals(bh.arr, copy)) {
                success = false;
                cp.print(bh.arr);
                break;
            }
        }
        cp.check(success);
    }
}
