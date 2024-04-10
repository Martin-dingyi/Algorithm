package PracticeByZuo.DynamicPlanning.OneDimensional;

import java.util.Arrays;

// 题目：计算斐波那契数
public class Code01_FibonacciNumber {
    public static int fib(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        return fib(n - 2) + fib(n - 1);
    }

    public static int[] dp;
    public static int topToBottom(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        if (dp[n] != Integer.MAX_VALUE) {
            return dp[n];
        }
        int ans2 = topToBottom(n - 1);
        dp[n - 1] = ans2;
        int ans1 = topToBottom(n - 2);
        dp[n - 2] = ans1;
        return ans1 + ans2;
    }

    public static int bottomToTop(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        int a = 0;
        int b = 1;
        for (int i = 2; i <= n; i++) {
            int temp = b;
            b = a + b;
            a = temp;
        }
        return b;
    }

    public static void main(String[] args) {
        dp = new int[30000];
        Arrays.fill(dp, Integer.MAX_VALUE);
//        System.out.println(fib(44));  // 701408733
        System.out.println(topToBottom(44));
        System.out.println(bottomToTop(44));
    }
}
