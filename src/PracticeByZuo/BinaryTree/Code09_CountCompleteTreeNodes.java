package PracticeByZuo.BinaryTree;

// 题目：计算完全二叉树的结点个数，时间要求小于O(n)
public class Code09_CountCompleteTreeNodes {
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
    public static int level = 1;

    // 作用：查出一个以root为根的树的结点数
    // 满二叉树的结点计算公式：2^h-1
    public static int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int ans;
        int high_left = size(root.left);
        int high_right = size(root.right);
        if (high_left == high_right) {
            // 1.一个完全二叉树左右子树都能到底，则左子树是一个满二叉树
            ans = (int) Math.pow(2, high_left);
            return ans + countNodes(root.right);
        } else {
            // 2.左子树能到底，但右子树不能，则右子树是一个满二叉树
            ans = (int) Math.pow(2, high_right);
            return ans + countNodes(root.left);
        }
    }

    public static int size(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(size(root.left), size(root.right)) + 1;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(6);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        System.out.println(countNodes(root));
    }

    public static void preOrderPrint(TreeNode tree) {
        if (tree == null) {
            return;
        }
        System.out.print(tree.val + ",");
        preOrderPrint(tree.left);
        preOrderPrint(tree.right);
    }

}
