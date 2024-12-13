package PracticeByMyself.class01_数组;

import java.util.HashMap;

/**
 * @author mdy
 * @date 2024-12-07 16:27
 * @description <a href="https://leetcode.cn/problems/two-sum/">...</a>
 */
public class pb03_twoSum {

    public static void main(String[] args) {

    }

    public int[] twoSum(int[] nums, int target) {
        int[] ans = new int[2];
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
