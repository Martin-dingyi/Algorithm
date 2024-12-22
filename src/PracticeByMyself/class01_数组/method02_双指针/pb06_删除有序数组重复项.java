package PracticeByMyself.class01_数组.method02_双指针;

import java.util.Arrays;

/**
 * @author mdy
 * @date 2024-12-18 12:48
 * @description <a href="https://leetcode.cn/problems/remove-duplicates-from-sorted-array/submissions/587818764/">...</a>
 * 思路1：:数组中的快慢双指针
 */
public class pb06_删除有序数组重复项 {

    public static void main(String[] args) {
        int[] nums = {1, 1, 2};
        System.out.println(removeDuplicates(nums));
        System.out.println(Arrays.toString(nums));
    }

    public static int removeDuplicates(int[] nums) {

        // slow用于填充，fast用于“探路”，找到不重复的元素
        int slow = 0, fast = 0;
        // 1,1,2
        while (fast < nums.length) {
            int curNum = nums[fast];
            nums[slow++] = curNum;
            while (fast < nums.length && nums[fast] == curNum) {
                fast++;
            }
        }

        return slow;
    }
}
