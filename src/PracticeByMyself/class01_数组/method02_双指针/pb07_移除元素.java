package PracticeByMyself.class01_数组.method02_双指针;

/**
 * @author mdy
 * @date 2024-12-18 13:18
 * @description <a href="https://leetcode.cn/problems/remove-element/">...</a>
 * 快慢双指针
 */
public class pb07_移除元素 {

    public static void main(String[] args) {

    }

    public static int removeElement(int[] nums, int val) {
        int slow = 0;
        int fast = 0;

        while (fast < nums.length) {
            // 3,2,2,3
            if (nums[fast] != val) {
                nums[slow++] = nums[fast];
            }
            fast++;
        }
        return slow;
    }
}
