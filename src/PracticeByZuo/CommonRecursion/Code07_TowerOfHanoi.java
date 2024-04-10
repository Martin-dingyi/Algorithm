package PracticeByZuo.CommonRecursion;

// 题目：汉诺塔问题，求最小步数
public class Code07_TowerOfHanoi {
    public static int leastStep(int n) {
        if (n == 1) {
            return 1;
        }
        return 2 * leastStep(n - 1) + 1;
    }

    public static void main(String[] args) {
        System.out.println(leastStep(3));
    }
}
