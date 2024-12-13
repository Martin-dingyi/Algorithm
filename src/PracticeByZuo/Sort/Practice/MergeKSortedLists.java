package PracticeByZuo.Sort.Practice;

import PracticeByZuo.ComparatorUtils;

import java.util.*;

/*
* 题目：合并K个有序链表
* 分析：使用堆结构
* */
public class MergeKSortedLists {
    public static class Node {
        int value;
        Node next;

        public Node (int value) {
            this.value = value;
        }

        public Node () {

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

        public static boolean compare (LinkedList l1, LinkedList l2) {
            Node p1 = l1.head.next;
            Node p2 = l2.head.next;
            while (p1 != null && p2 != null) {
                if (p1.value != p2.value) {
                    return false;
                }
                p1 = p1.next;
                p2 = p2.next;
            }
            // 只有p1和p2等长才算相等
            return p1 == null && p2 == null;
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

    public static LinkedList mergeSortedLists (ArrayList<LinkedList> al) {
        LinkedList mergedList = new LinkedList();
        PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> a.value - b.value);
        for (int i = 0; i < al.size(); i++) {
            if (al.get(i).isEmpty()) {
                al.remove(al.get(i));
                continue;
            }
            pq.add(al.get(i).delete(al.get(i).head.next));
        }
        while (!al.isEmpty()) {
            mergedList.insertByEnd(pq.poll());
            for (int i = 0; i < al.size(); i++) {
                // 如何list为空，从al中删除它
                if (al.get(i).isEmpty()) {
                    al.remove(al.get(i));
                    continue;
                }
                pq.add(al.get(i).delete(al.get(i).head.next));
            }
        }
        return mergedList;
    }

    public static LinkedList comparator(ArrayList<LinkedList> al) {
        LinkedList mergedList = new LinkedList();
        LinkedList least;
        while (!al.isEmpty()) {
            least = al.get(0);
            for (int i = 0; i < al.size(); i++) {
                // 如果链表已经为空，从ArrayList删除它
                if (al.get(i).isEmpty()) {
                    al.remove(al.get(i));
                    if (!al.isEmpty())
                        least = al.get(0);
                    continue;
                }
                // 找到k个链表中第一个结点值最小的那个链表，由least记录
                if (al.get(i).peekFirst().value < least.peekFirst().value) {
                    least = al.get(i);
                }
            }
            mergedList.insertByEnd(least.delete(least.head.next));
        }
        return mergedList;
    }

    public static void main(String[] args) {
        int k = (int) (Math.random() * 10 + 1);
        boolean success = true;
        ArrayList<LinkedList> al = new ArrayList<>();
        ArrayList<LinkedList> copy_al = new ArrayList<>(al);
        for (int i = 0; i < k; i++) {
            al.add(new LinkedList());
            copy_al.add(new LinkedList());
        }
        // 创建链表数组
        ComparatorUtils cp = new ComparatorUtils();
        int[] arr = null;
        for (int i = 0; i < 500000; i++) {
            // 创建k个链表，放进al中
            for (int j = 0; j < al.size(); j++) {
                arr = cp.generateRandomArray(10, 10);
                Arrays.sort(arr);
                for (int value : arr) {
                    al.get(i).insertByEnd(new Node(value));
                    copy_al.get(i).insertByEnd(new Node(value));
                }
            }
            if (!LinkedList.compare(mergeSortedLists(al), comparator(copy_al))) {
                success = false;
                break;
            }
        }
        cp.check(success);
    }
}
