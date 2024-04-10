package PracticeByZuo.BinaryTree;

// 题目：验证搜索二叉树
// 搜索二叉树的特性：根节点左子树上所有结点都比它小，右子树上所有结点都比它大。
public class Code14_ValidateBinarySearchTree {
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

    // 两种方案:
    // 第一种是利用中序遍历搜索二叉树，结果一定递增序列
    // 第二种是用递归的方法。这里使用递归方案
    // 递归函数作用：获得root子树中的最大值和最小值，左右子树各获取一次，然后用取得的值与root进行比较。
    // 返回root为根结点的树的最大值和最小值，以及自己是否为搜索二叉树
    public static long min, max;
    public static boolean isValidBST(TreeNode root) {
        // 如果结点不存在，那么它的父结点一定满足条件
        if (root == null) {
            min = Long.MAX_VALUE;
            max = Long.MIN_VALUE;
            return true;
        }

        // 获得左子树上的最大值和最小值，然后判断左边是否满足条件
        boolean leftIsBst = isValidBST(root.left);
        long lMin = min;
        long lMax = max;
        // 获得右子树上的最大值和最小值，然后判断右边是否满足条件
        boolean rightIsBst = isValidBST(root.right);
        long rMin = min;
        long rMax = max;

        // 得到该root对应的最大值和最小值
        min = Math.min(Math.min(lMin, rMin), root.val);
        max = Math.max(Math.max(lMax, rMax), root.val);

        return leftIsBst && rightIsBst && root.val > lMax && root.val < rMin;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(120);
        root.right = new TreeNode(140);
        root.right.left = new TreeNode(130);
        root.right.right = new TreeNode(160);
        root.right.left.left = new TreeNode(119);
        root.right.left.right = new TreeNode(135);
        root.right.right.left = new TreeNode(150);
        root.right.right.right = new TreeNode(200);
        System.out.println(isValidBST(root));
    }
}
