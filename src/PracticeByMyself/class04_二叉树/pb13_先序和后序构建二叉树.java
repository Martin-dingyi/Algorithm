package PracticeByMyself.class04_二叉树;

import common.entity.TreeNode;

import java.util.HashMap;

/**
 * @author Martin
 * @date 2024/12/28 11:05
 * @description <a href="https://leetcode.cn/problems/construct-binary-tree-from-preorder-and-postorder-traversal/description/">...</a>
 * 思路1：根据preorder的顺序构建二叉树，根据postorder去限制构建二叉树结点数量
 */

public class pb13_先序和后序构建二叉树 {
    public static void main(String[] args) {
        int[] preorder = {1,2,4,5,3,6,7};
        int[] postorder = {4,5,2,6,7,3,1};
        System.out.println(constructFromPrePost(preorder, postorder));
    }

    public static int preIndex;
    public static TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        preIndex = 0;
        HashMap<Integer, Integer> postValToIndex = new HashMap<>();
        for (int i = 0; i < postorder.length; i++) {
            postValToIndex.put(postorder[i], i);
        }
        return buildRootNode(preorder, 0, preorder.length - 1, postValToIndex);
    }

    public static TreeNode buildRootNode(int[] preorder, int postBegin, int postEnd,
                                         HashMap<Integer, Integer> postValToIndex) {
        if (postBegin > postEnd) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[preIndex++]);
        if (postBegin == postEnd) {
            return root;
        } else {
            int rightMid = postValToIndex.get(preorder[preIndex]);
            root.left = buildRootNode(preorder, postBegin, rightMid, postValToIndex);
            root.right = buildRootNode(preorder, rightMid + 1, postEnd - 1, postValToIndex);
        }
        return root;
    }
}
