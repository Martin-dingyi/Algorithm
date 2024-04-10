package MartinByZuo.数组.滑动窗口;

// 累加和大于等于target的最短子数组长度
// 给定一个含有 n 个正整数的数组和一个正整数 target
// 找到累加和 >= target 的长度最小的子数组并返回其长度
// 如果不存在符合条件的子数组返回0
// 测试链接 : https://leetcode.cn/problems/minimum-size-subarray-sum/
public class Code01_MinimumSizeSubarraySum {

    public static int minSubArrayLen(int target, int[] nums) {
        int ans = Integer.MAX_VALUE;
        int curSum = 0;
        for (int right = 0, left = 0; right < nums.length; right++) {
            curSum += nums[right];
            while (curSum >= target) {
                ans = Math.min(ans, right - left + 1);
                curSum -= nums[left++];
            }
        }
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }
}
