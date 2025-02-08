package PracticeByMyself.class05_图.DFS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Martin
 * @date 2025/1/25 11:10
 * @description <a href="https://leetcode.cn/problems/permutations-ii/description/">...</a>
 */

public class pb08_全排列2 {

    public static void main(String[] args) {
        int[] nums1 = new int[]{1, 1, 2};
        System.out.println(permuteUnique(nums1));
    }

    static List<List<Integer>> ans;
    static boolean[] used;
    public static List<List<Integer>> permuteUnique(int[] nums) {
        ans = new ArrayList<>();
        used = new boolean[nums.length];
        Arrays.sort(nums);
        traverse(nums, new ArrayList<>());
        return ans;
    }

    static void traverse(int[] nums, List<Integer> path) {
        if (path.size() == nums.length) {
            ans.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (used[i]) continue;
            // 只要保证相同元素的相对位置不变，就能保证结果不重复
            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1])  {
                continue;
            }

            path.add(nums[i]);
            used[i] = true;
            traverse(nums, path);
            path.remove(path.size() - 1);
            used[i] = false;
        }
    }

}
