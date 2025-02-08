package PracticeByMyself.class04_二叉树;

import common.entity.TreeNode;
import common.utils.TreeUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Martin
 * @date 2024/12/27 10:01
 * @description <a href="https://leetcode.cn/problems/flatten-binary-tree-to-linked-list/">...</a>
 * 思路1：使用中序遍历来解决
 * 思路2：用递归
 */

public class pb09_二叉树展开为链表 {

    public static void main(String[] args) {

//        flattenAndGetEnd(root);
//        TreeUtils.printBinaryTree(root);
    }

    public static void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        flatten(root.left);

        TreeNode temp = root.right;
        root.right = root.left;
        flatten(root.right);
    }

    // 递归函数定义：拉伸左右子树，并获取左右子树的尾结点，然后将左子树嫁接到右子树上
    public static TreeNode flattenAndGetEnd(TreeNode root) {
        if (root == null) {
            return null;
        }

        TreeNode leftEnd = flattenAndGetEnd(root.left);
        TreeNode rightEnd = flattenAndGetEnd(root.right);

        if (leftEnd != null) {
            TreeNode temp = root.right;
            root.right = root.left;
            leftEnd.right = temp;
        }
        root.left = null;

        if (root.right == null) {
            return root;
        }
        return rightEnd != null ? rightEnd : leftEnd;
    }
}
