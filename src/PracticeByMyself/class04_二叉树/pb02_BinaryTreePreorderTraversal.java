package PracticeByMyself.class04_二叉树;

import common.entity.TreeNode;

import java.util.ArrayList;
import java.util.List;

// 二叉树前序遍历
// https://leetcode.cn/problems/binary-tree-preorder-traversal/

public class pb02_BinaryTreePreorderTraversal {
    public List<Integer> preorderTraversal(TreeNode root) {
        list = new ArrayList<>();
        traverse(root);
        return list;
    }

    public static List<Integer> list;
    public static void traverse(TreeNode root) {
        if (root == null) {
            return;
        }
        list.add(root.val);
        traverse(root.left);
        traverse(root.right);
    }
}
