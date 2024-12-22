package PracticeByMyself.class01_数组.method03_滑动窗口;

/**
 * @author mdy
 * @date 2024-12-20 14:05
 * @description
 */
public class pb08_最大连续1的个数3 {
    public static void main(String[] args) {
        int[] nums = {1,1,1,0,0,0,1,1,1,1,0};
        System.out.println(longestOnes(nums, 2));
    }

    public static int longestOnes(int[] nums, int k) {
        int maxLen = 0;
        int oneCnt = 0;

        int left = 0, right = 0;
        while (right < nums.length) {
            if (nums[right++] == 1) {
                oneCnt++;
            }

            while (right - left > oneCnt + k) {
                if (nums[left++] == 1) {
                    oneCnt--;
                }
            }

            maxLen = Math.max(maxLen, right - left);
        }

        return maxLen;
    }
}
