package PracticeByMyself.class01_数组.method02_双指针;

import java.util.Arrays;

/**
 * @author mdy
 * @date 2024-12-19 14:14
 * @description <a href="https://leetcode.cn/problems/sort-colors/">...</a>
 * 思路1：使用快慢指针，遍历三次，每次遍历将需要的数据放到前面
 * 思路2：在思路1的基础上，给数组左右两侧都加上慢指针，为0往左边swap，为2往右边swap
 */
public class pb11_颜色分类 {

    public static void main(String[] args) {
        int[] nums = {2,1,2};
        sortColors(nums);
        System.out.println(Arrays.toString(nums));
    }

    public static void sortColors(int[] nums) {
        int slowForZero = 0, slowForTwo = nums.length - 1, fast = 0;
        while (fast <= slowForTwo) {
            if (nums[fast] == 0) {
                if (nums[slowForZero] == 0) {
                    fast++;
                } else {
                    swap(nums, slowForZero, fast);
                }
                slowForZero++;
            } else if (nums[fast] == 2) {
                swap(nums, slowForTwo--, fast);
            } else {
                fast++;
            }
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

}
