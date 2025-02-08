package PracticeByMyself.class04_二叉树;

import common.entity.TreeNode;
import common.utils.TreeUtils;

/**
 * @author Martin
 * @date 2024/12/27 10:56
 * @description <a href="https://leetcode.cn/problems/maximum-binary-tree/">...</a>
 * 思路1：递归
 */

public class pb10_最大二叉树 {
    public static void main(String[] args) {
        int[] nums1 = {3,2,1,6,0,5};
        TreeUtils.printBinaryTree(constructMaximumBinaryTree(nums1));
    }

    public static TreeNode constructMaximumBinaryTree(int[] nums) {
        return buildTreeByMaxNum(nums, 0, nums.length - 1);
    }

    public static TreeNode buildTreeByMaxNum(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }

        int max = nums[left];
        int index = left, indexForMax = left;
        while (index <= right) {
            if (nums[index] > max) {
                indexForMax = index;
                max = nums[index];
            }
            index++;
        }
        TreeNode root = new TreeNode(max);
        root.left = buildTreeByMaxNum(nums, left, indexForMax - 1);
        root.right = buildTreeByMaxNum(nums, indexForMax + 1, right);

        return root;
    }
}
