package PracticeByMyself.class05_图.DFS;

import java.util.*;

/**
 * @author Martin
 * @date 2025/1/30 20:55
 * @description <a href="https://leetcode.cn/problems/partition-to-k-equal-sum-subsets/">...</a>
 * 难题、好题
 * 思路1：显然这题用把球放进桶里的思路更易懂，难点在于如何剪枝
 * 思路2：用桶装球的思路，不仅递归代码难写，剪枝一样很难
 */

public class pb37_集合划分 {

    public static void main(String[] args) {
        int[] nums = {3522, 181, 521, 515, 304, 123, 2512, 312, 922, 407, 146, 1932, 4037, 2646, 3871, 269};
        System.out.println(canPartitionKSubsets(nums, 5)); // true
    }


    public static boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % k != 0 || k > nums.length) return false;
        Arrays.sort(nums);
        return traverse(nums, nums.length - 1, new int[k], sum / k);
    }

    static boolean traverse(int[] nums, int index, int[] bucket, int target) {
        if (index == -1) {
            // 由于剪枝会将所有不可能的情况剔除，所以只要把球全部分配，就一定满足条件
            return true;
        }

        for (int i = 0; i < bucket.length; i++) {
            if (nums[index] + bucket[i] > target) continue;
            // 画出决策树，可以看见这种情况下必然发生重复，所以可以剪枝
            if (i > 0 && bucket[i] == bucket[i - 1]) continue;
            bucket[i] += nums[index];
            // 如果这条路行不通再进行回溯，和传统回溯算法不同，这种方法可以让dfs只遍历部分多叉树，虽然最坏时间复杂度相同，但实际
            // 的复杂度大概率变低。之所以给nums数组从大到小排序，就是为了更快找到符合条件的答案，看题中的示例1就能明白为什么可以这样
            // 优化，如果从小到大，那么一开始的(1,2)会被回溯浪费时间，而从大到小的话，一开始的(5)就不会被回溯
            if (traverse(nums, index - 1, bucket, target)) {
                return true;
            }
            bucket[i] -= nums[index];
        }

        // 所有被剪掉所有分支的结点，都不可能组成答案
        return false;
    }


}
