package Class03_二叉树;

import java.util.ArrayList;
import java.util.List;

// 二叉树前序遍历
// https://leetcode.cn/problems/binary-tree-preorder-traversal/
public class Code002_BinaryTreePreorderTraversal {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

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
