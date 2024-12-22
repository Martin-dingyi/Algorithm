package PracticeByMyself.class01_数组.method03_滑动窗口;

import java.util.HashMap;
import java.util.HashSet;

/**
 * @author mdy
 * @date 2024-12-20 14:27
 * @description <a href="https://leetcode.cn/problems/contains-duplicate-ii/description/">...</a>
 * 思路1：n^2复杂度的算法，从头到尾遍历，类似于简单排序
 * 思路2：从头到尾遍历，并将数字和下标计入map，遇到重复的判断一下
 */
public class pb09_存在重复元素2 {

    public static void main(String[] args) {
        int[] nums1 = {1,2,3,1,2,3};
        int[] nums2 = {1,2,3,1};
        int[] nums3 = {1,2,1};
        System.out.println(containsNearbyDuplicate(nums1, 2)); // false
        System.out.println(containsNearbyDuplicate(nums2, 3)); // true
        System.out.println(containsNearbyDuplicate(nums3, 0)); // false
    }

    public static boolean containsNearbyDuplicate(int[] nums, int k) {

        int left = 0, right = 0;
        HashSet<Integer> window = new HashSet<>();

        while (right < nums.length) {
            int curNum = nums[right++];
            if(!window.add(curNum)) {
                return true;
            }

            while (left < right && right - 1 - left == k) {
                window.remove(nums[left++]);
            }

        }

        return false;
    }


    public static boolean containsNearbyDuplicate2(int[] nums, int k) {
        HashMap<Integer, Integer> numToIndex = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int curNum = nums[i];
            if (numToIndex.containsKey(curNum)) {
                if (i - numToIndex.get(curNum) <= k) {
                    return true;
                } else {
                    numToIndex.put(curNum, i);
                }
            } else {
                numToIndex.put(curNum, i);
            }
        }
        return false;
    }

}
