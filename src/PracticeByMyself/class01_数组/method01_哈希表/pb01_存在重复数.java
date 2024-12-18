package PracticeByMyself.class01_数组.method01_哈希表;

import java.util.Arrays;
import java.util.HashSet;

/**
 * @author mdy
 * @date 2024-12-07 15:29
 * @description <a href="https://leetcode.cn/problems/contains-duplicate/submissions/585616062/">...</a>
 * 思路1：给数组排序，然后从后往前找
 * 思路2：使用HashSet
 */
public class pb01_存在重复数 {

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 1};
        System.out.println(containsDuplicate(nums));
        System.out.println(containsDupByHashMap(nums));
    }

    public static boolean containsDuplicate(int[] nums) {
        if (nums.length < 2) {
            return false;
        }

        Arrays.sort(nums);
        int ptr1 = 0;
        int ptr2 = 1;
        while (ptr2 < nums.length) {
            if (nums[ptr1++] == nums[ptr2++]) {
                return true;
            }
        }
        return false;
    }

    public static boolean containsDupByHashMap(int[] nums) {
        HashSet<Integer> numSet = new HashSet<>();
        for (int num : nums) {
            if (!numSet.add(num)) {
                return true;
            }
        }
        return false;
    }
}
