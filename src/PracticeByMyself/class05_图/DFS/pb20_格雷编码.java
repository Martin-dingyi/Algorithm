package PracticeByMyself.class05_图.DFS;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * @author Martin
 * @date 2025/1/27 18:58
 * @description <a href="https://leetcode.cn/problems/gray-code/">...</a>
 */

public class pb20_格雷编码 {

    public static void main(String[] args) {
        System.out.println(grayCode(10));
    }

    static List<Integer> ans;
    static HashSet<Integer> set;
    public static List<Integer> grayCode(int n) {
        ans = null;
        set = new HashSet<>();
        List<Integer> path = new ArrayList<>();
        path.add(0);
        set.add(0);
        traverse(n, path);
        return ans;
    }

    static void traverse(int n, List<Integer> path) {
        if (ans != null) {
            return;
        }
        if (path.size() ==  1 << n) {
            ans = new ArrayList<>(path);
            return;
        }
        for (int i = 0; i < n; i++) {
            if (ans != null) {
                return;
            }

            int curNum = flipBit(path.get(path.size() - 1), i);

            if (set.contains(curNum)) continue;
            path.add(curNum);
            set.add(curNum);
            traverse(n, path);
            set.remove(curNum);
            path.remove(path.size() - 1);
        }
    }
    // 把第 i 位取反（0 变 1，1 变 0）
    private static int flipBit(int x, int i) {
        return x ^ (1 << i);
    }
}
