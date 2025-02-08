package PracticeByMyself.class01_数组.method04_二分查找;

/**
 * @author Martin
 * @date 2024/12/25 11:50
 * @description
 */

public class pb16_统计目标成绩的出现次数 {
    public static void main(String[] args) {
        int[] nums1 = {2, 2, 3, 4, 4, 4, 5, 6, 6, 8};
        System.out.println(countTarget(nums1, 4)); // 3
    }

    public static int countTarget(int[] nums, int target) {
        int begin, end;

        // 找到target的起始位置和终止位置即可
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) >> 1;
            if (nums[mid] >= target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        if (left == nums.length || nums[left] != target) {
            return 0;
        }
        begin = left;

        left = 0;
        right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) >> 1;
            if (nums[mid] <= target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        end = right;

        return end - begin + 1;
    }
}
