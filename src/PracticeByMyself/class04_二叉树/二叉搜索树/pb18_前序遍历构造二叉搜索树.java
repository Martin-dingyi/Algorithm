package PracticeByMyself.class04_二叉树.二叉搜索树;

import common.entity.TreeNode;

/**
 * @author Martin
 * @date 2025/1/8 15:30
 * @description
 * 思路：前序遍历往往不知道什么时候一颗子树构建完毕，BST的性质可以提供这个边界
 */

public class pb18_前序遍历构造二叉搜索树 {

    public static void main(String[] args) {

    }

    static int index;
    public static TreeNode bstFromPreorder(int[] preorder) {
        index = 0;
        return bstFromPreorder(preorder, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    static TreeNode bstFromPreorder(int[] preorder, int min, int max) {
        if (index == preorder.length || preorder[index] <= min || preorder[index] >= max) {
            return null;
        }

        int val = preorder[index++];
        TreeNode root = new TreeNode(val);
        root.left = bstFromPreorder(preorder, min, val);
        root.right = bstFromPreorder(preorder, val, max);
        return root;
    }
}
