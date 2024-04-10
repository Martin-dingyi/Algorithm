package PracticeByZuo.CommonRecursion.Classical;

// 一个正整数如果能被 a 或 b 整除，那么它是神奇的。
// 给定三个整数 n , a , b ，返回第 n 个神奇的数字。
// 因为答案可能很大，所以返回答案 对 10^9 + 7 取模 后的值。
// 测试链接 : https://leetcode.cn/problems/nth-magical-number/
public class Code03_NthMagicalNumber {
    public static int nthMagicalNumber(int n, int a, int b) {
        long lowerBound = Math.min(a, b), upperBound = (long) n * Math.min(a, b);
        long lcd = getLcm(a, b);
        long ans = 0;
        while (upperBound >= lowerBound) {
            long mid = (upperBound + lowerBound) >> 1;
            if (mid / a + mid / b - mid / lcd >= n) {
                // 如果已经找到满足条件的值，再往左找找看有没有更小的满足条件的值
                // 如果是因为大于n进入的循环，不用担心ans值不正确，只要没找到值，循环还会继续发生。
                ans = mid;
                upperBound = mid - 1;
            } else {
                lowerBound = mid + 1;
            }
        }
        return (int) (ans % 1000000007);
    }

    public static long getGcd(long a, long b) {
        return b == 0 ? a : getGcd(b, a % b);
    }

    public static long getLcm(long a, long b) {
        return a / getGcd(a, b) * b;
    }

    public static void main(String[] args) {
//        System.out.println(nthMagicalNumber(4, 2, 3));
//        System.out.println(nthMagicalNumber(5, 2, 4));
        System.out.println(nthMagicalNumber(3, 6, 4));
        System.out.println(nthMagicalNumber(1000000000, 40000, 40000));
    }
}
