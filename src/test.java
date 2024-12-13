import java.util.HashMap;

public class test {
    public static void main(String[] args) {
        int[] nums = {1, 2, 2, 2, 2, 2, 3, 4, 5};
        System.out.println(testBinary(nums, 2));
    }

    public static void print(String a, int...i) {
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
        int ans = -1;

        while (left <= right) {
            int mid = left - ((left - right) >> 1);

            if (arr[mid] >= target) {
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return ans;
    }
}
