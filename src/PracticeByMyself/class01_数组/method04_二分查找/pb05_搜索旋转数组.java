package PracticeByMyself.class01_数组.method04_二分查找;

/**
 * @author mdy
 * @date 2024-12-12 23:13
 * @description <a href="https://leetcode.cn/problems/search-in-rotated-sorted-array/">...</a>
 * 思路1：将旋转数组映射为递增数组
 * 思路2：对两个数组进行二分查找
 */
public class pb05_搜索旋转数组 {

    public static void main(String[] args) {
        int[] nums1 = {3, 1};
        int[] nums2 = {5, 1, 3};
        int[] nums3 = {4, 5, 6, 7, 0, 1, 2};
        System.out.println(search(nums1, 1)); // 1
        System.out.println(search(nums2, 3)); // 2
        System.out.println(search(nums3, 0)); // 4
    }

    public static int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) >> 1;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                // 1.如果mid在左半边，或者数组没有被旋转过，区间右移
                if (nums[mid] >= nums[left] && nums[mid] >= nums[right]) {
                    left = mid + 1;
                } else {
                    // 2.如果在右半边，或者数组没有被旋转过，
                    // 判断target是否比nums[right]还大，如果更大，向左移，否则向右
                    if (target > nums[right]) {
                        right = mid - 1;
                    } else {
                        left = mid + 1;
                    }
                }
            } else if (nums[mid] > target) {
                // 1.如果mid在左半边，判断target是否比nums[left]还小，如果更小，向右移，否则向左
                if (nums[mid] >= nums[left] && nums[mid] >= nums[right]) {
                    if (target < nums[left]) {
                        left = mid + 1;
                    } else {
                        right = mid - 1;
                    }
                } else {
                    // 2.如果mid在右半边，或者数组没有被旋转过，区间左移
                    right = mid - 1;
                }
            }
        }

        return -1;
    }

    public static int search1(int[] nums, int target) {
        int n = nums.length;
        int minIndex = 0;
        int left = 0;
        int right = n - 1;
        int mid;

        // 获取最小值的下标，用作映射
        while (left <= right) {
            mid = (left + right) >> 1;
            if (nums[left] > nums[right]) {
                if (nums[mid] < nums[right]) {
                    right = mid - 1;
                    minIndex = nums[mid] < nums[minIndex] ? mid : minIndex;
                } else {
                    left = mid + 1;
                    minIndex = nums[right] < nums[minIndex] ? right : minIndex;
                }
            } else {
                minIndex = nums[left] < nums[minIndex] ? left : minIndex;
                break;
            }
        }

        left = 0;
        right = n - 1;

        while (left <= right) {
            mid = (left + right) >> 1;
            int originIndex = getOriginIndex(mid, minIndex, n);
            if (nums[originIndex] == target) {
                return originIndex;
            } else if (target < nums[originIndex]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return -1;
    }

    private static int getOriginIndex(int fakeIndex, int minIndex, int length) {
        return (fakeIndex + minIndex) % length;
    }
}
