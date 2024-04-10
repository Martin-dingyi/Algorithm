package Class03_二叉树;

// 最大二叉树
// https://leetcode.cn/problems/maximum-binary-tree/description/
public class Code009_MaximumBinaryTree {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static TreeNode constructMaximumBinaryTree(int[] nums) {
        return buildLocTree(nums, 0, nums.length - 1);
    }

    public static TreeNode buildLocTree(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }
        int maxIndex = getMaxIndex(nums, left, right);
        TreeNode root = new TreeNode(nums[maxIndex]);
        root.left = buildLocTree(nums, left, maxIndex - 1);
        root.right = buildLocTree(nums, maxIndex + 1, right);
        return root;
    }

    public static int getMaxIndex(int[] nums, int left, int right) {
        int maxIndex = left++;
        int max = nums[maxIndex];
        while (left <= right) {
            if (nums[left] > max) {
                max = nums[left];
                maxIndex = left;
            }
            left++;
        }
        return maxIndex;
    }
}
