package Class03_二叉树;

import java.util.HashMap;

// 根据先序和中序序列构建二叉树
// https://leetcode.cn/problems/construct-binary-tree-from-preorder-and-inorder-traversal/description/

public class Code007_ConstructBinaryTreeFromPreorderAndInorderTraversal {
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

    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        preIndex = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return buildLocTree(preorder, inorder, 0, inorder.length - 1, map);
    }

    public static int preIndex;

    // 递归函数定义：创建出根节点，并构建出它的左右子树
    public static TreeNode buildLocTree(int[] preorder, int[] inorder, int inLeft, int inRight, HashMap<Integer, Integer> map) {
        if (preIndex == inorder.length || inLeft > inRight) {
            return null;
        }

        TreeNode root = new TreeNode(preorder[preIndex++]);
        if (inLeft == inRight) {
            return root;
        }
        int index = map.get(root.val);
        root.left = buildLocTree(preorder, inorder, inLeft, index - 1, map);
        root.right = buildLocTree(preorder, inorder, index + 1, inRight, map);
        return root;
    }

    public static void main(String[] args) {
        int[] preorder = {3, 9, 20, 15, 7};
        int[] inorder = {9, 3, 15, 20, 7};
        buildTree(preorder, inorder);
    }
}
