package PracticeByMyself.class01_数组.method03_滑动窗口;

/**
 * @author mdy
 * @date 2024-12-20 13:03
 * @description
 */
public class pb07_乘积小于K的子数组 {
    public static void main(String[] args) {
        int[] nums = {10,5,2,6};
        System.out.println(numSubarrayProductLessThanK(nums, 100));
    }

    public static int numSubarrayProductLessThanK(int[] nums, int k) {
        int cnt = 0;

        int window = 1;
        int left = 0, right = 0;
        while (right < nums.length) {
            window *= nums[right++];

            while (left < right && window >= k) {
                window /= nums[left++];
            }

            cnt += right - left;
        }

        return cnt;
    }
}
