package PracticeByMyself.class01_数组.method04_二分查找;

import java.util.Arrays;

/**
 * @author mdy
 * @date 2024-12-20 17:37
 * @description
 */
public class pb02_找元素的最左和最右位置 {

    public static void main(String[] args) {
        int[] nums = {5,7,7,8,8,10};
        System.out.println(Arrays.toString(searchRange(nums, 6)));
    }

    public static int[] searchRange(int[] nums, int target) {
        int[] res = new int[2];

        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] >= target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        if (left == nums.length) {
            res[0] =  -1;
        } else {
            res[0] = nums[left] == target ? left : -1;
        }

        left = 0;
        right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] <= target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        if (right == -1) {
            res[1] = -1;
        } else {
            res[1] = nums[right] == target ? right : -1;
        }

        return res;
    }
}
