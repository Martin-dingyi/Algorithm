package Class03_二叉树;

// 计算二叉树直径
// https://leetcode.cn/problems/diameter-of-binary-tree/description/?utm_source=LCUS&utm_medium=ip_redirect&utm_campaign=transfer2china
public class Code003_DiameterOfBinaryTree {
    public class TreeNode {
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

    public int diameterOfBinaryTree(TreeNode root) {
        maxDiameter = 0;
        getMaxDepth(root);
        return maxDiameter;
    }

    public static int maxDiameter;

    // 递归函数定义：根据二叉树左右子树最大深度计算直径
    public static int getMaxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftMax = getMaxDepth(root.left);
        int rightMax = getMaxDepth(root.right);
        maxDiameter = Math.max(leftMax + rightMax, maxDiameter);
        return Math.max(leftMax, rightMax) + 1;
    }
}
