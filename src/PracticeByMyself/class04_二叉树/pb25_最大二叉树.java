package PracticeByMyself.class04_二叉树;

import common.entity.TreeNode;

/**
 * @author Martin
 * @date 2025/1/2 11:16
 * @description <a href="https://leetcode.cn/problems/maximum-binary-tree-ii/">...</a>
 */

public class pb25_最大二叉树 {

    public static void main(String[] args) {

    }

    public static TreeNode insertIntoMaxTree(TreeNode root, int val) {
        if (root == null || val > root.val) {
            TreeNode newRoot = new TreeNode(val);
            newRoot.left = root;
            return newRoot;
        } else {
            root.right = insertIntoMaxTree(root.right, val);
        }
        return root;
    }
}
