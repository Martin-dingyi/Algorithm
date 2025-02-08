package PracticeByMyself.class04_二叉树;

import common.utils.TreeUtils;
import common.entity.TreeNode;

import java.util.List;

//

class pb06_是否对称 {

    public static void main(String[] args) {
//        TreeNode root = TreeUtils.buildBinaryTreeInRandom(10, 10);
        TreeNode root = TreeUtils.buildBinaryTreeByLevelOrder(List.of(1, 2, 2, 3, 4, 4, 3));
        System.out.println(isSymmetric(root));
    }

    public static boolean isSymmetric(TreeNode root) {

        return f(root.left, root.right);
    }

    public static boolean f(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) {
            return true;
        } else if (root1 == null || root2 == null || root1.val != root2.val) {
            return false;
        }
        return f(root1.left, root2.right) && f(root1.right, root2.left);
    }

}