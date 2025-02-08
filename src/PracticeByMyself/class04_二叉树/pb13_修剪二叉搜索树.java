package PracticeByMyself.class04_二叉树;

import common.entity.TreeNode;

/**
 * @author Martin
 * @date 2025/1/6 12:47
 * @description <a href="https://leetcode.cn/problems/trim-a-binary-search-tree/description/">...</a>
 * 思路1：如果root的值小于low，左子树和自己全干掉；如果大于high，右子树和自己全干掉；
 * 如果在范围内，去修剪自己的左右子树。
 */

public class pb13_修剪二叉搜索树 {

    public static void main(String[] args) {

    }

    // 定义：修剪root
    public static TreeNode trimBST(TreeNode root, int low, int high) {
        if (root == null) {
            return null;
        }

        if (root.val < low) {
            root.left = null;
            return trimBST(root.right, low, high);
        } else if (root.val > high) {
            root.right = null;
            return trimBST(root.left, low, high);
        } else {
            root.right = trimBST(root.right, low, high);
            root.left = trimBST(root.left, low, high);
            return root;
        }
    }

}
