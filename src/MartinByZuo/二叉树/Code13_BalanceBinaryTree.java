package MartinByZuo.二叉树;

// 题目：验证平衡二叉树
public class Code13_BalanceBinaryTree {
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

    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        int leftHigh = high(root.left);
        int rightHigh = high(root.right);
        if (Math.abs(leftHigh - rightHigh) > 1) {
            return false;
        }
        return isBalanced(root.left) && isBalanced(root.right);
    }

    public static int high(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(high(root.left), high(root.right)) + 1;
    }
}
