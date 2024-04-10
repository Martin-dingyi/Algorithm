package PracticeByZuo.CommonRecursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

// 这题和code1本事上是同种题型，只是这种有leetcode测试
// 比如输入：nums = [1,2,2]
// 输出：[[],[1],[1,2],[1,2,2],[2],[2,2]]
// 测试链接 : https://leetcode.cn/problems/subsets-ii/
public class Code02_Combinations {
    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        HashSet<List<Integer>> set = new HashSet<>();
        f(nums, 0, new ArrayList<>(), set);
        return new ArrayList<>(set);
    }

    public static void f(int[] nums, int index, List<Integer> list, HashSet<List<Integer>> set) {
        if (index == nums.length) {
            List<Integer> copy = new ArrayList<>(list);
            copy.sort((a, b) -> (b - a));
            set.add(copy);
        } else {
            f(nums, index + 1, list, set);
            list.add(nums[index]);
            f(nums, index + 1, list, set);
            list.remove(list.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 1, 2};
        System.out.println(Arrays.toString(subsetsWithDup(nums).toArray()));
    }
}
