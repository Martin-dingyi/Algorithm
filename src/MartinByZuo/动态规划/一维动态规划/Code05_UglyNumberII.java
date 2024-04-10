package MartinByZuo.动态规划.一维动态规划;

// 题目：寻找第n个丑数。丑数：质因子有且仅有2,3,5
public class Code05_UglyNumberII {
    public static int nthUglyNumber(int n) {
        int[] dp = new int[n];
        dp[0] = 1;
        // 定义三个指针，分别代表乘2,3,5
        int[] index = new int[3];
        for (int i = 1; i < n; i++) {
            int[] candidate = new int[3];
            candidate[0] = dp[index[0]] * 2;
            candidate[1] = dp[index[1]] * 3;
            candidate[2] = dp[index[2]] * 5;
            // 选出三个候选值中的最小值，并记录是哪个指针算出的最小值。
            int min = Math.min(candidate[0], Math.min(candidate[1], candidate[2]));
            dp[i] = min;
            // 将用过的指针指向下一个数，如果其他指针算出的数和最小值相等，也要指向下一个
            for (int j = 0; j < 3; j++) {
                if (candidate[j] == min) {
                    index[j]++;
                }
            }
        }
        return dp[n - 1];
    }

    public static void main(String[] args) {
        int n = 10;
        System.out.println(nthUglyNumber(n));
    }
}
