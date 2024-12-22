package PracticeByMyself.class01_数组.method04_二分查找;

/**
 * @author mdy
 * @date 2024-12-20 17:37
 * @description
 */
public class pb02_找元素的最左和最右位置 {

    public static void main(String[] args) {

    }

    public static int[] searchRange(int[] nums, int target) {
        int[] res = new int[2];

        int left = 0, right = nums.length - 1;
        // 搜索区间为 [left, right]
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] >= target) {
                // 搜索区间变为 [left, mid-1]，或者收缩右侧边界
                right = mid - 1;
            } else {
                // 搜索区间变为 [mid+1, right]
                left = mid + 1;
            }
        }

        if (left < 0 || left >= nums.length) {
            res[0] =  -1;
        } else {
            res[0] = nums[left] == target ? left : -1;
        }


        left = 0;
        right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] <= target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        if (right < 0 || right >= nums.length) {
            res[1] = -1;
        } else {
            res[1] = nums[right] == target ? right : -1;
        }

        return res;
    }
}
