package PracticeByMyself.class04_二叉树;

import common.entity.TreeNode;
import common.utils.TreeUtils;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author Martin
 * @date 2025/1/5 15:49
 * @description <a href="https://leetcode.cn/problems/binary-tree-zigzag-level-order-traversal/">...</a>
 */

public class pb38_锯齿状层序遍历 {

    public static void main(String[] args) {
        TreeNode treeNode = TreeUtils.deserializeTree("3,9,20,null,null,15,7");
        System.out.println(zigzagLevelOrder(treeNode));
    }

    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null) {
            return new LinkedList<>();
        }

        Deque<List<Integer>> res = new LinkedList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        boolean switchDirection = false;
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            Deque<Integer> list = new LinkedList<>();
            for (int i = 0; i < size; i++) {
                TreeNode curNode = queue.poll();
                assert curNode != null;
                if (switchDirection) {
                    list.addFirst(curNode.val);
                } else {
                    list.addLast(curNode.val);
                }

                if (curNode.left != null) {
                    queue.add(curNode.left);
                }
                if (curNode.right != null) {
                    queue.add(curNode.right);
                }
            }
            res.addLast(new LinkedList<>(list));
            switchDirection = !switchDirection;
        }

        return new LinkedList<>(res);
    }
}
