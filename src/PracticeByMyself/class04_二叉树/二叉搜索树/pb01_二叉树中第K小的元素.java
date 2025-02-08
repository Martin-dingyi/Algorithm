package PracticeByMyself.class04_二叉树.二叉搜索树;

import common.entity.TreeNode;
import common.utils.TreeUtils;

/**
 * @author Martin
 * @date 2024/12/29 9:57
 * @description <a href="https://leetcode.cn/problems/kth-smallest-element-in-a-bst/">...</a>
 */

public class pb01_二叉树中第K小的元素 {

    public static void main(String[] args) {
        TreeNode root = TreeUtils.deserializeTree("3,1,4,null,2");
        System.out.println(kthSmallest(root, 1)); // 1
    }

    public static int res, kCount;

    public static int kthSmallest(TreeNode root, int k) {
        res = root.val;
        kCount = k;
        traverse(root);
        return res;
    }

    public static void traverse(TreeNode root) {
        if (root == null || kCount == 0) {
            return;
        }

        traverse(root.left);
        if (--kCount == 0) {
            res = root.val;
        }
        traverse(root.right);
    }
}
