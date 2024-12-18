package PracticeByMyself.class01_数组.method01_哈希表;

import java.util.Arrays;

/**
 * @author mdy
 * @date 2024-12-09 15:51
 * @description <a href="https://leetcode.cn/problems/longest-consecutive-sequence/">...</a>
 * 思路1：使用哈希表记录并查找值
 * 思路2：给数组排序
 */
public class pb08_longestConsecutive {

    public static void main(String[] args) {
        int[] nums1 = {0, 3, 7, 2, 5, 8, 4, 6, 0, 1};
        int[] nums2 = {0, -1};
        int[] nums3 = {100, 4, 200, 1, 3, 2};
        int[] nums4 = {1, 2, 0, 1};
//        System.out.println(longestConsecutive(nums1)); // 9
//        System.out.println(longestConsecutive(nums2)); // 2
//        System.out.println(longestConsecutive(nums3)); // 4
        System.out.println(longestConsecutive(nums4)); // 3
    }

    public static int longestConsecutive(int[] nums) {
        int res = 1;

        Arrays.sort(nums);

        int index = 0;
        while (index < nums.length) {
            int cnt = 1;
            while (index < nums.length - 1 && (nums[index] + 1 == nums[index + 1] ||
            nums[index] == nums[index + 1])) {
                if (nums[index] != nums[index + 1]) {
                    cnt++;
                }
                index++;
            }
            index++;
            res = Math.max(res, cnt);
        }

        return nums.length == 0 ? 0 : res;
    }
}
