package MartinByZuo.其他数据结构;

import java.util.HashMap;

// 题目：LRU就是最近最少使用算法
// 分析：使用双链表可以节省时间，但我没有使用
public class Code02_LRU {

    static class LRUCache {
        static class Node {
            int val, key;
            Node next;

            public Node() {
            }

            public Node(int key, int val) {
                this.key = key;
                this.val = val;
                next = null;
            }
        }

        static class LinkedList {
            Node head;
            Node tail;

            // 删除头结点
            public Node deleteHead() {
                if (head == null) {
                    return null;
                }
                Node ptr = head.next;
                head.next = null;
                Node deleted = head;
                head = ptr;
                return deleted;
            }

            // 链表尾部插入结点
            public void addTail(Node node) {
                // 链表中没有结点时
                if (head == null) {
                    head = node;
                    tail = node;
                    return;
                }
                tail.next = node;
                tail = node;
            }

            // 删除任意结点，除了头结点
            public void delete(Node node) {
                if (node == null) {
                    return;
                }
                // 利用ptr找到node前面的结点
                Node ptr = head;
                while (ptr.next != node) {
                    ptr = ptr.next;
                }
                ptr.next = node.next;
                node.next = null;
            }
        }

        public int size, capacity;
        LinkedList list;
        HashMap<Integer, Node> hashMap;

        public LRUCache(int capacity) {
            this.capacity = capacity;
            size = 0;
            list = new LinkedList();
            hashMap = new HashMap<>();
        }

        public void put(int key, int value) {
            if (hashMap.containsKey(key)) {
                hashMap.get(key).val = value;
                get(key);
                return;
            }
            // 如果内存满了，则需要删掉最近最少使用的结点,也就是链表中的头结点
            if (size == capacity) {
                Node temp = list.deleteHead();
                hashMap.remove(temp.key);
                size--;
            }
            Node node = new Node(key, value);
            hashMap.put(key, node);
            list.addTail(node);
            size++;
        }

        public int get(int key) {
            if (!hashMap.containsKey(key)) {
                return -1;
            }
            // 更新结点在链表中位置
            Node node = hashMap.get(key);
            if (node != list.tail) {
                if (node == list.head) {
                    list.deleteHead();
                } else {
                    list.delete(node);
                }
                list.addTail(node);
            }
            return node.val;
        }
    }

    public static void main(String[] args) {
        LRUCache lc = new LRUCache(3);
        lc.put(1, 10);
        lc.put(2, 20);
        lc.put(3, 30);
        System.out.println(lc.get(2));
        System.out.println(lc.get(1));
        lc.put(3, 1000);
        lc.put(4, 40);
        System.out.println(lc.get(2));
    }
}
