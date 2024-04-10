package PracticeByZuo.BinaryTree;

public class Code10_LowestCommonAncestor {
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

    // 递归函数作用：查看root左右两边是否存在p或q，根据查找结果返回相应值
    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (p == q) {
            return p;
        }
        // 递归停止条件:
		// 当root为null时，返回null，或当root等于p或者q时，返回root
        if (root == null) {
            return null;
        }
        if (root == p || root == q) {
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        // 根据left和right是否为空，判断共同祖先可能或一定在哪
        if (left != null && right != null) {
            return root;
        }
        return left == null ? right : left;
    }
}
