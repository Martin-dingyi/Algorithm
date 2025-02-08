package PracticeByMyself.class01_数组.method04_二分查找;

/**
 * @author Martin
 * @date 2024/12/25 12:17
 * @description <a href="https://leetcode.cn/problems/search-in-rotated-sorted-array-ii/">...</a>
 * 思路1：用之前的方法无法判断mid在左还是在右，除非遍历一遍数组，所以索性直接用for循环查。
 * 思路2：没有条件创造条件，记住这种解法：如果left和right处的值相等，就让left++，right--，创造出不相等的情况。
 * 不过时间复杂度依然是n
 */

public class pb18_搜索旋转数组2 {

    public static void main(String[] args) {
        int[] nums1 = {2,5,6,0,0,1,2};
        int[] nums2 = {1,1,1,1,1,1,1,1,1,1,1,1,1,2,1,1,1,1,1};
        int[] nums3 = {1,0,1,1,1};
//        System.out.println(search(nums1, 0)); // true
        System.out.println(search(nums2, 2)); // true
        System.out.println(search(nums3, 0)); // true
    }

    public static boolean search(int[] nums, int target) {
        for (int num : nums) {
            if (target == num) {
                return true;
            }
        }

        return false;
    }
}
