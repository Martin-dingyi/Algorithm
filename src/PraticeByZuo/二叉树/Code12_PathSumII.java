package ByMartinPratice.二叉树;

import java.util.ArrayList;
import java.util.List;

// 题目：收集累加和等于targetSum的所有路径，要求从根节点到叶子结点。
public class Code12_PathSumII {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }

    }

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        int sum = 0;
        if (root == null) {
            return ans;
        }
        f(root, targetSum, sum, list, ans);
        return ans;
    }

    public static void f(TreeNode root, int targetSum, int sum, List<Integer> list, List<List<Integer>> ans) {
        list.add(root.val);
        sum += root.val;
        if (root.left == null && root.right == null) {
            if (sum == targetSum) {
                copy(ans, list);
            }
            list.remove(list.size() - 1);
            return;
        }
        if (root.left != null) {
            f(root.left, targetSum, sum, list, ans);
        }
        if (root.right != null) {
            f(root.right, targetSum, sum, list, ans);
        }
        list.remove(list.size() - 1);
    }

    public static void copy(List<List<Integer>> ans, List<Integer> list) {
        List<Integer> copy = new ArrayList<>(list);
        ans.add(copy);
    }
}
