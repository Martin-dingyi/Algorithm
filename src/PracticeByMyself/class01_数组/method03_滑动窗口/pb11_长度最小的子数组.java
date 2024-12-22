package PracticeByMyself.class01_数组.method03_滑动窗口;

/**
 * @author mdy
 * @date 2024-12-20 15:39
 * @description <a href="https://leetcode.cn/problems/minimum-size-subarray-sum/description/">...</a>
 */
public class pb11_长度最小的子数组 {

    public static void main(String[] args) {
        int[] nums1 = {2,3,1,2,4,3};
        System.out.println(minSubArrayLen(7, nums1));
    }

    public static int minSubArrayLen(int target, int[] nums) {
        int minLen = Integer.MAX_VALUE;

        int subArrSum = 0;
        int left = 0, right = 0;
        while (right < nums.length) {
            subArrSum += nums[right++];

            while (left < right && subArrSum >= target) {
                minLen = Math.min(minLen, right - left);
                subArrSum -= nums[left++];
            }
        }

        return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }
}
