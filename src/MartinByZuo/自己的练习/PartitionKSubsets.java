package MartinByZuo.自己的练习;

import java.util.Arrays;

// 本题用到dfs
// https://leetcode.cn/problems/partition-to-k-equal-sum-subsets/solutions/1833777/hua-fen-wei-kge-xiang-deng-de-zi-ji-by-l-v66o/
public class PartitionKSubsets {
    public static boolean[] usedNum;
    public static boolean canPartitionKSubsets(int[] nums, int k) {
        // sum的范围是[数组中数的最大值，数组之和-1]
        int numsSum = 0;
        for (int num : nums) {
            numsSum += num;
        }
        Arrays.sort(nums);
        // 保证各子数组之和一定是per
        int per = numsSum / k;
        if (numsSum % k != 0 || per > nums[nums.length - 1]) {
            return false;
        }
        usedNum = new boolean[nums.length];

        for (int left = 0, right = nums.length - 1; !isAllUsed(usedNum); right++) {
            int needVal = per - nums[right];
            usedNum[right] = true;
            if (!getsubSet(nums, needVal, left)) {
                return false;
            }
        }
        return true;
    }

    public static boolean getsubSet(int[] nums, int needVal, int index) {
        if (!usedNum[index] && nums[index] <= needVal) {
            usedNum[index] = true;
            needVal -= nums[index];
        }
        if (needVal > 0) {
            getsubSet(nums, needVal, index + 1);
        }
        return true;
    }

    public static boolean isAllUsed(boolean[] usedNum) {
        for (boolean b : usedNum) {
            if (!b) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] nums1 = {4, 3, 2, 3, 5, 2, 1};
        int[] nums2 = {4, 4, 6, 2, 3, 8, 10, 2, 10, 7};
//        System.out.println(canPartitionKSubsets(nums1, 4)); // true
        System.out.println(canPartitionKSubsets(nums2, 4)); // true
    }
}
