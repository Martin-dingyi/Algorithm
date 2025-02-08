package PracticeByMyself.class04_二叉树.公共祖先;

import common.entity.TreeNode;

/**
 * @author Martin
 * @date 2025/1/10 10:32
 * @description <a href="https://leetcode.cn/problems/lowest-common-ancestor-of-a-binary-search-tree/description/">...</a>
 */

public class pb05_BST的LCA {

    public static void main(String[] args) {

    }

    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }

        // 由于是BST，所以可以保证p和q绝对在root下面
        if (root == p || root == q ||
                (p.val < root.val && q.val > root.val || p.val > root.val && q.val < root.val)) {
            return root;
        }

        // 去左右子树寻找
        if (p.val < root.val && q.val < root.val) {
            return lowestCommonAncestor(root.left, p, q);
        } else {
            return lowestCommonAncestor(root.right, p, q);
        }
    }
}

