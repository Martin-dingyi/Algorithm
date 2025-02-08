package PracticeByMyself.class04_二叉树;

import common.entity.TreeNode;
import common.utils.TreeUtils;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Martin
 * @date 2025/1/6 11:40
 * @description <a href="https://leetcode.cn/problems/maximum-level-sum-of-a-binary-tree/description/">...</a>
 */

public class pb44_最大层内元素和 {

    public static void main(String[] args) {
        TreeNode root1 = TreeUtils.deserializeTree("-100,-200,-300,-20,-5,-10,null");
        System.out.println(maxLevelSum(root1)); // 3
    }

    public static int maxLevelSum(TreeNode root) {

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int maxSum = root.val;
        int maxSumDepth = 1;
        int depth = 1;

        while (!queue.isEmpty()) {
            int size = queue.size();
            int sum = 0;
            depth++;
            for (int i = 0; i < size; i++) {
                TreeNode curNode = queue.poll();
                if (curNode.left != null) {
                    queue.offer(curNode.left);
                    sum += curNode.left.val;
                }
                if (curNode.right != null) {
                    queue.offer(curNode.right);
                    sum += curNode.right.val;
                }
            }
            if (sum > maxSum && !queue.isEmpty()) {
                maxSum = sum;
                maxSumDepth = depth;
            }
        }

        return maxSumDepth;
    }
}
