package PracticeByMyself.class04_二叉树.二叉搜索树;

import common.entity.TreeNode;

/**
 * @author Martin
 * @date 2024/12/29 10:11
 * @description <a href="https://leetcode.cn/problems/convert-bst-to-greater-tree/">...</a>
 * 思路1：中序遍历二叉搜索树，sum-前缀和就是
 */

public class pb02_把二叉搜索树转换为累加树 {

    public static void main(String[] args) {

    }

    public static int prefixSum;
    public static TreeNode convertBST(TreeNode root) {
        prefixSum = 0;
        traverse(root);
        return root;
    }

    public static void traverse(TreeNode root) {
        if (root == null) {
            return;
        }
        traverse(root.right);
        prefixSum += root.val;
        root.val = prefixSum;
        traverse(root.left);
    }
}
