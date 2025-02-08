package PracticeByMyself.class04_二叉树;

import common.entity.TreeNode;

/**
 * @author Martin
 * @date 2025/1/4 10:52
 * @description <a href="https://leetcode.cn/problems/merge-two-binary-trees/">...</a>
 */

public class pb30_合并二叉树 {

    public static void main(String[] args) {

    }

    // 定义：合并两棵树
    public static TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) {
            return null;
        }

        if (root1 == null) {
            return root2;
        } else if (root2 == null) {
            return root1;
        }

        root1.val += root2.val;
        root1.left = mergeTrees(root1.left, root2.left);
        root1.right = mergeTrees(root1.right, root2.right);

        return root1;
    }


}
