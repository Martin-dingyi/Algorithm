package PracticeByDong;

// 二叉树展开为链表
// https://leetcode.cn/problems/flatten-binary-tree-to-linked-list/?utm_source=LCUS&utm_medium=ip_redirect&utm_campaign=transfer2china
public class Code004_FlattenBinaryTreeToLinkedList {
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

    public static void flatten(TreeNode root) {
        // 叶子结点和空树不用翻转
        if (root == null || (root.left == null && root.right == null)) {
            return;
        }
        cur = new TreeNode();
        TreeNode newRoot = cur;
        traverse(root);
        cur = newRoot.right.right;
        TreeNode ptr = root;
        while (cur != null) {
            ptr.left = null;
            ptr.right = cur;
            ptr = ptr.right;
            cur = cur.right;
        }
    }

    public static TreeNode cur;
    public static void traverse(TreeNode root) {
        if (root == null) {
            return;
        }
        cur.right = new TreeNode(root.val);
        cur = cur.right;
        traverse(root.left);
        traverse(root.right);
    }

    // 递归函数含义：将以root为根的二叉树拉成链表
    public static TreeNode recur_flatten(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode left = recur_flatten(root.left);
        TreeNode right = recur_flatten(root.right);
        root.right = left;
        root.left = null;
        TreeNode ptr = root;
        while (ptr.right != null) {
            ptr = ptr.right;
        }
        ptr.right = right;
        return root;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        flatten(root);
        System.out.println();
    }
}
