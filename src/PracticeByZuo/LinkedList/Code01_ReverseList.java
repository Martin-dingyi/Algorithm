package PracticeByZuo.LinkedList;

// 题目一：反转单链表
// 题目二：反转双链表

public class Code01_ReverseList {
    public static void reverseList(Node head) {
//        old_LinkedList ll = new old_LinkedList(10, 10);
        Node ptr = new Node();
        Node newHead = new Node(-20000);
        ptr = null;
        while (head.getNext() != null) {
            newHead.setNext(head.getNext());
            head.setNext(head.getNext().getNext());
            newHead.getNext().setNext(ptr);
            ptr = newHead.getNext();
        }
        head.setNext(newHead.getNext());
    }

    public static void reverseDoubleList(DoubleNode head) {
        DoubleNode ptr = new DoubleNode();
        DoubleNode newHead = new DoubleNode();
        ptr = null;
        while (head.getNext() != null) {
            newHead.setNext(head.getNext());
            newHead.getNext().setPre(newHead);
            head.setNext(head.getNext().getNext());
            newHead.getNext().setNext(ptr);
            if (ptr != null)
                ptr.setPre(newHead.getNext());
            ptr = newHead.getNext();
        }
        head.setNext(newHead.getNext());
    }


    public static void main(String[] args) {
//        Node head = new Node(-10000);
//        old_LinkedList ll = new old_LinkedList(10, 10);
//        ll.getRandomList(head);
//        ll.printLinkedList(head);
//        reverseList(head);
//        ll.printLinkedList(head);

        DoubleNode head = new DoubleNode();
        old_DoubleList dl = new old_DoubleList(10, 10);
        dl.getRandomDoubleList(head);
        dl.printDoubleList(head);
        reverseDoubleList(head);
        dl.printDoubleList(head);
    }

}
