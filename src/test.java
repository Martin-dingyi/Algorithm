import java.util.HashMap;

public class test {
    public static void main(String[] args) {
//        int[] nums1 = {1, 2, 2, 2, 2, 2, 4, 4, 4, 5};
//        int[] nums2 = {2, 3, 5, 8};
//
//        // 结果：1
//        System.out.println(left_bound(nums1, 2));
//        // 2
//        System.out.println(left_bound(nums2, 4));

        String[] strings = {"hello", "world", "你好", "世界"};
        System.out.println(String.join("#", strings));
    }

    public static void print(String a, int... i) {
        System.out.println(a);
        System.out.println(i[0] + "\n" + i[1] + "\n" + i[2]);
        String strToNum = "123";
        int num = Integer.parseInt(strToNum);
    }


    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int needNum = target - nums[i];
            if (map.containsKey(needNum)) {
                return new int[]{i, map.get(needNum)};
            }
            map.put(nums[i], i);
        }
        return new int[]{-1, -1};
    }

    private static int testBinary(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        int targetIndex = -1;

        while (left <= right) {
            int mid = left - ((left - right) >> 1);

            // 1 2 2 2 2 2 2 3 4
            if (target <= arr[mid]) {
                targetIndex = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return targetIndex;
    }

    static int left_bound(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        // 搜索区间为 [left, right]
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                // 搜索区间变为 [mid+1, right]
                left = mid + 1;
            } else if (nums[mid] > target) {
                // 搜索区间变为 [left, mid-1]
                right = mid - 1;
            } else if (nums[mid] == target) {
                // 收缩右侧边界
                right = mid - 1;
            }
        }
        // 判断 target 是否存在于 nums 中
        // 如果越界，target 肯定不存在，返回 -1
        if (left < 0 || left >= nums.length) {
            return -1;
        }
        // 判断一下 nums[left] 是不是 target
        return nums[left] == target ? left : -1;
    }
}
