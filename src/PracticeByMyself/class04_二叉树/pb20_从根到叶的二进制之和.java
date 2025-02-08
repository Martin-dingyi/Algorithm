package PracticeByMyself.class04_二叉树;

import common.entity.TreeNode;
import common.utils.TreeUtils;

/**
 * @author Martin
 * @date 2025/1/2 9:22
 * @description <a href="https://leetcode.cn/problems/sum-of-root-to-leaf-binary-numbers/">...</a>
 */

public class pb20_从根到叶的二进制之和 {
    public static void main(String[] args) {
        TreeNode root = TreeUtils.deserializeTree("[1,0,1,0,1,0,1]");
        System.out.println(sumRootToLeaf(root)); // 22
    }

    static int sum;
    public static int sumRootToLeaf(TreeNode root) {
        sum = 0;
        traverse(root, 0);
        return sum;
    }

    static void traverse(TreeNode root, int num) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            num = num << 1 | root.val;
            sum += num;
        }
        traverse(root.left, num << 1 | root.val);
        traverse(root.right, num << 1 | root.val);
    }


}
