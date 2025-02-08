package PracticeByMyself.class04_二叉树;

import common.entity.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Martin
 * @date 2025/1/6 11:53
 * @description <a href="https://leetcode.cn/problems/even-odd-tree/">...</a>
 */

public class pb46_奇偶树 {

    public static void main(String[] args) {

    }

    public static boolean isEvenOddTree(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean evenLevel = true;

        while (!queue.isEmpty()) {
            int size = queue.size();
            TreeNode preNode = null;
            for (int i = 0; i < size; i++) {
                TreeNode curNode = queue.poll();
                assert curNode != null;
                if (evenLevel) {
                    if (curNode.val % 2 != 1) {
                        return false;
                    }
                    if (preNode != null && curNode.val <= preNode.val) {
                        return false;
                    }
                } else {
                    if (curNode.val % 2 != 0) {
                        return false;
                    }
                    if (preNode != null && curNode.val >= preNode.val) {
                        return false;
                    }
                }
                preNode = curNode;

                if (curNode.left != null) {
                    queue.offer(curNode.left);
                }
                if (curNode.right != null) {
                    queue.offer(curNode.right);
                }
            }
            evenLevel = !evenLevel;
        }
        return true;
    }
}
