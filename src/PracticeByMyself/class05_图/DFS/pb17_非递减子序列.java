package PracticeByMyself.class05_图.DFS;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * @author Martin
 * @date 2025/1/27 13:52
 * @description <a href="https://leetcode.cn/problems/non-decreasing-subsequences/description/">...</a>
 */

public class pb17_非递减子序列 {

    public static void main(String[] args) {

    }

    static List<List<Integer>> ans;
    public static List<List<Integer>> findSubsequences(int[] nums) {
        ans = new ArrayList<>();
        traverse(nums, 0, new ArrayList<>());
        return ans;
    }

    static void traverse(int[] nums, int index, List<Integer> path) {
        if (index >= nums.length) {
            return;
        }

        HashSet<Integer> used = new HashSet<>();
        for (int i = index; i < nums.length; i++) {
            if (!path.isEmpty()) {
                if (nums[i] < path.get(path.size() - 1)) {
                    continue;
                }
            }
            if (used.contains(nums[i])) {
                continue;
            }
            used.add(nums[i]);

            path.add(nums[i]);
            if (path.size() > 1) {
                ans.add(new ArrayList<>(path));
            }
            traverse(nums, i + 1, path);
            path.remove(path.size() - 1);
        }
    }
}
