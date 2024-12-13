package Utils;

import entity.TreeNode;

import java.util.*;

/**
 * @author mdy
 * @date 2024-11-17 21:18
 * @description
 */


public class TreeUtils {

    public static TreeNode buildBinaryTreeByLevelOrder(List<Integer> nodeList) {
        if (nodeList.isEmpty()) {
            return null;
        }

        Queue<TreeNode> queue = new ArrayDeque<>();
        LinkedList<Integer> nodeLinkedList = new LinkedList<>(nodeList);
        assert !nodeLinkedList.isEmpty();
        TreeNode head = new TreeNode(nodeLinkedList.pollFirst());
        queue.offer(head);

        while (!queue.isEmpty() && !nodeLinkedList.isEmpty()) {
            TreeNode node = queue.poll();

            if (!nodeLinkedList.isEmpty()) {
                TreeNode leftNode = new TreeNode(nodeLinkedList.pollFirst());
                node.left = leftNode;
                queue.offer(leftNode);
            }
            if (!nodeLinkedList.isEmpty()) {
                TreeNode rightNode = new TreeNode(nodeLinkedList.pollFirst());
                node.right = rightNode;
                queue.offer(rightNode);
            }
        }
        return head;
    }

    public static TreeNode buildBinaryTreeInRandom(int maxSize, int maxNum) {
        int size = (int) (Math.random() * ++maxSize);
        ArrayList<Integer> list = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            list.add((int) (Math.random() * ++maxNum));
        }
        return buildBinaryTreeByLevelOrder(list);
    }

    public static void printBinaryTree(TreeNode head) {
        if (head == null) {
            return;
        }

        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(head);

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode curNode = queue.poll();
                assert curNode != null;
                System.out.print(curNode.val + " ");
                if (curNode.left != null) {
                    queue.offer(curNode.left);
                }
                if (curNode.right != null) {
                    queue.offer(curNode.right);
                }
            }
            System.out.println();
        }
    }
}
