package PracticeByMyself.class04_二叉树;

import common.entity.TreeNode;
import common.utils.TreeUtils;

import java.util.*;

/**
 * @author Martin
 * @date 2024/12/27 9:35
 * @description <a href="https://leetcode.cn/problems/populating-next-right-pointers-in-each-node/description/">...</a>
 * 思路1：使用层序遍历实现
 * 思路2：将二叉树抽象成三叉树进行遍历
 */

public class pb08_填充每个节点的下一个右侧节点指针 {

    static class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    };


    public static void main(String[] args) {

    }

    public static Node connect(Node root) {
        if (root == null) {
            return null;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node curNode = queue.poll();
                assert curNode != null;
                if (i != size - 1) {
                    curNode.next = queue.peek();
                }

                if (curNode.left != null) {
                    queue.add(curNode.left);
                }
                if (curNode.right != null) {
                    queue.add(curNode.right);
                }
            }
        }

        return root;
    }

    public static void traverse(Node node1, Node node2) {
        if (node1 == null && node2 == null) {
            return;
        }
        node1.next = node2;
        traverse(node1.left, node1.right);
        traverse(node1.right, node2.left);
        traverse(node2.left, node2.right);
    }
}
