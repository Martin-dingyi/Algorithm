package PracticeByMyself.class04_二叉树;

import common.entity.TreeNode;
import common.utils.TreeUtils;

import java.util.HashMap;

/**
 * @author Martin
 * @date 2024/12/28 10:47
 * @description <a href="https://leetcode.cn/problems/construct-binary-tree-from-preorder-and-inorder-traversal/">...</a>
 */

public class pb11_先序和中序构建二叉树 {

    public static void main(String[] args) {
        int[] preorder = {3,9,20,15,7};
        int[] inorder = {9,3,15,20,7};
        TreeUtils.printBinaryTree(buildTree(preorder, inorder));
    }

    public static int index;
    public  static TreeNode buildTree(int[] preorder, int[] inorder) {
        index = 0;
        // 题干说了没有重复值，所以可以用map优化
        HashMap<Integer, Integer> numToIndex = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            numToIndex.put(inorder[i], i);
        }
        return buildRootNode(preorder, numToIndex, 0, inorder.length - 1);
    }

    public static TreeNode buildRootNode(int[] preorder, HashMap<Integer, Integer> numToIndex, int left, int right) {
        if (left > right) {
            return null;
        }

        int val = preorder[index++];
        TreeNode root = new TreeNode(val);
        int inorderIndex = numToIndex.get(val);
        root.left = buildRootNode(preorder, numToIndex, left, inorderIndex - 1);
        root.right = buildRootNode(preorder, numToIndex, inorderIndex + 1, right);
        return root;
    }
}
