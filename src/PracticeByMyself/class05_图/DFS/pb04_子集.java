package PracticeByMyself.class05_图.DFS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Martin
 * @date 2025/1/25 10:01
 * @description <a href="https://leetcode.cn/problems/subsets/">...</a>
 */

public class pb04_子集 {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        System.out.println(subsets(nums));
    }

    static List<List<Integer>> ans;
    public static List<List<Integer>> subsets(int[] nums) {
        ans = new LinkedList<>();
        ans.add(new LinkedList<>());
        traverse(nums, 0, new LinkedList<>());
        return ans;
    }

    static void traverse(int[] nums, int index, LinkedList<Integer> subset) {
        for (int i = index; i < nums.length; i++) {
            subset.addLast(nums[i]);
            ans.add(new LinkedList<>(subset));
            traverse(nums, i + 1, subset);
            subset.removeLast();
        }
    }

}
