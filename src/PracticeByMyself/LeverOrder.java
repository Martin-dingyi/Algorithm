package PracticeByMyself;

import Utils.TreeUtils;
import entity.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * @author mdy
 * @date 2024-11-17 21:17
 * @description
 */

public class LeverOrder {

    public static void main(String[] args) {
        List<Integer> list = List.of(1, 2, 3, 4, 5, 6, 7);
        TreeNode head = TreeUtils.buildBinaryTreeByLevelOrder(list);
        System.out.println(levelOrder(head));
//        TreeUtils.printBinaryTree(head);
//        TreeUtils.printBinaryTree(TreeUtils.buildBinaryTreeInRandom(100, 50));
    }


    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();

        if (root == null) {
            return result;
        }

        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> oneLevelNodeList = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode curNode = queue.poll();
                assert curNode != null;
                oneLevelNodeList.add(curNode.val);

                if (curNode.left != null) {
                    queue.offer(curNode.left);
                }
                if (curNode.right != null) {
                    queue.offer(curNode.right);
                }
            }
            result.add(oneLevelNodeList);
        }

        return result;
    }

}
