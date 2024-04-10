package MartinByZuo.二叉树;

public class Code04_DepthOfBinaryTree {
    public static class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;
    }

    public int maxDepth(TreeNode root) {
        return root == null ? 0 : (Math.max(maxDepth(root.left), maxDepth(root.right)) + 1);
    }

    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left != null && root.right != null) {
            return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
        }
        else if (root.left == null && root.right != null){
            return minDepth(root.right) + 1;
        }
        else if (root.left != null){
            return minDepth(root.left) + 1;
        } else {
            // 叶子结点返回1
            return 1;
        }
    }

    public static int minDepth_2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right != null) {
            return 1 + minDepth_2(root.right);
        } else if (root.left != null && root.right == null) {
            return 1 + minDepth_2(root.left);
        }
        return 1 + Math.min(minDepth_2(root.left), minDepth_2(root.right));
    }
}
