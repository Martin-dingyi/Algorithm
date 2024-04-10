package PracticeByDong;

// 填充每个节点的下一个右侧节点指针
// https://leetcode.cn/problems/populating-next-right-pointers-in-each-node/

import java.util.LinkedList;

class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
}

public class Code005_opulatingNextRightPointersInEachNode {

    public static Node connect(Node root) {
        if (root == null) {
            return null;
        }
        LinkedList<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node cur = queue.poll();
                if (cur.left != null) {
                    queue.add(cur.left);
                    queue.add(cur.right);
                }
                if (i != size - 1) {
                    cur.next = queue.peek();
                } else {
                    cur.next = null;
                }
            }
        }
        return root;
    }

    public static void traverse(Node root, Node nextNode) {
        if (root == null) {
            return;
        }
        root.next = nextNode;
        traverse(root.left, root.right);
        traverse(root.right, nextNode == null ? null : nextNode.left);
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        connect(root);
        System.out.println();
    }
}
