package PracticeByMyself.class01_数组.method04_二分查找;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Martin
 * @date 2024/12/23 19:17
 * @description <a href="https://leetcode.cn/problems/find-k-closest-elements/">...</a>
 * 思路1：二分查找找到最靠左的，大于等于x的数，然后用背向双指针
 */

public class pb12_找到K个最接近的元素 {

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 4, 5};
        int[] nums2 = {0, 0, 1, 2, 3, 3, 4, 7, 7, 8};
        int[] nums3 = {1, 3};
        int[] nums4 = {1, 1, 1, 10, 10, 10};
        System.out.println(findClosestElements(nums1, 4, 3)); // 1,2,3,4
        System.out.println(findClosestElements(nums2, 3, 5)); // 3,3,4
        System.out.println(findClosestElements(nums3, 1, 2)); // 1
        System.out.println(findClosestElements(nums4, 1, 9)); // 10
    }

    public static List<Integer> findClosestElements(int[] nums, int k, int x) {
        List<Integer> res = new ArrayList<>(k);
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] <= x) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        if (right < 0) {
            right = 0;
        }

        left = right;
        right++;
        for (int i = 0; i < k; i++) {
            if (right >= nums.length) {
                left--;
            } else if (left < 0) {
                right++;
            } else if (Math.abs(nums[left] - x) <= Math.abs(nums[right] - x)) {
                left--;
            } else {
                right++;
            }
        }

        for (int i = left + 1; i < right; i++) {
            res.add(nums[i]);
        }

        return res;
    }

}
