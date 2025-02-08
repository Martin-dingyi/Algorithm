package PracticeByMyself.class04_二叉树.二叉搜索树;

import common.entity.TreeNode;

/**
 * @author Martin
 * @date 2025/1/6 12:52
 * @description <a href="https://leetcode.cn/problems/second-minimum-node-in-a-binary-tree/description/">...</a>
 * 思路1：
 */

public class pb13_二叉树中第二小的节点 {

    public static void main(String[] args) {

    }

    public static int findSecondMinimumValue(TreeNode root) {
        if (root == null || root.left == null || root.right == null) {
            return -1;
        }

        int leftVal = root.left.val, rightVal = root.right.val, rootVal = root.val;
        if (leftVal == rootVal) {
            leftVal = findSecondMinimumValue(root.left);
        }
        if (rightVal == rootVal) {
            rightVal = findSecondMinimumValue(root.right);
        }

        if (leftVal == -1) {
            return rightVal;
        }
        if (rightVal == -1) {
            return leftVal;
        }
        return Math.min(leftVal, rightVal);
    }

}
