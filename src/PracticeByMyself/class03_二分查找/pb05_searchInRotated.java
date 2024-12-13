package PracticeByMyself.class03_二分查找;

/**
 * @author mdy
 * @date 2024-12-12 23:13
 * @description <a href="https://leetcode.cn/problems/search-in-rotated-sorted-array/">...</a>
 */
public class pb05_searchInRotated {

    public static void main(String[] args) {
        int[] nums1 = {3, 1};
        int[] nums2 = {5, 1,3};
        System.out.println(search(nums1, 1));
        System.out.println(search(nums2, 3));
    }

    public static int search(int[] nums, int target) {
        int res = -1;
        int left = 0;
        int right = nums.length - 1;
        int mid;

        while (left <= right) {
            mid = (left + right) >> 1;

            // 如果nums[left] < nums[right]，数组就是严格递增的，否则就是另一套规律
            if (nums[left] < nums[right]) {
                if (target == nums[mid]) {
                    return mid;
                } else if (target > nums[mid]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            } else {
                // 另一套规律：先递增，再骤降，再递增
                if (target == nums[mid]) {
                    return mid;
                } else if (target > nums[mid]) {
                    if (nums[mid] > nums[left]) {
                        left = mid + 1;
                    } else {
                        right = mid - 1;
                    }
                } else {
                    if (nums[mid] >= nums[left]) {
                        if (target >= nums[left]) {
                            right = mid - 1;
                        } else {
                            left = mid + 1;
                        }
                    } else {
                        right = mid - 1;
                    }
                }
            }
        }
        return res;
    }
}
