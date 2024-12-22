package PracticeByMyself.class01_数组.method03_滑动窗口;

import java.util.Arrays;
import java.util.HashSet;
import java.util.TreeSet;

/**
 * @author mdy
 * @date 2024-12-20 15:07
 * @description <a href="https://leetcode.cn/problems/contains-duplicate-iii/description/">...</a>
 */
public class pb10_存在重复元素3 {
    public static void main(String[] args) {
        int[] nums1 = {8,7,15,1,6,1,9,15};
        int[] nums2 = {1,5,9,1,5,9};
        System.out.println(containsNearbyAlmostDuplicate(nums1, 1, 3)); // true
        System.out.println(containsNearbyAlmostDuplicate(nums2, 2, 3)); // false
    }

    public static boolean containsNearbyAlmostDuplicate(int[] nums, int indexDiff, int valueDiff) {
        int left = 0, right = 0;
        TreeSet<Integer> window = new TreeSet<>();

        while (right < nums.length) {
            int curNum = nums[right++];

            Integer ceiling = window.ceiling(curNum - valueDiff);
            if (ceiling != null && ceiling.equals(window.floor(curNum + valueDiff))) {
                return true;
            }

            window.add(curNum);

            if (right - 1 - left == indexDiff) {
                window.remove(nums[left++]);
            }

        }

        return false;
    }
}
