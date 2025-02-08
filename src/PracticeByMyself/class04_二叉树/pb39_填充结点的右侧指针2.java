package PracticeByMyself.class04_二叉树;

/**
 * @author Martin
 * @date 2025/1/5 15:55
 * @description <a href="https://leetcode.cn/problems/populating-next-right-pointers-in-each-node-ii/">...</a>
 */

public class pb39_填充结点的右侧指针2 {

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
    }

    public static void main(String[] args) {

    }

    public static Node connect(Node root) {
        //
        return null;
    }
}
