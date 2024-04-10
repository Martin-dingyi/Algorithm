package PracticeByZuo.Array.DoublePointer;


// 缺失的第一个正数
// 给你一个未排序的整数数组 nums ，请你找出其中没有出现的最小的正整数。
// 请你实现时间复杂度为 O(n) 并且只使用常数级别额外空间的解决方案。
// 测试链接 : https://leetcode.cn/problems/first-missing-positive/


// 利用排序、数组下标想出的解法，用数据交换和双指针优化解法
public class Code07_FirstMissingPositive {
    public static int firstMissingPositive(int[] nums) {
        // 垃圾区长度每增加1，最大合法的数字就减一。
        // right不仅作为右指针，也是目前最大合法数字。
        int left = 0, right = nums.length;
        while (left != right) {
            if (nums[left] == left + 1) {
                left++;
            } else if (nums[left] <= right && nums[left] > 0 && nums[nums[left] - 1] != nums[left]) {
                swap(nums, left, nums[left] - 1);
            } else {
                swap(nums, left, --right);
            }
        }
        return left + 1;
    }

    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        int[] nums1 = {3, 4, -1, 1}; // 2
        int[] nums2 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 20}; // 10
        int[] nums3 = {7, 8, 9, 11, 12}; // 1
        int[] nums4 = {1, 1000}; // 2
        int[] nums5 = {1, 2, 0}; // 3
        System.out.println(firstMissingPositive(nums1));
        System.out.println(firstMissingPositive(nums2));
        System.out.println(firstMissingPositive(nums3));
        System.out.println(firstMissingPositive(nums4));
        System.out.println(firstMissingPositive(nums5));
    }
}
