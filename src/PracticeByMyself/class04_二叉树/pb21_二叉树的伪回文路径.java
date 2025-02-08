package PracticeByMyself.class04_二叉树;

import common.entity.TreeNode;
import common.utils.TreeUtils;

/**
 * @author Martin
 * @date 2025/1/2 9:38
 * @description <a href="https://leetcode.cn/problems/pseudo-palindromic-paths-in-a-binary-tree/">...</a>
 */

public class pb21_二叉树的伪回文路径 {

    public static void main(String[] args) {
        TreeNode root = TreeUtils.deserializeTree("2,3,1,3,1,null,1");
//        int[] nums = {0,2,2,0};
//        System.out.println(isExistsPal(nums));
        System.out.println(pseudoPalindromicPaths(root)); // 2
    }

    static int count;
    public static int pseudoPalindromicPaths (TreeNode root) {
        count = 0;
        traverse(root, 0);
        return count;
    }

    static void traverse(TreeNode root, int num) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            num = (1 << root.val) ^ num;
            // num & (num - 1)会清除最右边的1
            if ((num & (num - 1)) == 0) {
                count++;
            }
        }
        traverse(root.left, (1 << root.val) ^ num);
        traverse(root.right, (1 << root.val) ^ num);
    }

    // 给你一堆数，如何判断它们的所有排列组合中存在回文序列？
    // 只要奇数出现的次数小于等于1就行
    static boolean isExistsPal(int[] nums) {
        int oddCount = 0;
        for (int num : nums) {
            if (num % 2 != 0) {
                oddCount++;
                if (oddCount > 1) {
                    return false;
                }
            }
        }
        return true;
    }
}
