package MartinByZuo.杂类.根据数据量猜解法;

// 超级回文数中的一个小函数，本身也是一道题 : 判断一个数字是不是回文数
// 测试链接 : https://leetcode.cn/problems/palindrome-number/
public class Code03_IsPalindrome {
    public static boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        int offset = 1;
        int size = 1;
        while (x / offset >= 10) {
            offset *= 10;
            size++;
        }
        for (int i = 0, m = 1; i < size / 2; i++) {
            if (x / offset % 10 != x / m % 10) {
                return false;
            }
            offset /= 10;
            m *= 10;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome(123321));
    }
}
