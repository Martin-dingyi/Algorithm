import java.util.HashMap;

public class test {
    public static void main(String[] args) {
        print("测试可变参数", 1, 2, 3);
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
}
