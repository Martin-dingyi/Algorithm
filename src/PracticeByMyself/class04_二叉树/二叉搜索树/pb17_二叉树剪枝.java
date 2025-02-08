package PracticeByMyself.class04_二叉树.二叉搜索树;

import common.entity.TreeNode;

/**
 * @author Martin
 * @date 2025/1/8 15:26
 * @description <a href="https://leetcode.cn/problems/binary-tree-pruning/">...</a>
 */

public class pb17_二叉树剪枝 {

    public static void main(String[] args) {

    }

    // 定义：移除左右子树的无1树，再修剪自己，返回修剪后的树头结点
    public static TreeNode pruneTree(TreeNode root) {
        if (root == null) {
            return null;
        }

        root.left = pruneTree(root.left);
        root.right = pruneTree(root.right);
        if (root.left == null && root.right == null && root.val != 1) {
            return null;
        }
        return root;
    }
}
