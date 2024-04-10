package MartinByZuo.链表;

public class old_LinkedList {
    int maxSize;
    int maxValue;
    public old_LinkedList(int maxSize, int maxValue) {
        this.maxSize = maxSize;
        this.maxValue = maxValue;
    }
    public void getRandomList(Node head) {
        head.setNext(null);
        int size = (int) (Math.random() * maxSize);
        while (size != 0) {
            Node ptr = new Node();
            ptr = head.getNext();
            Node node = new Node((int)(Math.random() * (maxValue + 1) - (int)(Math.random() * maxValue)));
            head.setNext(node);
            node.setNext(ptr);
            size--;
        }
    }

    public void printLinkedList(Node head) {
        Node ptr = new Node();
        ptr = head.getNext();
        System.out.print("[");
        while (ptr != null) {
            System.out.print(ptr.getValue());
            if (ptr.getNext() != null)
                System.out.print(",");
            ptr = ptr.getNext();
        }
        System.out.println("]");
    }
}

class Node{
    int value;
    Node next;
    public Node() {

    }
    public Node(int value) {
        this.value = value;
        this.next = null;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}
