package ByMartinPratice.二叉树;

// 题目：在搜索二叉树上找到两结点的共同祖先。搜索二叉树中结点的值不重复
public class Code11_LowestCommonAncestorBinarySearch {
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

    // 函数作用：判断root左右两边是否不为空，根据结果判断p和q的共同祖先可能或一定在哪
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // 如果p和q在root的两边，则返回root
        // 如果p和q在root的同一边，则取root的左或右子树上寻找
        while ((p.val < root.val && q.val < root.val) || (p.val > root.val && q.val > root.val)) {
            if (root.left == null || root.right == null) {
                return root;
            }
            root = p.val > root.val ? root.right : root.left;
        }
        return root;
    }
}
