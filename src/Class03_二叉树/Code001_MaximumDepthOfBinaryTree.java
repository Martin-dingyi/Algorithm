package Class03_二叉树;

// 二叉树最大深度
// https://leetcode.cn/problems/maximum-depth-of-binary-tree/
public class Code001_MaximumDepthOfBinaryTree {
      public class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;
          TreeNode() {}
          TreeNode(int val) { this.val = val; }
          TreeNode(int val, TreeNode left, TreeNode right) {
              this.val = val;
              this.left = left;
              this.right = right;
          }
      }

    class Solution {
        public int maxDepth(TreeNode root) {
            ans = 0;
            depth = 0;
            traverse(root);
            return ans;
        }

        // 递归函数定义：给定二叉树根节点，求这颗二叉树的最大深度
        public static int getMaxDepth(TreeNode root) {
            if (root == null) {
                return 0;
            }
            return Math.max(getMaxDepth(root.left), getMaxDepth(root.right)) + 1;
        }

        // 利用遍历的思路
        public static int ans, depth;
        public static void traverse(TreeNode root) {
            if (root == null) {
                return;
            }
            depth++;
            if (root.left == null && root.right == null) {
                ans = Math.max(ans, depth);
            }
            traverse(root.left);
            traverse(root.right);
            depth--;
        }
    }
}
