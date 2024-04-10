package ByMartinPratice.链表;

public class old_DoubleList {
    int maxSize;
    int maxValue;
    public old_DoubleList(int maxSize, int maxValue) {
        this.maxSize = maxSize;
        this.maxValue = maxValue;
    }
    public void getRandomDoubleList(DoubleNode head) {
        int size = (int)(Math.random() * (maxSize + 1));
        while (size != 0) {
            DoubleNode ptr = new DoubleNode();
            ptr = head.getNext();
            DoubleNode dNode = new DoubleNode((int)(Math.random() * (maxValue + 1) - (int)(Math.random() * maxValue)));
            head.setNext(dNode);
            dNode.setPre(head);
            dNode.setNext(ptr);
            ptr = dNode;
            size--;
        }
    }

    public void printDoubleList(DoubleNode head) {
        DoubleNode ptr = new DoubleNode();
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


class DoubleNode {
    int value;
    DoubleNode pre, next;
    public DoubleNode() {
        this.pre = null;
        this.next = null;
    }
    public DoubleNode(int value) {
        this.value = value;

    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public DoubleNode getPre() {
        return pre;
    }

    public void setPre(DoubleNode pre) {
        this.pre = pre;
    }

    public DoubleNode getNext() {
        return next;
    }

    public void setNext(DoubleNode next) {
        this.next = next;
    }
}