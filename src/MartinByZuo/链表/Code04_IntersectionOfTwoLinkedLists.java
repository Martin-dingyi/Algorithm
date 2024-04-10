package MartinByZuo.链表;

/*
 * 题目：找到两链表的交点
 * */
public class Code04_IntersectionOfTwoLinkedLists {
    public static class Node {
        int value;
        Node next;

        public Node(int value) {
            this.value = value;
        }

        public Node() {

        }
    }

    // 链表
    public static class LinkedList {
        Node head;

        public LinkedList() {
            head = new Node();
        }

        // 头插法插入结点
        public void insertByHead(Node node) {
            Node ptr = null;
            // 确保链表中除了头结点还有一个结点
            if (head.next != null) {
                ptr = head.next;
            }
            head.next = node;
            node.next = ptr;
        }

        // 尾插法插入结点
        public void insertByEnd(Node node) {
            if (node == null) {
                return;
            }
            Node ptr = head;
            // 将ptr锁定到链表的最后一个结点上
            while (ptr.next != null) {
                ptr = ptr.next;
            }
            ptr.next = node;
            node.next = null;
        }

        public boolean isEmpty() {
            return head.next == null;
        }

        public Node peekFirst() {
            return head.next;
        }

        public Node delete(Node node) {
            if (node == null) {
                return null;
            }
            head.next = node.next;
            return node;
        }

        public void print() {
            Node ptr = head.next;
            System.out.print("[");
            while (ptr != null) {
                System.out.print(ptr.value);
                ptr = ptr.next;
                if (ptr != null) {
                    System.out.print(", ");
                }
            }
            System.out.println("]");
        }
    }

    // 得到两链表的交点
    public static Node getIntersection(LinkedList list1, LinkedList list2) {
        if (list1 == null || list2 == null) {
            return null;
        }
        int diff = 0;
        Node ptr1 = list1.head;
        Node ptr2 = list2.head;
        // diff记录两链表长度差，为正代表list1更长，反之则短
        while (ptr1 != null || ptr2 != null) {
            if (ptr1 == null) {
                diff--;
                ptr2 = ptr2.next;
            } else if (ptr2 == null) {
                diff++;
                ptr1 = ptr1.next;
            } else {
                ptr1 = ptr1.next;
                ptr2 = ptr2.next;
            }
        }
        ptr1 = list1.head;
        ptr2 = list2.head;
        if (diff > 0) {
            for (int i = 0; i < diff; i++) {
                ptr1 = ptr1.next;
            }
        } else {
            for (int i = diff; i < 0; i++) {
                ptr2 = ptr2.next;
            }
        }
        while (ptr1 != ptr2) {
            ptr1 = ptr1.next;
            ptr2 = ptr2.next;
            if (ptr1 == null) {
                return null;
            }
        }
        return ptr1;
    }

    public static void main(String[] args) {
        LinkedList list1 = new LinkedList();
        LinkedList list2 = new LinkedList();
        for (int i = 0; i < 7; i++) {
            list1.insertByEnd(new Node(i));
        }
        for (int i = 0; i < 10; i++) {
            list2.insertByEnd(new Node(i * (i + 2)));
        }
        System.out.println("两个链表：");
        list1.print();
        list2.print();
        Node ptr1 = list1.head;
        Node ptr2 = list2.head;
        for (int i = 0; i < 3; i++) {
            ptr1 = ptr1.next;
        }
        for (int i = 0; i < 5; i++) {
            ptr2 = ptr2.next;
        }
        ptr2.next = ptr1;
        System.out.println("两个结点：");
        System.out.println("ptr1:" + (ptr1 == null ? null : ptr1.value));
        System.out.println("ptr2:"+ ptr2.value);
        ptr2.next = ptr1;
        System.out.println(getIntersection(list1, list2).value);
    }
}
