package PracticeByMyself.class04_二叉树;

import common.entity.TreeNode;

/**
 * @author Martin
 * @date 2025/1/10 11:03
 * @description <a href="https://leetcode.cn/problems/count-complete-tree-nodes/">...</a>
 * 思路1：直接遍历一遍
 * 思路2：思路2：判断root是不是满二叉树，如果则直接返回节点数，如果不是就递归计算左右子树的节点数
 * 这种思路的时间复杂度更低，因为完全二叉树中必然遇到满二叉树。
 */

public class pb47_完全二叉树的节点个数 {

    public static void main(String[] args) {

    }

    public static int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int hl = 0, hr = 0;
        TreeNode p = root;
        while (p != null) {
            p = p.left;
            hl++;
        }

        p = root;
        while (p != null) {
            p = p.right;
            hr++;
        }

        if (hl == hr) {
            return (int) (Math.pow(2, hl) - 1);
        }

        return 1 + countNodes(root.left) + countNodes(root.right);
    }
}
