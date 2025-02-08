package PracticeByMyself.class04_二叉树.二叉搜索树;

import common.entity.TreeNode;
import common.utils.TreeUtils;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author Martin
 * @date 2024/12/29 10:44
 * @description <a href="https://leetcode.cn/problems/validate-binary-search-tree/description/">...</a>
 */

public class pb03_验证二叉搜索树 {

    public static void main(String[] args) {
        String s1 = "5,4,6,null,null,3,7";
        String s2 = "5,1,4,null,null,3,6";
        TreeNode root = TreeUtils.deserializeTree(s2);
        System.out.println(isValidBST(root)); // false
    }

    public static boolean isValidBST(TreeNode root) {
        return _isValidBST(root, null, null);
    }

    // 递归函数定义：验证该root结点是否有效，每个节点都必须在min和max的范围内
    // 具体每个节点的min和max范围，要根据它的父节点的val和它的区间而定
    // 如果min和max为null，表示无限小或无限大
    public static boolean _isValidBST(TreeNode root, Integer min, Integer max) {
        if (root == null) {
            return true;
        }
        if (min != null && root.val <= min) {
            return false;
        }
        if (max != null && root.val >= max) {
            return false;
        }

        return _isValidBST(root.left, min, root.val) &&
                _isValidBST(root.right, root.val, max);
    }


    public static LinkedList<Integer> valList;
    public static boolean valid;

    public static void traverse(TreeNode root) {
        if (root == null) {
            return;
        }

        traverse(root.left);
        if (!valList.isEmpty() && valList.peek() >= root.val) {
            valid = false;
            return;
        }
        valList.addFirst(root.val);
        traverse(root.right);
    }
}
