package MartinByZuo.链表;

// 题目：从一个链表中删除给定值
public class Code02_DeleteGivenValue {
    public static class Node {
        int value;
        Node next;

        public Node() {

        }
        public Node(int value) {
            this.value = value;
            this.next = null;
        }
    }

    public static class LinkedList {
        public static void getRandomList(Node head, int maxSize, int maxValue) {
            Node ptr = new Node();
            int size = (int) (Math.random() * maxSize);
            while (size != 0) {
                ptr = head.next;
                Node node = new Node((int)(Math.random() * (maxValue + 1) - (int)(Math.random() * maxValue)));
                head.next = node;
                node.next = ptr;
                size--;
            }
        }
        public static void printList(Node head) {
            Node ptr = new Node();
            ptr = head.next;
            System.out.print("[");
            while (ptr != null) {
                System.out.print(ptr.value);
                if (ptr.next != null) {
                    System.out.print(",");
                }
                ptr = ptr.next;
            }
            System.out.println("]");
        }
    }

    public static void deleteGivenValue(Node head, int num) {
        Node ptr = head.next;
        Node pre = head;
        while (ptr != null) {
            if (ptr.value == num) {
                pre.next = ptr.next;
            }
            pre = pre.next;
            ptr = ptr.next;
        }
    }

    public static void main(String[] args) {
        Node head = new Node();
        LinkedList.getRandomList(head, 10, 10);
        LinkedList.printList(head);
        deleteGivenValue(head, 0);
        LinkedList.printList(head);
    }
}
