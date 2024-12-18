package PracticeByMyself.class01_数组.method01_哈希表;

import java.util.HashMap;

/**
 * @author mdy
 * @date 2024-12-07 16:27
 * @description <a href="https://leetcode.cn/problems/two-sum/">...</a>
 * 思路1：遍历数组，用哈希表记录数值和下标，每次遍历时也查看哈希表中是否有可以组成target的数
 */
public class pb03_twoSum {

    public static void main(String[] args) {

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
