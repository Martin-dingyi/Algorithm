package ByMartinPratice.二叉树;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

// 题目：不用递归实现树的三种遍历
public class Code02_BinaryTreeTraversal {
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


    public static void preorderTraversal(TreeNode root) {
        if (root == null) {
            return;
        }
        TreeNode ptr = root;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(ptr);
        while (!stack.isEmpty()) {
            ptr = stack.pop();
            System.out.print(ptr.val + " ");
            if (ptr.right != null) {
                stack.push(ptr.right);
            }
            if (ptr.left != null) {
                stack.push(ptr.left);
            }
        }
        System.out.println();
    }

    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null)
            return list;
        TreeNode ptr = root;
        Stack<TreeNode> stack = new Stack<>();
        while (!stack.isEmpty() || ptr != null) {
            if (ptr != null) {
                stack.push(ptr);
                ptr = ptr.left;
            } else {
                ptr = stack.pop();
                list.add(ptr.val);
                ptr = ptr.right;
            }
        }
       return list;
    }

    public static List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode ptr = root;
        TreeNode lastValue = root;
        stack.push(ptr);
        // ptr第一次指到的结点一定入栈，从栈中出去的结点一定被访问
        // 优先访问左孩子，其次为右，最后访问父结点
        while (!stack.isEmpty()) {
            ptr = stack.peek();
            if (ptr.left != null && ptr.left != lastValue && ptr.right != lastValue) {
                // 如果左子树存在且没有被访问过，优先遍历左子树
                ptr = ptr.left;
                stack.push(ptr);
            } else if (ptr.right != null && ptr.right != lastValue) {
                // 如果左子树不存在，右子树存在且没有被访问过，则遍历右子树
                ptr = ptr.right;
                stack.push(ptr);
            } else {
                // 如果左右子树都不存在或已经被访问过，则遍历父结点
                lastValue = stack.pop();
                list.add(lastValue.val);
            }
        }
        return list;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(6);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        System.out.println((Arrays.toString(postorderTraversal(root).toArray())));
        posOrder(root);
    }

    public static void preOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.print(root.val + " ");
        preOrder(root.left);
        preOrder(root.right);
    }

    public static void inOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        inOrder(root.left);
        System.out.print(root.val + " ");
        inOrder(root.right);
    }

    public static void posOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        posOrder(root.left);
        posOrder(root.right);
        System.out.print(root.val + " ");
    }
}
