package MartinByZuo.数组.滑动窗口;

import java.util.HashMap;

// K个不同整数的子数组
// 给定一个正整数数组 nums和一个整数 k，返回 nums 中 「好子数组」 的数目。
// 如果 nums 的某个子数组中不同整数的个数恰好为 k
// 则称 nums 的这个连续、不一定不同的子数组为 「好子数组」。
// 例如，[1,2,3,1,2] 中有 3 个不同的整数：1，2，以及 3。
// 子数组 是数组的 连续 部分。
// 测试链接 : https://leetcode.cn/problems/subarrays-with-k-different-integers/

// 这道题利用了一个数学思想，小于等于K等子数组个数减去小于等于K-1的子数组个数就等于答案。很多hard题都有这样的trick。
// 像06,07这种需要额外思考才能使用滑动窗口的题，可以先简单试试其他方法。
public class Code06_SubarraysWithKDifferentIntegers {
    public static int subarraysWithKDistinct(int[] nums, int k) {
            return lowerSub(nums, k) - lowerSub(nums, k - 1);
    }

    public static int lowerSub(int[] nums, int k) {
        int count = 0;
        HashMap<Integer, Integer> numsOfNum = new HashMap<>();
        int left = 0, right = 0;

        while (right < nums.length) {
            numsOfNum.put(nums[right], numsOfNum.getOrDefault(nums[right], 0) + 1);
            while (numsOfNum.size() > k) {
                int leftCount = numsOfNum.get(nums[left]);
                numsOfNum.put(nums[left], --leftCount);
                if (leftCount == 0) {
                    numsOfNum.remove(nums[left]);
                }
                left++;
            }
            count += right - left + 1;
            right++;
        }
        return count;
    }
    public static void main(String[] args) {
        int[] nums1 = {1, 2, 1, 2, 3};
        System.out.println(subarraysWithKDistinct(nums1, 2));
    }

}
