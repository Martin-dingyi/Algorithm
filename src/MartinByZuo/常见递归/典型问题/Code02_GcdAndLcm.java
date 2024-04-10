package MartinByZuo.常见递归.典型问题;

// 求最大公约数、最小公倍数
public class Code02_GcdAndLcm {
    // 使用辗转相除法实现求最大公约数
    public static long getGcd(long a, long b) {
        return b == 0 ? a : getGcd(b, a % b);
    }

    public static long getLcm(long a, long b) {
        return a / getGcd(a, b) * b;
    }
}
