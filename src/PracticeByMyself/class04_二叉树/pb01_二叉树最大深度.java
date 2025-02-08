package PracticeByMyself.class04_二叉树;

import common.entity.TreeNode;
import common.utils.TreeUtils;

import java.util.List;

/**
 * @author mdy
 * @date 2024-12-26 10:15
 * @description <a href="https://leetcode.cn/problems/maximum-depth-of-binary-tree/">...</a>
 * 思路1：使用递归。获得左右子树的最大深度，然后+1返回
 * 思路2：使用遍历。在先序位置让depth++，后续位置depth--，记录最大的depth
 */

public class pb01_二叉树最大深度 {

    public static void main(String[] args) {
        TreeNode root = TreeUtils.buildBinaryTreeByLevelOrder(List.of(1, 2, 3, 4, 5, 6, 7, 8));
        System.out.println(getMaxDepth(root));
        traverse(root, 0);
        System.out.println(res);
    }

    // 1.利用递归思路
    // 递归函数定义：给定二叉树根节点，求这颗二叉树的最大深度，计算方法是获得左右子树的最大深度，然后+1返回
    public static int getMaxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(getMaxDepth(root.left), getMaxDepth(root.right)) + 1;
    }

    // 2.利用遍历的思路
    public static int res;

    public int maxDepth(TreeNode root) {
        res = 0;
        traverse(root, 0);
        return res;
    }

    public static void traverse(TreeNode root, int depth) {
        if (root == null) {
            return;
        }
        depth++;
        if (root.left == null && root.right == null) {
            res = Math.max(res, depth);
        }
        traverse(root.left, depth);
        traverse(root.right, depth);
    }
}
