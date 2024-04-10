package PracticeByZuo.LinkedList;

/*
 * 题目：复制带随机指针的链表
 * */
public class Code06_CopyListWithRandomPointer {
    static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    public static Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        Node ptr = head;
        Node copy, back;
        // 1.复制每一个结点，插在相应结点之后
        while (ptr != null) {
            copy = new Node(ptr.val);
            back = ptr.next;
            ptr.next = copy;
            copy.next = back;
            ptr = back;
        }
        // 2.遍历新链表，查找原结点的random指针指向的结点，然后让被复制结点指向这个结点
        ptr = head;
        Node random;
        while (ptr != null) {
            random = ptr.random;
            if (random != null) {
                ptr.next.random = random.next;
            } else {
                ptr.next.random = null;
            }
            ptr = ptr.next.next;
        }
        // 3.让新结点脱离原链表，连接在一起
        ptr = head;
        Node newHead = head.next;
        Node newPtr = newHead;
        while (ptr != null) {
            back = ptr.next.next;
            ptr.next = back;
            if (back != null) {
                newPtr.next = back.next;
            } else {
                newPtr.next = null;
            }
            newPtr = newPtr.next;
            ptr = ptr.next;
        }
        return newHead;
    }

    public static void print(Node head) {
        Node ptr = head;
        System.out.print("[");
        while (ptr != null) {
            System.out.print(ptr.val);
            ptr = ptr.next;
            if (ptr != null) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        Node ptr = head;
        for (int i = 0; i < 4; i++) {
            ptr.next = new Node(i + 2);
            ptr = ptr.next;
        }
        print(head);
        print(copyRandomList(head));

    }


}
