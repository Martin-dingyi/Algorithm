package PracticeByZuo.BinaryAnswer;

import PracticeByZuo.ComparatorUtils;

import java.util.PriorityQueue;

// 计算等位时间
// 给定一个数组arr长度为n，表示n个服务员每服务一个人的时间
// 给定一个正数m，表示有m个人等位，如果你是刚来的人，请问你需要等多久？
// 假设m远远大于n，比如n <= 10^3, m <= 10^9，该怎么做是最优解？
// 谷歌的面试，这个题连考了2个月
// 找不到测试链接，所以用对数器验证
public class Code06_WaitingTime {

    // 一个结论：无论每个顾客选谁为自己服务，最终到你时需要等待的时间都是一样的
    public static int getWaitTime(int[] wait, int m) {
        PriorityQueue<int[]> heap = new PriorityQueue<>((a, b) -> (a[0] - b[0]));
        for (int i = 0; i < wait.length; i++) {
            heap.add(new int[]{0, wait[i]});
        }
        while (m != 0) {
            int[] temp = heap.poll();
            temp[0] += temp[1];
            heap.add(temp);
            m--;
        }
        return heap.poll()[0];
    }

    public static int getWaitTimeByBinarySearch(int[] wait, int m) {
        if (m < wait.length) {
            return 0;
        }
        int ans = 0;
        m++;
        int left = 0, right = wait[0] * m;
        while (left <= right) {
            int mid = (left + right) >> 1;
            int waitedPerson = 0;
            for (int w : wait) {
                waitedPerson += (mid + w - 1) / w;
                if (mid % w == 0) {
                    waitedPerson++;
                }
            }
            if (waitedPerson >= m) {
                ans = mid;
                right = mid - 1;
            } else{
                left = mid + 1;
            }
        }
        return ans;
    }

    //
    public static void main(String[] args) {
        ComparatorUtils cp = new ComparatorUtils();
        int textTimes = 500000;
        boolean success = true;
        for (int i = 0; i < textTimes; i++) {
            int[] arr = cp.generateRandomNoMinusArray(10, 10);
            int k = (int) (Math.random() * 7) + 1;
            int ans1 = getWaitTime(arr, k);
            int ans2 = getWaitTimeByBinarySearch(arr, k);
            if (ans1 != ans2) {
                cp.print(arr);
                System.out.println("答案1：" + ans1);
                System.out.println("答案2：" + ans2);
                System.out.println("K:" + k);
                success = false;
                break;
            }
        }
        cp.check(success);


        int[] wait1 = {1, 3, 5};
        int[] wait2 = {3, 3, 8};
//        System.out.println(getWaitTime(wait1, 3));
//        System.out.println(getWaitTimeByBinarySearch(wait1, 3));
//        System.out.println(getWaitTime(wait2, 4));
//        System.out.println(getWaitTimeByBinarySearch(wait2, 4));
    }
}
