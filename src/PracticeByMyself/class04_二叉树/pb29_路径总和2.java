package PracticeByMyself.class04_二叉树;

import common.entity.TreeNode;
import common.utils.TreeUtils;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Martin
 * @date 2025/1/4 10:29
 * @description <a href="https://leetcode.cn/problems/path-sum-ii/">...</a>
 */

public class pb29_路径总和2 {

    public static void main(String[] args) {
        TreeNode root = TreeUtils.deserializeTree("5,4,8,11,null,13,4,7,2,null,null,5,1");
        System.out.println(pathSum(root, 22));
    }

    static List<List<Integer>> res;
    public static List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        res = new LinkedList<>();
        traverse(root, targetSum, new LinkedList<>());
        return res;
    }

    static void traverse(TreeNode root, int targetSum, LinkedList<Integer> path) {
        if (root == null) {
            return;
        }
        targetSum -= root.val;
        path.addLast(root.val);
        if (root.left == null && root.right == null) {
            if (targetSum == 0) {
                res.add(new LinkedList<>(path));
            }
        }

        traverse(root.left, targetSum, path);
        traverse(root.right, targetSum, path);
        path.removeLast();
    }

    // 定义：获取所有左右子树满足条件的路径
    static List<List<Integer>> pathSum_dg(TreeNode root, int targetSum) {
        List<List<Integer>> res = new LinkedList<>();
        if (root == null) {
            return res;
        }

        if (root.left == null && root.right == null) {
            if (targetSum == root.val) {
                List<Integer> list = new LinkedList<>();
                list.add(root.val);
                res.add(list);
            }
            return res;
        }

        List<List<Integer>> leftValidPath = pathSum_dg(root.left, targetSum - root.val);
        List<List<Integer>> rightValidPath = pathSum_dg(root.right, targetSum - root.val);


        for (List<Integer> list : leftValidPath) {
            list.add(0, root.val);
            res.add(list);
        }
        for (List<Integer> list : rightValidPath) {
            list.add(0, root.val);
            res.add(list);
        }

        return res;
    }

}
