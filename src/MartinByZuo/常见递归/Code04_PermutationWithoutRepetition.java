package MartinByZuo.常见递归;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Code04_PermutationWithoutRepetition {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        f(nums, ans, 0);
        return ans;
    }

    // 递归函数作用：排列从i+1开始的数。i位置的和后面所有数的位置都需要交换一次，每次交换后还要排列一次从i+1开始的数。
    // 每一次排列完成后，都要交换回来，防止干扰。
    public static void f(int[] nums, List<List<Integer>> ans, int index) {
        if (index == nums.length - 1) {
            // 将现在nums的次序复制出来，存入ans
            List<Integer> list = new ArrayList<>();
            for (int num : nums) {
                list.add(num);
            }
            ans.add(list);
        } else {
            HashSet<Integer> set = new HashSet<>();
            for (int i = index; i < nums.length; i++) {
                if (!set.contains(nums[i])) {
                    set.add(nums[i]);
                    swap(nums, index, i);
                    f(nums, ans, index + 1);
                    swap(nums, index, i);
                }
            }
        }
    }

    public static void swap(int[] nums, int x, int y) {
        int temp = nums[x];
        nums[x] = nums[y];
        nums[y] = temp;
    }
}
