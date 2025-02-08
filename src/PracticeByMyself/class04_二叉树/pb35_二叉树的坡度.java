package PracticeByMyself.class04_二叉树;

import common.entity.TreeNode;

/**
 * @author Martin
 * @date 2025/1/5 15:23
 * @description <a href="https://leetcode.cn/problems/binary-tree-tilt/">...</a>
 */

public class pb35_二叉树的坡度 {

    public static void main(String[] args) {

    }


    public static int findTilt(TreeNode root) {
        return findTileAndSum(root)[1];
    }

    // 定义：获得左右子树的和和坡度之和
    // 长度为2的数组，第一个位置放结点子树和，第二个位置放该结点的坡度
    static int[] findTileAndSum(TreeNode root) {
        if (root == null) {
            return new int[]{0, 0};
        }

        int[] leftInfo = findTileAndSum(root.left);
        int[] rightInfo = findTileAndSum(root.right);

        return new int[]{leftInfo[0] + rightInfo[0] + root.val,
                leftInfo[1] + rightInfo[1] + Math.abs(leftInfo[0] - rightInfo[0])};
    }
}
