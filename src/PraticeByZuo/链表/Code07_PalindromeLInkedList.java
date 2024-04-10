package ByMartinPratice.链表;

import java.util.List;

/*
 * 题目：判断链表是不是回文结构
 * */
public class Code07_PalindromeLInkedList {
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

    public static boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        boolean ans = true;
        // 1.利用快慢指针找到链表的中点
        ListNode slow = head;
        ListNode fast = head;
        ListNode mid;
        int n = 1;
        while (fast.next != null) {
            fast = fast.next;
            if (n++ % 2 == 0) {
                slow = slow.next;
            }
        }
        mid = slow;
        // 2.逆置中点后面的结点
        // 此时fast指向链表的最后一个结点
        ListNode back, pre;
        ListNode ptr = mid.next;
        back = null;
        pre = mid;
        mid.next = null;
        while (ptr != null) {
            back = ptr.next;
            ptr.next = pre;
            pre = ptr;
            ptr = back;
        }
        // 3.由原中点为终点的两链表，互相从头开始比较
        // 此时pre指向原链表最后一个结点
        ListNode end = pre;
        ptr = head;
        while (ptr != null && end != null) {
            if (ptr.val != end.val) {
                ans = false;
                break;
            }
            ptr = ptr.next;
            end = end.next;
        }
        // 4.恢复链表
        // 此时的back等于null，pre指向最后一个结点
        ptr = pre;
        back = pre.next;
        pre = null;
        while (pre != mid) {
            ptr.next = pre;
            pre = ptr;
            ptr = back;
            if (back != null) {
                back = back.next;
            }
        }
        return ans;
    }

    public static void print(ListNode head) {
        System.out.print("[");
        while (head != null) {
            System.out.print(head.val);
            head = head.next;
            if (head != null) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode ptr = head;
        for (int i = 0; i < 5; i++) {
            ptr.next = new ListNode(i + 2);
            ptr = ptr.next;
        }
        print(head);
        System.out.println(isPalindrome(head));
    }
}
