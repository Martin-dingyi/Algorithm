package PracticeByZuo.CommonRecursion.Classical;

// N皇后问题
// 测试链接 : https://leetcode.cn/problems/n-queens-ii/
public class Code01_NQueens {
    public static int totalNQueens(int n) {
        // 用一个int类型数的二进制位来代表哪一列可以放皇后，0代表可放，1代表不可
        int col = 0;
        // 用limit代表col中前多少位需要忽略，因为我们不需要32位而需要n位。
        int limit = (1 << n) - 1;
        int ans = 0;
        ans = f(col, limit, col, col);
        return ans;
    }

    // 递归函数作用，判断在一行中哪些位置可以放皇后
    public static int f(int col, int limit, int left, int right) {
        // 终止条件，如果col等于limit，说明这条路径是一个正确答案
        if (col == limit) {
            return 1;
        }
        int ans = 0;
        // 得出这一轮可以放皇后的位置
        int candidatePos = col | left | right;
        // 消除32位中其他不相关位的影响，同时改变可放皇后位置的规则，改为位为1可放
        candidatePos = ~candidatePos & limit;
        // 所有可放位置都要尝试一遍，使用递归实现
        while (candidatePos != 0) {
            // 提取最右边的1
            int place = candidatePos & (-candidatePos);
            candidatePos ^= place;
            ans += f(col | place, limit, (left | place) << 1, (right | place) >> 1);
        }
        return ans;
    }

    public static void main(String[] args) {
        int n = 16;
        System.out.println(totalNQueens(n));
    }
}
