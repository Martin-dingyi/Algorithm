package PracticeByMyself.class04_二叉树;

import common.entity.TreeNode;
import common.utils.TreeUtils;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Martin
 * @date 2025/1/6 10:55
 * @description <a href="https://leetcode.cn/problems/check-completeness-of-a-binary-tree/description/">...</a>
 * 思路：这题很难用分解问题的思路，因为子问题之间相互干扰，左子树是否为完全二叉树取决于右子树上是否有子结点
 * 层序遍历方法：只要队列中的null元素不是最后一个元素，那root就不是完全二叉树
 */

public class pb43_二叉树的完全性检验 {

    public static void main(String[] args) {
        TreeNode root = TreeUtils.deserializeTree("1,2,3,5,6");
        System.out.println(isCompleteTree(root));
    }

    public static boolean isCompleteTree(TreeNode root) {
        if (root == null) return true;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean nullFirstShowUp = false;

        while (!queue.isEmpty()) {
            int size = queue.size();

            // 在null第一次出现的那一刻开始，后面就不允许再出现非null结点
            for (int i = 0; i < size; i++) {
                TreeNode curNode = queue.poll();
                if (curNode != null) {
                    if (nullFirstShowUp) {
                        return false;
                    }
                    queue.offer(curNode.left);
                    queue.offer(curNode.right);
                } else {
                    nullFirstShowUp = true;
                }

            }
        }
        return true;
    }

}
