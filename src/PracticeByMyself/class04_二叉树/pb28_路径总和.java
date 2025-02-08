package PracticeByMyself.class04_二叉树;

import common.entity.TreeNode;

/**
 * @author Martin
 * @date 2025/1/4 10:19
 * @description <a href="https://leetcode.cn/problems/path-sum/">...</a>
 */

public class pb28_路径总和 {

    public static void main(String[] args) {

    }

    // 定义：
    public boolean hasPathSum(TreeNode root, int targetSum) {
        return false;
    }


    public boolean hasPathSum_traverse(TreeNode root, int targetSum) {
         return isExistsTargetSum(root, targetSum);
    }

    boolean isExistsTargetSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        targetSum -= root.val;
        if (root.left == null && root.right == null) {
            return targetSum == 0;
        }
        return isExistsTargetSum(root.left, targetSum) | isExistsTargetSum(root.right, targetSum);
    }
}
