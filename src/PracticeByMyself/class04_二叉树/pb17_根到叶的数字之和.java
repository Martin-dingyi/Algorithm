package PracticeByMyself.class04_二叉树;

import common.entity.TreeNode;
import common.utils.TreeUtils;

import java.util.LinkedList;

/**
 * @author Martin
 * @date 2025/1/1 11:07
 * @description <a href="https://leetcode.cn/problems/sum-root-to-leaf-numbers/">...</a>
 */

public class pb17_根到叶的数字之和 {

    public static void main(String[] args) {
        TreeNode root = TreeUtils.deserializeTree("4,9,0,5,1");
        System.out.println(sumNumbers(root)); // 1026
    }

    static int sum;
    public static int sumNumbers(TreeNode root) {
        sum = 0;
        traverse(root, 0);
        return sum;
    }

    // 基本类型不像list，在后序位置会天然的“删掉”自己，可以看看和上道题的差别。
    static void traverse(TreeNode root, int num) {
        if (root == null) {
            return;
        }

        if (root.left == null && root.right == null) {
            num += root.val;
            sum += num;
        } else {
            traverse(root.left, (num + root.val) * 10);
            traverse(root.right, (num + root.val) * 10);
        }
    }
}
