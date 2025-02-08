package PracticeByMyself.class05_图.DFS;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Martin
 * @date 2025/1/25 10:15
 * @description <a href="https://leetcode.cn/problems/combinations/description/">...</a>
 */

public class pb05_组合 {

    public static void main(String[] args) {
        System.out.println(combine(4, 2));
    }

    public static List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ans = new ArrayList<>();
        traverse(1, new ArrayList<>(), ans, n, k);
        return ans;
    }

    static void traverse(int begin, List<Integer> path, List<List<Integer>> ans, int n, int k) {
        if (path.size() == k) {
            ans.add(new ArrayList<>(path));
            return;
        }

        for (int i = begin; i <= n; i++) {
            path.add(i);
            traverse(i + 1, path, ans, n, k);
            path.remove(path.size() - 1);
        }

    }

}
