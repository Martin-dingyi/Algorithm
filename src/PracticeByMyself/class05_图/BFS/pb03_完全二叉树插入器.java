package PracticeByMyself.class05_图.BFS;

import common.entity.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Martin
 * @date 2025/2/8 14:33
 * @description <a href="https://leetcode.cn/problems/complete-binary-tree-inserter/">...</a>
 */

public class pb03_完全二叉树插入器 {

    public static void main(String[] args) {

    }

    TreeNode root;
    public void CBTInserter(TreeNode root) {
        this.root = root;
    }

    public int insert(int val) {
        if (root == null) {
            root = new TreeNode(val);
            return 0;
        }
        // 层序遍历，遇到第一个null插入
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode curNode = queue.poll();
                if (curNode.left != null) {
                    queue.offer(curNode.left);
                } else {
                    curNode.left = new TreeNode(val);
                    return curNode.val;
                }

                if (curNode.right != null) {
                    queue.offer(curNode.right);
                } else {
                    curNode.right = new TreeNode(val);
                    return curNode.val;
                }
            }
        }

        return 0;
    }

    public TreeNode get_root() {
        return root;
    }
}
