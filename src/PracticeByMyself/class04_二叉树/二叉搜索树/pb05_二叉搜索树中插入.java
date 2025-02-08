package PracticeByMyself.class04_二叉树.二叉搜索树;

import common.entity.TreeNode;

/**
 * @author Martin
 * @date 2024/12/30 9:43
 * @description <a href="https://leetcode.cn/problems/insert-into-a-binary-search-tree/">...</a>
 */

public class pb05_二叉搜索树中插入 {

    public static void main(String[] args) {

    }

    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }

        if (val < root.val) {
            if (root.left == null) {
                root.left = new TreeNode(val);
            } else {
                root.left = insertIntoBST(root.left, val);
            }
        } else {
            if (root.right == null) {
                root.right = new TreeNode(val);
            } else {
                root.right = insertIntoBST(root.right, val);
            }
        }
        return root;
    }
}
