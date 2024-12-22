package PracticeByMyself.class01_数组.method02_双指针;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @author mdy
 * @date 2024-12-19 13:55
 * @description <a href="https://leetcode.cn/problems/remove-duplicates-from-sorted-array-ii/">...</a>
 * 思路1：利用哈希表记录每个数字被使用的次数，超过2就不允许使用。使用快慢指针来填充和探索数据
 */
public class pb10_删除有序数组重复项 {

    public static void main(String[] args) {
        int[] nums = {1,1,1,2,2,3};
        System.out.println(removeDuplicates(nums));
        System.out.println(Arrays.toString(nums));
    }

    public static int removeDuplicates(int[] nums) {

        int curNumCount = 0;
        int slow = 0, fast = 0;
        while (fast < nums.length) {
            int curNum = nums[fast];
            if (curNumCount < 2) {
                nums[slow++] = curNum;
                curNumCount++;
            }
            fast++;
            if (fast < nums.length && nums[fast] != curNum) {
                curNumCount = 0;
            }
        }

        return slow;
    }
}
