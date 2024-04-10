package MartinByZuo.二分答案法;

import java.util.Arrays;

// 同时运行N台电脑的最长时间
// 你有 n 台电脑。给你整数 n 和一个下标从 0 开始的整数数组 batteries
// 其中第 i 个电池可以让一台电脑 运行 batteries[i] 分钟
// 你想使用这些电池让 全部 n 台电脑 同时 运行。
// 一开始，你可以给每台电脑连接 至多一个电池
// 然后在任意整数时刻，你都可以将一台电脑与它的电池断开连接，并连接另一个电池，你可以进行这个操作 任意次
// 新连接的电池可以是一个全新的电池，也可以是别的电脑用过的电池
// 断开连接和连接新的电池不会花费任何时间。
// 注意，你不能给电池充电。
// 请你返回你可以让 n 台电脑同时运行的 最长 分钟数。
// 测试链接 : https://leetcode.cn/problems/maximum-running-time-of-n-computers/
public class Code05_MaximumRunningTimeOfNComputers {
    public static long maxRunTime(int n, int[] batteries) {
        long ans = 0;
        long left = 0, right = 0;
        long sum = 0;
        for (int battery : batteries) {
            if (battery > right) {
                sum += battery;
            }
        }
        right = sum / n;
        while (left <= right) {
            long mid = (left + right) >> 1;
            if (canRun(n, batteries, mid)) {
                ans = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return ans;
    }

    public static boolean canRun(int n, int[] batteries, long runTime) {
        long sum = 0;
        for (int battery : batteries) {
            if (battery < runTime) {
                sum += battery;
            } else {
                n--;
            }
        }
        return sum >= runTime * n;
    }

    public static int maxRunTimeByGreed(int n, int[] batteries) {
        int ans = 0;
        Arrays.sort(batteries);
        int spendTime = batteries[batteries.length - n];
        while (spendTime != 0) {
            for (int i = batteries.length - 1; i >= batteries.length - n; i--) {
                batteries[i] -= 1;
            }
            Arrays.sort(batteries);
            spendTime = batteries[batteries.length - n];
            ans++;
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] batteries1 = {3, 3, 3};
        int[] batteries2 = {11, 89, 16, 32, 70, 67, 35, 35, 31, 24, 41, 29, 6, 53, 78, 83};
        System.out.println(maxRunTime(2, batteries1)); // 4
        System.out.println(maxRunTime(12, batteries2)); // 43
    }
}
