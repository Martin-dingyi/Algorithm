package PracticeByMyself.class04_二叉树.二叉搜索树;

import common.entity.TreeNode;

/**
 * @author Martin
 * @date 2025/1/4 11:24
 * @description <a href="https://leetcode.cn/problems/range-sum-of-bst/description/">...</a>
 */

public class pb11_二叉搜索树的范围和 {

    public static void main(String[] args) {

    }

    public static int rangeSumBST(TreeNode root, int low, int high) {
        if (root == null) {
            return 0;
        }

        if (root.val <= high && root.val >= low) {
            return root.val + rangeSumBST(root.left, low, high) + rangeSumBST(root.right, low, high);
        } else if (root.val > high) {
            return rangeSumBST(root.left, low, high);
        } else {
            return rangeSumBST(root.right, low, high);
        }
    }


}
