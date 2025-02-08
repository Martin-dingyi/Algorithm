package common.utils;

import common.entity.TreeNode;

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

    // Decodes your encoded data to tree.
    public static TreeNode deserializeTree(String data) {
        if (data == null || data.isBlank()) {
            return null;
        }

        if (data.charAt(0) == '[') {
            data = data.substring(1);
        }
        if (data.charAt(data.length() - 1) == ']') {
            data = data.substring(0, data.length() - 1);
        }

        String[] vals = data.split(",");

        String firstVal = vals[0];
        if (firstVal.equals("null")) {
            return null;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode root = new TreeNode(Integer.parseInt(firstVal));
        queue.add(root);
        int index = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode curNode = queue.poll();
                assert curNode != null;
                if (index >= vals.length || vals[index].equals("null")) {
                    curNode.left = null;
                } else {
                    TreeNode temp = new TreeNode(Integer.parseInt(vals[index]));
                    curNode.left = temp;
                    queue.add(temp);
                }
                index++;
                if (index >= vals.length || vals[index].equals("null")) {
                    curNode.right = null;
                } else {
                    TreeNode temp = new TreeNode(Integer.parseInt(vals[index]));
                    curNode.right = temp;
                    queue.add(temp);
                }
                index++;
            }
        }

        return root;
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
                }
            }
            System.out.println();
        }
    }
}
