package PracticeByMyself.class01_数组;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

/**
 * @author mdy
 * @date 2024-12-07 15:29
 * @description <a href="https://leetcode.cn/problems/contains-duplicate/submissions/585616062/">...</a>
 */
public class pb01_containsDuplicate {

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
