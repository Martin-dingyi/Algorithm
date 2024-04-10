package PracticeByZuo.BitOperation;

/*
 * 题目：不使用任何算术运算实现加减乘除
 *
 * */
public class Code06_BitOperationAMMD {
    public static int MIN = Integer.MIN_VALUE;

    public static int add(int a, int b) {
        int ans = a ^ b;
        int promotion = (a & b) << 1;
        while (promotion != 0) {
            a = ans;
            ans ^= promotion;
            promotion = (a & promotion) << 1;
        }
        return ans;
    }

    public static int minus(int a, int b) {
        return add(a, neg(b));
    }

    public static int multiply(int a, int b) {
        int ans = 0;
        int i = 0;
        while (b != 0) {
            int sign = b & 1;
            if (sign == 1) {
                ans += a << i;
            }
            b >>>= 1; // b无符号右移，防止符号位干扰
            i++;
        }
        return ans;
    }

    public static int divide(int a, int b) {
        // 因为补码中负数的最大绝对值比正数大一，所以要分类讨论
        if (a != MIN) {
            if (b == MIN) {
                return 0;
            }
            // 如果b不是MIN
            int x = a > 0 ? a : neg(a);
            int y = b > 0 ? b : neg(b);
            int ans = 0;
            for (int i = 31; i >= 0; i--) {
                if ((x >> i) >= y) {
                    ans |= 1 << i;
                    x -= (y << i);
                }
            }
            return a < 0 ^ b < 0 ? neg(ans) : ans;
        }
        // 如果a等于MIN
        if (b == MIN) {
            return 1;
        }
        if (b == -1) {
            return Integer.MAX_VALUE; // 规定
        }
        int temp = b > 0 ? b : neg(b);
        return divide(a + temp, b) - temp / b;
    }

    public static int neg(int a) {
        return add(~a, 1);
    }

    public static void main(String[] args) {
        int a = 11;
        int b = 13;
//        System.out.println(add(Code02_BinaryTreeTraversal, b));
//        System.out.println(minus(Code02_BinaryTreeTraversal, b));
//        System.out.println(multiply(Code02_BinaryTreeTraversal, b));
        System.out.println("MIN:" + MIN);
        System.out.println(divide(143, 11));
        System.out.println(divide(MIN, -1));
        System.out.println(divide(-20, MIN));
        System.out.println(divide(MIN, 2));
    }
}
