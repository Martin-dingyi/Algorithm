package PracticeByMyself.class04_二叉树;

import common.entity.TreeNode;

/**
 * @author Martin
 * @date 2025/1/5 15:30
 * @description <a href="https://leetcode.cn/problems/delete-leaves-with-a-given-value/">...</a>
 */

public class pb36_删除给定值的叶子节点 {

    public static void main(String[] args) {

    }

    // 定义：删除左右子树的满足条件的叶子结点，返回删减后的子树头结点（可能为null）
    public static TreeNode removeLeafNodes(TreeNode root, int target) {
        if (root == null) {
            return null;
        }
        root.left = removeLeafNodes(root.left, target);
        root.right = removeLeafNodes(root.right, target);
        if (root.left == null && root.right == null && root.val == target) {
            return null;
        }
        return root;
    }
}
