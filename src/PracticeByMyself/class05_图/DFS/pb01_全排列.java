package PracticeByMyself.class05_图.DFS;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Martin
 * @date 2025/1/24 15:41
 * @description <a href="https://leetcode.cn/problems/permutations/description/">...</a>
 */

public class pb01_全排列 {

    public static void main(String[] args) {
        System.out.println(permute(new int[]{1,2,3}));
    }

    static List<List<Integer>> ans;
    public static List<List<Integer>> permute(int[] nums) {
        ans = new ArrayList<>();
        HashSet<Integer> hashSet = new HashSet<>();
        for (int num : nums) {
            hashSet.add(num);
        }
        traverse(hashSet, new LinkedList<>());
        return ans;
    }

    static void traverse(HashSet<Integer> set, LinkedList<Integer> path) {
        if (set.isEmpty()) {
            ans.add(new ArrayList<>(path));
            return;
        }

        HashSet<Integer> tempSet = new HashSet<>(set);

        for (Integer num : tempSet) {
            path.addLast(num);
            set.remove(num);
            traverse(set, path);
            path.removeLast();
            set.add(num);
        }
    }

}
