package PracticeByMyself.class02_双指针;

import PracticeByZuo.Sort.HeapSort;

import java.util.Arrays;

/**
 * @author mdy
 * @date 2024-12-18 13:29
 * @description <a href="https://leetcode.cn/problems/move-zeroes/">...</a>
 */
public class pb08_移除零 {

    public static void main(String[] args) {
        int[] nums = {0, 1, 0, 3, 12};
        moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }

    public static void moveZeroes(int[] nums) {
        int slow = 0;
        int fast = 0;

        while (fast < nums.length) {
            if (nums[fast] != 0) {
                swap(nums, slow++, fast);
            }
            fast++;
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

}
