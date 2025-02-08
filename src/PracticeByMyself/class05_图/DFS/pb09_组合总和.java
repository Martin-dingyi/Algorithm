package PracticeByMyself.class05_图.DFS;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Martin
 * @date 2025/1/26 18:54
 * @description <a href="https://leetcode.cn/problems/combination-sum/">...</a>
 * 思路：无论是排列和组合，只要能保证元素的相对位置不变，就不会有重复的答案出现
 */

public class pb09_组合总和 {

    public static void main(String[] args) {

    }

    static List<List<Integer>> ans;
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        ans = new ArrayList<>();
        traverse(candidates, target, 0, new ArrayList<>(), 0);
        return ans;
    }

    static void traverse(int[] candidates, int target, int start, List<Integer> path, int pathSum) {
        if (pathSum == target) {
            ans.add(new ArrayList<>(path));
        } else if (pathSum > target) {
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            path.add(candidates[i]);
            traverse(candidates, target, i, path, pathSum + candidates[i]);
            path.remove(path.size() - 1);
        }
    }
}
