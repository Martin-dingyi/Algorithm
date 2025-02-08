package PracticeByMyself.class04_二叉树.二叉搜索树;

import common.entity.TreeNode;
import common.utils.TreeUtils;

/**
 * @author Martin
 * @date 2025/1/6 12:03
 * @description <a href="https://leetcode.cn/problems/recover-binary-search-tree/description/">...</a>
 * 思路1：中序遍历BST，第一次出现不递增的情况时，将两者互换
 */

public class pb12_恢复二叉搜索树 {

    public static void main(String[] args) {
        // 1 3 2 4
        TreeNode root = TreeUtils.deserializeTree("3,1,4,null,null,2");
        recoverTree(root);
        System.out.println(root);
    }

    static TreeNode preNode, swapNode1, swapNode2;
    public static void recoverTree(TreeNode root) {
        preNode = null;
        swapNode1 = null;
        swapNode2 = null;
        traverse(root);
        int temp = swapNode1.val;
        swapNode1.val = swapNode2.val;
        swapNode2.val = temp;
    }

    public static void traverse(TreeNode root) {
        if (root == null) {
            return;
        }
        traverse(root.left);
        // 找到第一个开始递减的结点
        if (preNode != null && root.val <= preNode.val) {
            if (swapNode1 == null) swapNode1 = preNode;
            swapNode2 = root;
        }
        preNode = root;
        traverse(root.right);
    }

}
