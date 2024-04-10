package PracticeByZuo.LinkedList;

// 题目：使用双链表实现栈和队列
public class Code03_DoubleEndsQueueToStackAndQueue {
    public static class DoubleNode {
        int value;
        DoubleNode pre, next;

        public DoubleNode() {
            this.next = null;
            this.pre = null;
        }

        public DoubleNode(int value) {
            this.value = value;
            this.next = null;
            this.pre = null;
        }
    }

    public static class DoubleList {
        public static void getRandomList(DoubleNode head, int maxSize, int maxValue) {
            int size = (int) (Math.random() * (maxSize + 1));
            DoubleNode ptr = head.next;
            while (size-- != 0) {
                DoubleNode node = new DoubleNode((int) (Math.random() * (maxValue + 1)) - (int) (Math.random() * maxValue));
                head.next = node;
                node.pre = head;
                node.next = ptr;
                if (ptr != null)
                    ptr.pre = node;
                ptr = node;
            }
        }

        public static void printDoubleList(DoubleNode head) {
            DoubleNode ptr = head.next;
            System.out.print("[");
            while (ptr != null) {
                System.out.print(ptr.value);
                ptr = ptr.next;
                if (ptr != null) {
                    System.out.print(",");
                }
            }
            System.out.println("]");
        }

        public static void insert(DoubleNode head, int value) {
            DoubleNode ptr = new DoubleNode();
            ptr = head.next;
            DoubleNode node = new DoubleNode(value);
            head.next = node;
            node.pre = head;
            node.next = ptr;
            if (ptr != null)
                ptr.pre = node;
        }
    }

    // 栈为后进先出
    public static class DListToStack {
        int size;
        int maxSize;
        DoubleNode head;

        public DListToStack(int maxSize) {
            this.maxSize = maxSize;
            this.size = 0;
            head = new DoubleNode();
        }

        public void push(int value) {
            if (size == maxSize) {
                throw new RuntimeException("栈满");
            }
            DoubleList.insert(head, value);
            size++;
        }

        public int pop() {
            if (size == 0) {
                throw new RuntimeException("栈空");
            }
            int value = head.next.value;
            head.next = head.next.next;
            if (head.next != null)
                head.next.pre = head;
            size--;
            return value;
        }
    }

    // 队列是先进先出
    public static class DListToQueue {
        int size;
        int maxSize;
        DoubleNode head;
        public DListToQueue(int maxSize) {
            this.maxSize = maxSize;
            this.size = 0;
            head = new DoubleNode();
        }

        public void push(int value) {
            if (size == maxSize) {
                throw new RuntimeException("队列满");
            }
            DoubleList.insert(head, value);
            size++;
        }

        public int pop() {
            if (size == 0) {
                throw new RuntimeException("队列空");
            }
            DoubleNode pre = head;
            DoubleNode ptr = head.next;
            while (ptr.next != null) {
                pre = ptr;
                ptr = ptr.next;
            }
            ptr.pre = null;
            pre.next = null;
            size--;
            return ptr.value;
        }
    }

    public static void main(String[] args) {
//        DoubleNode head = new DoubleNode();
//        old_DoubleList.getRandomList(head, 10, 10);
//        old_DoubleList.printDoubleList(head);
//        DListToStack dls = new DListToStack(4);
//        dls.push(1);
//        dls.push(2);
//        dls.push(3);
//        dls.push(4);
//        old_DoubleList.printDoubleList(dls.head);
//        System.out.println(dls.pop());
//        System.out.println(dls.pop());
//        System.out.println(dls.pop());
//        System.out.println(dls.pop());
//        System.out.println(dls.pop());
        DListToQueue dlq = new DListToQueue(4);
        dlq.push(1);
        dlq.push(2);
        dlq.push(3);
        dlq.push(4);
        DoubleList.printDoubleList(dlq.head);
        System.out.println(dlq.pop());
        System.out.println(dlq.pop());
        System.out.println(dlq.pop());
        System.out.println(dlq.pop());
        System.out.println(dlq.pop());
    }
}
