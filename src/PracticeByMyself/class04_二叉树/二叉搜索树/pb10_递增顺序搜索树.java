package PracticeByMyself.class04_二叉树.二叉搜索树;

import common.entity.TreeNode;

/**
 * @author Martin
 * @date 2025/1/4 11:00
 * @description <a href="https://leetcode.cn/problems/increasing-order-search-tree/">...</a>
 */

public class pb10_递增顺序搜索树 {

    public static void main(String[] args) {

    }

    // 定义：拉伸左右两边，获取拉伸后的左右子树的头结点和尾结点
    public static TreeNode increasingBST(TreeNode root) {
        return increasingBST_dg(root)[0];
    }

    public static TreeNode[] increasingBST_dg(TreeNode root) {
        if (root == null) {
            return new TreeNode[]{null, null};
        }

        TreeNode[] leftInfo = increasingBST_dg(root.left);
        TreeNode[] rightInfo = increasingBST_dg(root.right);
        root.left = null;

        if (leftInfo[1] == null) {
            leftInfo[0] = root;
        } else {
            leftInfo[1].right = root;
        }

        if (rightInfo[0] == null) {
            rightInfo[1] = root;
        } else {
            root.right = rightInfo[0];
        }

        return new TreeNode[]{leftInfo[0], rightInfo[1]};
    }
}
