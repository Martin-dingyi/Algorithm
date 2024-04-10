package MartinByZuo.前缀树.经典题;

import java.util.Arrays;

// 数组中两个数的最大异或值
// 给你一个整数数组 nums ，返回 nums[i] XOR nums[j] 的最大运算结果，其中 0<=i<=j<=n
// 1 <= nums.length <= 2 * 10^5
// 0 <= nums[i] <= 2^31 - 1
// 测试链接 : https://leetcode.cn/problems/maximum-xor-of-two-numbers-in-an-array/
public class Code02_TwoNumbersMaximumXor {
    public static int findMaximumXOR(int[] nums) {
        int ans = 0;
        // 1.将数组中的所有数的二进制位存入前缀树
        Trie(nums);
        // 2.遍历数组，取到一个num后从最高位开始判断，是1就需要0，是0就需要1，查看前缀树中是否有。
        int max = 0;
        for (int num : nums) {
            max = Math.max(num, max);
        }
        // Integer.numberOfLeadingZeros方法为返回一个int类型数有多少无效的0。比如001101中有两个无效零。
        int validOrder = 31 - Integer.numberOfLeadingZeros(max);
        for (int num : nums) {
            int cur = 0;
            int bestNum = 0;
            for (int i = validOrder; i >= 0; i--) {
                // 判断该位需要0还是1
                int needBit = ((num >> i) & 1) ^ 1;
                if (Trie[cur][needBit] == 0) { // 如果需要的数不存在，那么只能取另一个数
                    needBit = needBit ^ 1;
                }
                cur = Trie[cur][needBit];
                bestNum |= needBit << i;
            }
            // 3.查找完毕后，计算异或数值，取最大的那个。
            ans = Math.max(ans, num ^ bestNum);
        }
        clear();
        return ans;
    }

    public static int MAX = 3000001;
    public static int[][] Trie = new int[MAX][2];

    public static int count;

    public static void Trie(int[] nums) {
        count = 0;
        int max = 0;
        for (int num : nums) {
            max = Math.max(num, max);
        }
        // Integer.numberOfLeadingZeros方法为返回一个int类型数有多少无效的0。比如001101中有两个无效零。
        int validOrder = 31 - Integer.numberOfLeadingZeros(max);
        for (int num : nums) {
            insert(num, validOrder);
        }
    }

    public static void insert(int num, int validOrder) {
        int path;
        int cur = 0;
        for (int i = validOrder; i >= 0; i--) {
            path = (num >> i) & 1;
            if (Trie[cur][path] == 0) {
                Trie[cur][path] = ++count;
            }
            cur = Trie[cur][path];
        }
    }

    public static void clear() {
        for (int i = 0; i <= count; i++) {
            Arrays.fill(Trie[i], 0);
        }
    }
    public static void main(String[] args) {
        int[] nums = new int[]{4, 7, 6};
        System.out.println(findMaximumXOR(nums));
    }


}
