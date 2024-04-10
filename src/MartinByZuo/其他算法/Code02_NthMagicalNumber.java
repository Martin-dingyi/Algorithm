package MartinByZuo.其他算法;

// 一个正整数如果能被 a 或 b 整除，那么它是神奇的。
// 给定三个整数 n , a , b ，返回第 n 个神奇的数字。
// 因为答案可能很大，所以返回答案 对 10^9 + 7 取模 后的值。
// 测试链接 : https://leetcode.cn/problems/nth-magical-number/
public class Code02_NthMagicalNumber {

    public static int m = 1000000007;
	public static int nthMagicalNumber(int n, int a, int b) {
        long mid = 0;
        // 要求的数一定在left到right这个范围内
        long left = 1, right = (long) Math.min(a, b) * n;
        long lcm = lcm(a, b);
        while (left < right) {
            mid = (left + right) / 2;
            if (mid / a + mid / b - mid / lcm < n) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
		return (int) (left % m);
	}

	public static long gcd(long a, long b) {
		return b == 0 ? a : gcd(b, a % b);
	}

	public static long lcm(long a, long b) {
		return (long) a / gcd(a, b) * b;
	}

    public static void main(String[] args) {
        int n = 1000000000;  // 999720007
        int a = 40000, b = 40000;
        System.out.println(nthMagicalNumber(n, a, b));
    }

}
