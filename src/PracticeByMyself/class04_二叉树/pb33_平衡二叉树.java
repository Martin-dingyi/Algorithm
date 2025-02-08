package PracticeByMyself.class04_二叉树;

import common.entity.TreeNode;

/**
 * @author Martin
 * @date 2025/1/5 14:53
 * @description <a href="https://leetcode.cn/problems/balanced-binary-tree/">...</a>
 */

public class pb33_平衡二叉树 {

    public static void main(String[] args) {

    }

    // 定义：判断root树是否是平衡二叉树
    public static boolean isBalanced(TreeNode root) {
        return getDepthAndIsBalanced(root) != -1;
    }

    // 定义：判断左右子树是否为平衡二叉树，获得左右子树的高度，判断自己是不是平衡二叉树，返回自己的高度
    public static int getDepthAndIsBalanced(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftDepth = getDepthAndIsBalanced(root.left);
        int rightDepth = getDepthAndIsBalanced(root.right);

        if (leftDepth == -1 || rightDepth == -1 || Math.abs(leftDepth - rightDepth) > 1 ) {
            return -1;
        }

        return Math.max(leftDepth, rightDepth) + 1;
    }

}
