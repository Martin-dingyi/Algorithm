package PracticeByMyself.class04_二叉树;

import common.entity.TreeNode;

import java.util.HashMap;

/**
 * @author Martin
 * @date 2024/12/28 11:02
 * @description
 */

public class pb12_中序和后序构建二叉树 {

    public static void main(String[] args) {

    }

    public static int index;
    public  static TreeNode buildTree(int[] inorder, int[] postorder) {
        index = postorder.length - 1;
        // 题干说了没有重复值，所以可以用map优化
        HashMap<Integer, Integer> numToIndex = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            numToIndex.put(inorder[i], i);
        }
        return buildRootNode(postorder, numToIndex, 0, inorder.length - 1);
    }

    public static TreeNode buildRootNode(int[] postorder, HashMap<Integer, Integer> numToIndex, int left, int right) {
        if (left > right) {
            return null;
        }

        int val = postorder[index--];
        TreeNode root = new TreeNode(val);
        int inorderIndex = numToIndex.get(val);
        root.right = buildRootNode(postorder, numToIndex, inorderIndex + 1, right);
        root.left = buildRootNode(postorder, numToIndex, left, inorderIndex - 1);
        return root;
    }
}
