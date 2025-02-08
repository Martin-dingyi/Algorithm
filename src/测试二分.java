import common.ArrayUtils;

public class 测试二分 {

    public static void main(String[] args) {
        comparator();
        testLeftBound();
//        testRightBound();
    }

    private static void comparator() {
        for (int i = 0; i < 500000; i++) {
            int[] nums = ArrayUtils.generateRandomArray(500, 1000);
            int target = (int) (Math.random() * 1005);
            left_bound(nums, target);
            right_bound(nums, target);
//            if (left_bound(nums, target) == -1) {
//                System.out.println("有错误！");
//                break;
//            }
        }
    }

    private static void testLeftBound() {
        int[] nums1 = {1, 5, 5, 9};
        System.out.println(left_bound(nums1, -200)); // 0
        System.out.println(left_bound(nums1, 1)); // 0
        System.out.println(left_bound(nums1, 4)); // 1
        System.out.println(left_bound(nums1, 5)); // 1
        System.out.println(left_bound(nums1, 7)); // 3
        System.out.println(left_bound(nums1, 100)); // 3 or -1
    }

    public static int left_bound(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] >= target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return left == nums.length ? -1 : left;
    }

    private static void testRightBound() {
        int[] nums1 = {1, 5, 5, 9};
        System.out.println(right_bound(nums1, -200)); // 0 or -1
        System.out.println(right_bound(nums1, 1)); // 0
        System.out.println(right_bound(nums1, 4)); // 0
        System.out.println(right_bound(nums1, 5)); // 2
        System.out.println(right_bound(nums1, 7)); // 2
        System.out.println(right_bound(nums1, 100)); // 3
    }

    public static int right_bound(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] <= target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return right;
    }
}
