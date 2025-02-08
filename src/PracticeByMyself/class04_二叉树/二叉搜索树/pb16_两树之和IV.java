package PracticeByMyself.class04_二叉树.二叉搜索树;

import common.entity.TreeNode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Martin
 * @date 2025/1/8 14:27
 * @description
 */

public class pb16_两树之和IV {

    public static void main(String[] args) {

    }

    public static boolean findTarget(TreeNode root, int k) {
        return traverse(root, k, new HashSet<>());
    }

    static boolean traverse(TreeNode root, int k, Set<Integer> numSet) {
        if (root == null) {
            return false;
        }
        if (numSet.contains(k - root.val)) {
            return true;
        }
        numSet.add(root.val);
        return traverse(root.left, k, numSet) || traverse(root.right, k, numSet);
    }
}
