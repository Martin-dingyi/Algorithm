package MartinByZuo.二叉树;

// 题目：先序、中序、后序遍历二叉树的递归版本
public class Code01_BinaryTreeTraversalRecursion {
    static class Node {
        int val;
        Node left;
        Node right;

        public Node (int val) {
            this.val = val;
        }
    }

    public void preOrder (Node root) {
        if (root == null) {
            return;
        }
        System.out.println(root.val);
        preOrder(root.left);
        preOrder(root.right);
    }

    public void inOrder (Node root) {
        if (root == null) {
            return;
        }
        inOrder(root.left);
        System.out.println(root.val);
        inOrder(root.right);
    }

    public void posOrder (Node root) {
        if (root == null) {
            return;
        }
        posOrder(root.left);
        posOrder(root.right);
        System.out.println(root.val);
    }
}
