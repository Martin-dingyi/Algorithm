package PracticeByMyself.class01_数组.method04_二分查找;

import common.ArrayUtils;

import java.util.Arrays;

/**
 * @author Martin
 * @date 2024/12/25 10:56
 * @description <a href="https://leetcode.cn/problems/find-peak-element/">...</a>
 * 思路1：极大值点特点：比左右都大。找到所有极大值，得到最大的那个。
 * 思路2：二分法做，只要left、mid、right对应的值是递增的，就往右找，其他情况同理。
 */

public class pb14_寻找峰值 {
    public static void main(String[] args) {
//        int[] nums1 = {1, 2, 1, 3, 5, 6, 4};
//        System.out.println(findPeakElement(nums1)); // 1 or 5

        for (int i = 0; i < 50000; i++) {
            int[] nums = ArrayUtils.generateRandomArray(10, 10);
            int res1 = findPeakElement(nums), res2 = findPeakElement1(nums);
            if (res1 != res2) {
                System.out.println("出错！");
                System.out.println("数组:" + Arrays.toString(nums));
                System.out.println(res1 + " " + res2);
                break;
            }
        }
    }

    public static int findPeakElement(int[] nums) {
        int n = nums.length;
        if (n > 1 && nums[1] < nums[0]) {
            return 0;
        }
        if (n > 1 && nums[n - 2] < nums[n - 1]) {
            return n - 1;
        }

        int left = 1, right = n - 2;
        while (left <= right) {
            int mid = (left + right) >> 1;
            if (nums[mid] > nums[mid - 1] && nums[mid] > nums[mid + 1]) {
                return mid;
            } else if (nums[mid + 1] > nums[mid]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return 0;
    }


    public static int findPeakElement1(int[] nums) {
        int n = nums.length;
        if (n > 1 && nums[1] < nums[0]) {
            return 0;
        }
        if (n > 1 && nums[n - 2] < nums[n - 1]) {
            return n - 1;
        }

        for (int i = 1; i < nums.length - 1; i++) {
            if (nums[i] > nums[i - 1] && nums[i] > nums[i + 1]) {
                return i;
            }
        }

        return 0;
    }
}
