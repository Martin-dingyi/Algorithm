package PracticeByMyself.class05_图.DFS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Martin
 * @date 2025/1/29 18:09
 * @description <a href="https://leetcode.cn/problems/number-of-squareful-arrays/description/">...</a>
 */

public class pb28_平方数组的数目 {

    public static void main(String[] args) {

    }

    static int ans;
    static boolean[] used;
    public static int numSquarefulPerms(int[] nums) {
        ans = 0;
        used = new boolean[nums.length];
        Arrays.sort(nums);
        traverse(nums, new ArrayList<>());
        return ans;
    }

    static void traverse(int[] nums, List<Integer> path) {
        if (path.size() == nums.length) {
            ans++;
        }

        for (int i = 0; i < nums.length; i++) {
            if (used[i]) {
                continue;
            }

            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) {
                continue;
            }

            if (!path.isEmpty()) {
                if (!isValid(nums[i], path.get(path.size() - 1))) {
                    continue;
                }
            }

            used[i] = true;
            path.add(nums[i]);
            traverse(nums, path);
            path.remove(path.size() - 1);
            used[i] = false;
        }
    }

    private static boolean isValid(int a, int b) {
        int c = (int) Math.sqrt(a + b);
        return c * c == a + b;
    }

}
