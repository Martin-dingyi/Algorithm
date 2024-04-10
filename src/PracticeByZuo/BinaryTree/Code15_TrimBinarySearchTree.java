package PracticeByZuo.BinaryTree;

// 题目：给定最小边界low和最大边界high，通过修剪二叉搜索树，使得所有节点的值在[low, high]中。

public class Code15_TrimBinarySearchTree {
    public static class TreeNode {
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

    public TreeNode trimBST(TreeNode root, int low, int high) {
        if (root == null) {
            return null;
        }
        // 如果root大于high，则root以及它的右子树全部舍弃
        // 如果root小于low，则root以及它的左子树全部舍弃
        // 如果root在给定范围上，则保留root，继续修建root的左右子树
        if (root.val > high) {
            root = trimBST(root.left, low, high);
        } else if (root.val < low) {
            root = trimBST(root.right, low, high);
        } else {
            root.left = trimBST(root.left, low, high);
            root.right = trimBST(root.right, low, high);
        }
        return root;
    }


}
