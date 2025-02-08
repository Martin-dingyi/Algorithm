package PracticeByMyself.class04_二叉树;

import common.entity.TreeNode;
import common.utils.TreeUtils;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author Martin
 * @date 2025/1/5 15:34
 * @description <a href="https://leetcode.cn/problems/binary-tree-level-order-traversal-ii/">...</a>
 */

public class pb37_二叉树层序遍历2 {

    public static void main(String[] args) {
        TreeNode treeNode = TreeUtils.deserializeTree("3,9,20,null,null,15,7");
        System.out.println(levelOrderBottom(treeNode));
    }

    public static List<List<Integer>> levelOrderBottom(TreeNode root) {
        if (root == null) {
            return new LinkedList<>();
        }

        Deque<List<Integer>> res = new LinkedList<>();
        Queue<TreeNode> queue = new LinkedList<>();

        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> list = new LinkedList<>();
            for (int i = 0; i < size; i++) {
                TreeNode curNode = queue.poll();
                list.add(curNode.val);
                if (curNode.left != null) {
                    queue.add(curNode.left);
                }
                if (curNode.right != null) {
                    queue.add(curNode.right);
                }
            }
            res.addFirst(list);
        }

        return new LinkedList<>(res);
    }
}
