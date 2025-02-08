package PracticeByMyself.class01_数组.method03_滑动窗口;

/**
 * @author mdy
 * @date 2024-12-20 11:46
 * @description <a href="https://leetcode.cn/problems/minimum-operations-to-reduce-x-to-zero/description/">...</a>
 *
 * 思路1：转换成滑动窗口问题。
 */
public class pb06_好题_减到零的最小操作数 {

    public static void main(String[] args) {
        int[] nums = {8828,9581,49,9818,9974,9869,9991,10000,10000,10000,9999,9993,9904,8819,1231,6309};
        System.out.println(minOperations(nums, 134365));
    }

    public static int minOperations(int[] nums, int x) {
        int maxLen = Integer.MIN_VALUE;
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }

        int window = 0;
        int target = sum - x;

        int left = 0, right = 0;
        while (right < nums.length) {
            window += nums[right++];

            while (left < right && window > target) {
                window -= nums[left++];
            }

            if (window == target) {
                maxLen = Math.max(maxLen, right - left);
            }

        }

        return maxLen == Integer.MIN_VALUE ? -1 : nums.length - maxLen;
    }
}
