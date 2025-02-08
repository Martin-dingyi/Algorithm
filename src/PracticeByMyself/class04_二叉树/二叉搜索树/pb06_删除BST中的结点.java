package PracticeByMyself.class04_二叉树.二叉搜索树;

import common.entity.TreeNode;

/**
 * @author Martin
 * @date 2024/12/30 10:11
 * @description <a href="https://leetcode.cn/problems/delete-node-in-a-bst/description/">...</a>
 * 思路1：找到要删除的结点，用左子树替换它，然后将右子树的插入到左子树当中。我承认我有赌的成分，但是我赌对了。
 * 思路2：找到要删除的结点，用左子树中的最大值或右子树中的最小值替换它。规律：右子树中最靠左的结点val值最小。
 */

public class pb06_删除BST中的结点 {

    public static void main(String[] args) {

    }

    public static TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        }

        if (root.val == key) {
            if (root.left != null) {
                TreeNode temp = root.right;
                root = root.left;
                insertIntoBST(root, temp);
            } else {
                root = root.right;
            }
            return root;
        } else if (root.val > key) {
            root.left = deleteNode(root.left, key);
        } else {
            root.right = deleteNode(root.right, key);
        }

        return root;
    }

    public static TreeNode insertIntoBST(TreeNode root, TreeNode target) {
        if (target == null || root == null) {
            return target;
        }

        if (target.val < root.val) {
            if (root.left == null) {
                root.left = target;
            } else {
                root.left = insertIntoBST(root.left, target);
            }
        } else {
            if (root.right == null) {
                root.right = target;
            } else {
                root.right = insertIntoBST(root.right, target);
            }
        }
        return root;
    }
}
