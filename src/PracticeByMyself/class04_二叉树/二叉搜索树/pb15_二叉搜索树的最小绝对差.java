package PracticeByMyself.class04_二叉树.二叉搜索树;

import common.entity.TreeNode;
import common.utils.TreeUtils;

/**
 * @author Martin
 * @date 2025/1/8 14:20
 * @description <a href="https://leetcode.cn/problems/minimum-absolute-difference-in-bst/description/">...</a>
 * 思路1：最小差值必然是相邻两个数的差值
 */

public class pb15_二叉搜索树的最小绝对差 {

    public static void main(String[] args) {
        TreeNode root = TreeUtils.deserializeTree("0,null,100000");
        System.out.println(getMinimumDifference(root));
    }

    static int minDiff;
    static TreeNode preNode;
    public static int getMinimumDifference(TreeNode root) {
        minDiff = Integer.MAX_VALUE;
        traverse(root);
        return minDiff;
    }

    static void traverse(TreeNode root) {
        if (root == null) {
            return;
        }

        traverse(root.left);

        if (preNode != null) {
            minDiff = Math.min(minDiff, Math.abs(root.val - preNode.val));
        }
        preNode = root;

        traverse(root.right);
    }

}
