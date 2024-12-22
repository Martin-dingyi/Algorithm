package PracticeByMyself.class01_数组.method02_双指针;

import java.util.Arrays;

/**
 * @author mdy
 * @date 2024-12-19 14:39
 * @description <a href="https://leetcode.cn/problems/squares-of-a-sorted-array/">...</a>
 * 思路1：算出平方，排序
 * 思路2：算出平方，数组一定是两边高，中间低的，所以从后往前合并新数组即可
 */
public class pb12_有序数组的平方 {

    public static void main(String[] args) {
        int[] nums1 = {-5, -3, -2, -1};
        int[] nums2 = {-4,-1,0,3,10};
        System.out.println(Arrays.toString(sortedSquares(nums1)));
        System.out.println(Arrays.toString(sortedSquares(nums2)));
    }

    public static int[] sortedSquares(int[] nums) {
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            nums[i] = nums[i] * nums[i];
        }

        int[] sortedNums = new int[n];
        int left = 0, right = n - 1;
        int index = n - 1;
        while (index >= 0) {
            sortedNums[index--] = nums[left] > nums[right] ? nums[left++] : nums[right--];
        }

        return sortedNums;
    }

}
