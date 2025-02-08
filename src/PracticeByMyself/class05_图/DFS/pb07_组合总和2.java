package PracticeByMyself.class05_图.DFS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Martin
 * @date 2025/1/25 11:03
 * @description <a href="https://leetcode.cn/problems/combination-sum-ii/">...</a>
 */

public class pb07_组合总和2 {

    public static void main(String[] args) {

    }

    static List<List<Integer>> ans;
    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        ans = new ArrayList<>();
        Arrays.sort(candidates);
        traverse(candidates, 0, new ArrayList<>(), 0, target);
        return ans;
    }

    static void traverse(int[] nums, int index, List<Integer> path, int pathSum, int target) {
        if (pathSum == target) {
            ans.add(new ArrayList<>(path));
        } else if (pathSum > target) {
            return;
        }

        for (int i = index; i < nums.length; i++) {
            if (i > index && nums[i] == nums[i - 1]) continue;
            path.add(nums[i]);
            traverse(nums, i + 1, path, pathSum + nums[i], target);
            path.remove(path.size() - 1);
        }
    }
}
