package ByMartinPratice.链表;

/*
 * 题目：排序链表，使用归并排序，且不能使用递归（要求空间复杂度为1）*/
public class Code09_SortList {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public static void print(ListNode head) {
        ListNode ptr = head;
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

    public static ListNode sortList(ListNode head) {
        int d = 1;
        ListNode left_start, right_start, right_end;
        ListNode ptr;
        ListNode newHead = new ListNode();
        ListNode last_end;
        newHead.next = head;
        int size = size(head);
        while (d / 2 <= size) {
            left_start = newHead.next;
            last_end = newHead;
            while (left_start != null) {
                // 找right_start
                ptr = left_start;
                for (int i = 0; i < d && ptr != null; i++) {
                    ptr = ptr.next;
                }
                // 如果剩下的结点只够左半边，直接退出
                if (ptr == null) {
                    break;
                } else {
                    right_start = ptr;
                }
                // 找right_end
                for (int i = 0; i < d - 1 && ptr != null; i++) {
                    ptr = ptr.next;
                }
                right_end = ptr;
                last_end.next = merge(left_start, right_start, right_end);
                // last_end记录本轮的最后一个结点
                ptr = last_end.next;
                for (int i = 0; i < 2 * d - 1 && ptr != null; i++) {
                    ptr = ptr.next;
                }
                last_end = ptr;
                // 该轮的下一组继续合并, 如果right_end为null，说明右半边不够，直接退出
                if (last_end != null) {
                    left_start = last_end.next;
                } else {
                    break;
                }
            }
            d *= 2;
        }
        return newHead.next;
    }

    public static int size(ListNode head) {
        int size = 0;
        ListNode ptr = head;
        while (ptr != null) {
            ptr = ptr.next;
            size++;
        }
        return size;
    }

    public static ListNode merge(ListNode left_start, ListNode right_start, ListNode right_end) {
        if (right_start == null) {
            return left_start;
        }
        if (right_end != null) {
            right_end = right_end.next;
        }
        ListNode left_end = right_start;
        ListNode newHead = new ListNode();
        ListNode ptr = newHead;
        while (left_start != left_end && right_start != right_end) {
            if (left_start.val <= right_start.val) {
                ptr.next = left_start;
                left_start = left_start.next;
            } else {
                ptr.next = right_start;
                right_start = right_start.next;
            }
            ptr = ptr.next;
        }
        while (left_start != left_end) {
            ptr.next = left_start;
            left_start = left_start.next;
            ptr = ptr.next;
        }
        while (right_start != right_end) {
            ptr.next = right_start;
            right_start = right_start.next;
            ptr = ptr.next;
        }
        ptr.next = right_end;
        return newHead.next;
    }

    public static void main(String[] args) {
//        ListNode head1 = new ListNode(1);
//        ListNode head2 = new ListNode(4);
//        ListNode ptr1 = head1;
//        ListNode ptr2 = head2;
//        for (int i = 0; i < 4; i++) {
//            ptr1.next = new ListNode(i + 2);
//            ptr2.next = new ListNode(i + 5);
//            ptr1 = ptr1.next;
//            ptr2 = ptr2.next;
//        }
//        ptr1.next = head2;
//        print(head1);
//        head1.val = 3;
//        head1.next.val = 4;
//        head1.next.next.val = 1;
//        head1.next.next.next.val = 2;
//        print(head1);
//        print(sort(head1));
        ListNode head = new ListNode(-1);
        ListNode ptr = head;
        ptr.next = new ListNode(5);
        ptr = ptr.next;
        ptr.next = new ListNode(3);
        ptr = ptr.next;
        ptr.next = new ListNode(4);
        ptr = ptr.next;
        ptr.next = new ListNode(0);
        ptr = ptr.next;
        print(head);
        System.out.println(size(head));
        print(sortList(head));
    }
}
