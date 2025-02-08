package PracticeByMyself.class04_二叉树;

import common.entity.TreeNode;

/**
 * @author Martin
 * @date 2024/12/27 9:22
 * @description <a href="https://leetcode.cn/problems/invert-binary-tree/">...</a>
 * 思路1：最最经典的用递归来解的二叉树题。
 */

public class pb07_翻转二叉树 {

    public static void main(String[] args) {

    }

    // 递归函数定义：翻转root的左右子树，然后去翻转左右子树的子树。
    public static TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }

        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        invertTree(root.left);
        invertTree(root.right);

        return root;
    }

}
