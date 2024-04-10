package PracticeByZuo.Sort.Practice;

import java.util.Arrays;
import java.util.PriorityQueue;

/*
 * 题目：给予一组线段，线段的端点一定是整数，求重合段做多能覆盖多少线段
 * 比如，给你[1,5],[2,4] 这两条线段的重合段为[2,4]，重合段最多覆盖2条线段
 * 再给一条[3,6]，那么重合段为[3,4]，它最多覆盖3条线段
 *
 * 分析：利用线段数。两条线段要想重合，B线段的左端必须在A线段的范围内。将所有线段按左端的数值从小到大排列
 * 保证后一个线段的左端必然大于前一个线段的左端，这样只要保证新增线段的左端小于前一个（或n个）
 * 线段的右端，就能保证两者（或n+1）同属于一个重合段。
 * */
public class MaxCover {
    public static int n = 5;
    public static int maxCover(int[][] arr) {
        int ans = 0;
        int size = 0;
        // 小根堆
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        Arrays.sort(arr, 0, n, (a, b) -> (a[0] - b[0]));
        // 一个个将线段的右端加进堆
        for (int i = 0; i < n; i++) {
            // 反复查看堆顶，如果新增线段的左端大于等于堆顶线段的右端
            // 则将该线段弹出堆。重复直到新增线段的左端小于堆顶元素，或者堆为空
            while (!heap.isEmpty() && arr[i][0] >= heap.peek()) {
                heap.poll();
                size--;
            }
            heap.add(arr[i][1]);
            size++;
            ans = Math.max(size, ans);
        }
        return ans;
    }

    public static void main(String[] args) {
        // 二维数组看成保存线段的数组
        int[][] arr = new int[5][2];  // arr[0]代表第一个线段。比如arr[0][0]就是第一个线段左端
        arr[0] = new int[]{496, 519};
        arr[1] = new int[]{626, 659};
        arr[2] = new int[]{295, 452};
        arr[3] = new int[]{65, 213};
        arr[4] = new int[]{603, 715};
        // 针对线段的左端从小到大排序。其中0到n的含义是arr[0]到arr[n-1]进行排序,即排序所有线段。
        Arrays.sort(arr, 0, 5, (a, b) -> (a[0] - b[0]));
        System.out.println("===============");
        for (int i = 0; i < 5; i++) {
            System.out.println(Arrays.toString(arr[i]));
        }
        System.out.println(maxCover(arr));
    }
}
