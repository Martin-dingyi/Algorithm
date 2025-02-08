package PracticeByMyself.class04_二叉树;

import common.entity.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Martin
 * @date 2025/1/6 11:52
 * @description <a href="https://leetcode.cn/problems/deepest-leaves-sum/">...</a>
 * 其实就是如何判断层序遍历中哪个是最后一层，很简单，略
 * 遍历完一遍后queue为null，那这次遍历就是最后一层
 */

public class pb45_层数最深叶子节点的和 {

    public static void main(String[] args) {

    }

    public static int deepestLeavesSum(TreeNode root) {
        if (root == null) {
            return 0;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int lastLayerSum = -1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            int sum = 0;
            for (int i = 0; i < size; i++) {
                TreeNode curNode = queue.poll();
                sum += curNode.val;
                if (curNode.left != null) {
                    queue.offer(curNode.left);
                }
                if (curNode.right != null) {
                    queue.offer(curNode.right);
                }
            }
            if (queue.isEmpty()) {
                lastLayerSum = sum;
            }
        }

        return lastLayerSum;
    }
}
