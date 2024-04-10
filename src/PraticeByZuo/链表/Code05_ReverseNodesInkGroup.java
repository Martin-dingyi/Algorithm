package ByMartinPratice.链表;

/*
 * 题目：每k个结点为一组，翻转链表中的所有组，如果最后结点不足k个，则不翻转
 * */
public class Code05_ReverseNodesInkGroup {
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

    public static ListNode reverseKGroup(ListNode head, int k) {
        if (head == null) {
            return null;
        }
        ListNode ptr = head;
        ListNode ans = null;
        int n = 0;
        // 统计链表总长度
        while (ptr != null) {
            n++;
            ptr = ptr.next;
        }
        int d = n / k; // d记录一共要翻转几组
        ListNode first, end, last_end;
        first = null;
        end = head;
        for (int i = 0; i < d; i++) {
            last_end = first;
            first = end;
            ptr = first;
            for (int j = 0; j < k - 1; j++) {
                ptr = ptr.next;
            }
            end = ptr.next;
            // 记录总链表的头结点
            if (i == 0) {
                ans = reverse(first, end);
            } else {
                last_end.next = reverse(first, end);
            }
        }
        return ans;
    }

    // 比如1,2,3,4,5,6,7  head为2，end为5，那么逆置的是2,3,4这三个
    // 返回翻转链表的头结点
    public static ListNode reverse(ListNode head, ListNode end) {
        if (head == null) {
            return null;
        }
        ListNode temp = new ListNode();
        ListNode pre = end;
        ListNode ptr = head;
        do {
            temp.next = ptr;
            ptr = ptr.next;
            temp.next.next = pre;
            pre = temp.next;
        } while (ptr != end);
        return temp.next;
    }

    public static void main(String[] args) {
        ListNode list = new ListNode(1);
        ListNode ptr = list;
        for (int i = 0; i < 7; i++) {
            ptr.next = new ListNode(i + 2);
            ptr = ptr.next;
        }
        ptr = list;
        System.out.print("[");
        while (ptr != null) {
            System.out.print(ptr.val);
            ptr = ptr.next;
            if (ptr != null) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
//        System.out.println();
//        list = reverse(list.next, list.next.next.next.next);
//        ptr = list;
        ptr = reverseKGroup(list, 3);
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
}
