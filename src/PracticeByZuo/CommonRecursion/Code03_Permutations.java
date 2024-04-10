package PracticeByZuo.CommonRecursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// 一个不含有重复数字的数组，给出它的所有排列情况
// 测试链接 : https://leetcode.cn/problems/permutations/
public class Code03_Permutations {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
//        f(nums, ans, 0);
        ArrayList<Integer> numsList = new ArrayList<>();
        for (int num : nums) {
            numsList.add(num);
        }
        compare(numsList, new ArrayList<>(), ans);
        return ans;
    }

    // 递归函数作用：排列从i+1开始的数。i位置的和后面所有数的位置都需要交换一次，每次交换后还要排列一次从i+1开始的数。
    // 每一次排列完成后，都要交换回来，防止干扰。
    // 比我的方法更优雅
    public static void f(int[] nums, List<List<Integer>> ans, int index) {
        if (index == nums.length - 1) {
            // 将现在nums的次序复制出来，存入ans
            List<Integer> list = new ArrayList<>();
            for (int num : nums) {
                list.add(num);
            }
            ans.add(list);
        } else {
            for (int i = index; i < nums.length; i++) {
                swap(nums, index, i);
                f(nums, ans, index + 1);
                swap(nums, index, i);
            }
        }
    }
    public static void swap(int[] nums, int x, int y) {
        int temp = nums[x];
        nums[x] = nums[y];
        nums[y] = temp;
    }

    // 我的实现
    public static void compare(ArrayList<Integer> numsList, ArrayList<Integer> list, List<List<Integer>> ans) {
        if (numsList.isEmpty()) {
            List<Integer> copyList = new ArrayList<>(list);
            ans.add(copyList);
            return;
        }
        for (Integer val : numsList) {
            ArrayList<Integer> tempList = new ArrayList<>(numsList);
            tempList.remove(val);
            list.add(val);
            compare(tempList, list, ans);
            list.remove(val);
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> ans = new ArrayList<>();
        int[] nums = {1, 2, 3};
        ArrayList<Integer> numsList = new ArrayList<>();
        for (int num : nums) {
            numsList.add(num);
        }
        compare(numsList, new ArrayList<>(), ans);
        for (List<Integer> list : ans) {
            System.out.println(Arrays.toString(list.toArray()));
        }
    }
}
