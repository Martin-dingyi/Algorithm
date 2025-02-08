package PracticeByMyself.class04_二叉树;

import common.entity.TreeNode;
import common.utils.TreeUtils;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Martin
 * @date 2025/1/5 16:00
 * @description <a href="https://leetcode.cn/problems/maximum-width-of-binary-tree/description/">...</a>
 */

public class pb40_二叉树最大宽度 {

    public static void main(String[] args) {
        TreeNode root1 = TreeUtils.deserializeTree("1,1,1,1,1,1,1,null,null,null,1,null,null,null,null,2,2,2,2,2,2,2,null,2,null,null,2,null,2");
        TreeNode root2 = TreeUtils.deserializeTree("1,3,2,5,null,null,9,6,null,7");
        System.out.println(widthOfBinaryTree(root1)); // 8
        System.out.println(widthOfBinaryTree(root2)); // 7
    }

    // 题干说的结点个数
    static final int maxSize = 3001;
    static TreeNode[] queue = new TreeNode[maxSize];
    // 下标是真实二叉树层次遍历下结点的序号，值是它们在逻辑完全二叉树中的序号
    static int[] nodeNum = new int[maxSize];
    static int left, right;
    public static int widthOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }

        left = 0;
        right = 0;
        queue[left] = root;
        nodeNum[right++] = 1;
        int maxWidth = 0;

        while (left < right) {
            int size = right - left;
            maxWidth = Math.max(maxWidth, nodeNum[right - 1] - nodeNum[left] + 1);
            for (int i = 0; i < size; i++) {
                TreeNode curNode = queue[left];
                assert curNode != null;
                if (curNode.left != null) {
                    queue[right] = curNode.left;
                    nodeNum[right++] = nodeNum[left] * 2;
                }
                if (curNode.right != null) {
                    queue[right] = curNode.right;
                    nodeNum[right++] = nodeNum[left] * 2 + 1;
                }
                left++;
            }
        }
        return maxWidth;
    }

}
