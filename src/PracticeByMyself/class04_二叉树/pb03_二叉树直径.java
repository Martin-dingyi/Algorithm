package PracticeByMyself.class04_二叉树;

import common.entity.TreeNode;
import common.utils.TreeUtils;

import java.util.List;

/**
 * @author mdy
 * @date 2024-12-12 9:15
 * @description <a href="https://leetcode.cn/problems/diameter-of-binary-tree/description/?utm_source=LCUS&utm_medium=ip_redirect&utm_campaign=transfer2china">...</a>
 * 思路1：通过观察发现，直径就是所有结点左右子树的深度之和中最大的那个
 */

public class pb03_二叉树直径 {
    public static void main(String[] args) {
        TreeNode root = TreeUtils.buildBinaryTreeByLevelOrder(List.of(1, 2, 3, 4, 5, 6, 7, 8));
        System.out.println(diameterOfBinaryTree(root));
    }

    public static int diameterOfBinaryTree(TreeNode root) {
        maxDiameter = 0;
        getMaxDepth(root);
        return maxDiameter;
    }

    public static int maxDiameter;
    // 递归函数定义：根据左右子树最大深度获得当前结点的直径，返回该结点的深度
    public static int getMaxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftMax = getMaxDepth(root.left);
        int rightMax = getMaxDepth(root.right);
        maxDiameter = Math.max(maxDiameter, leftMax + rightMax);
        return Math.max(leftMax, rightMax) + 1;
    }
}
