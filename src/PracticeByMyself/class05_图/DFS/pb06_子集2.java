package PracticeByMyself.class05_图.DFS;

import java.util.*;

/**
 * @author Martin
 * @date 2025/1/25 10:33
 * @description <a href="https://leetcode.cn/problems/subsets-ii/">...</a>
 * 思路1：和子集1的区别：数组中可能含有重复元素，但返回的子集不可以重复，所以用set来保存子集即可
 */

public class pb06_子集2 {

    public static void main(String[] args) {
        System.out.println(subsetsWithDup(new int[]{1, 2, 2}));
    }

    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> subsets = new ArrayList<>();
        Arrays.sort(nums);
        subsets.add(new ArrayList<>());
        traverse(nums, 0,new ArrayList<>(), subsets);
        return subsets;
    }

    static void traverse(int[] nums, int index, List<Integer> path, List<List<Integer>> subsets) {
        for (int i = index; i < nums.length; i++) {
            // 子集去重的经典方法，要记住
            if (i > index && nums[i] == nums[i - 1]) continue;
            path.add(nums[i]);
            subsets.add(new ArrayList<>(path));
            traverse(nums, i + 1, path, subsets);
            path.remove(path.size() - 1);
        }
    }

}
