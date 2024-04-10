package PracticeByZuo.DynamicPlanning.TwoDimensional;

// 节点数为n高度不大于m的二叉树个数
// 现在有n个节点，计算出有多少个不同结构的二叉树
// 满足节点个数为n且树的高度不超过m的方案
// 因为答案很大，所以答案需要模上1000000007后输出
// 测试链接 : https://www.nowcoder.com/practice/aaefe5896cce4204b276e213e725f3ea
// 请同学们务必参考如下代码中关于输入、输出的处理
// 这是输入输出处理效率很高的写法
// 提交以下所有代码，把主类名改成Main，可以直接通过
public class Code05_NodeNHeightNotLargerThanM {
    public static int[][] dp;

    public static int getMaxBTCount(int n, int m) {
        if (n == 0) {
            return 1;
        }
        if (m == 0) {
            return 0;
        }
        int ans = 0;
        if (dp[n][m] != -1) {
            return dp[n][m];
        }
        for (int i = 0; i < n; i++) {
            ans += getMaxBTCount(i, m - 1) * getMaxBTCount(n - i - 1, m - 1);
        }
        dp[n][m] = ans;
        return ans;
    }

    public static int bottomToTop(int n, int m) {
        int[][] dp = new int[n + 1][m + 1];
        for (int i = 0; i <= m; i++) {
            dp[0][i] = 1;
        }
        for (int j = 1; j <= m; j++) {
            for (int i = n; i > 0; i--) {
                for (int k = 0; k < i; k++) {
                    dp[i][j] += dp[k][j - 1] * dp[i - k - 1][j - 1];
                }
            }
        }
        return dp[n][m];
    }

    public static int bottomToTopSmaller(int n, int m) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        for (int i = 1; i <= m; i++) {
            for (int j = n; j > 0; j--) {
                dp[j] = 0;
                for (int k = 0; k < j; k++) {
                    dp[j] += dp[k] * dp[j - k - 1];
                }
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        dp = new int[51][51];
        for (int i = 0; i < 500000; i++) {
            for (int k = 0; k < dp.length; k++) {
                for (int j = 0; j < dp[0].length; j++) {
                    dp[k][j] = -1;
                }
            }
            int n = (int) (Math.random() * 20);
            int m = (int) (Math.random() * 20);
            if (bottomToTop(n, m) != getMaxBTCount(n, m)) {
                System.out.println("出错");
                System.out.println(n);
                System.out.println(m);
                break;
            }
        }
        System.out.println("执行完毕");
//        System.out.println(bottomToTop(0, 2));
//        System.out.println(bottomToTopSmaller(0, 2));
    }
}
