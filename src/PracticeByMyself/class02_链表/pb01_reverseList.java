package PracticeByMyself.class02_链表;

import common.entity.ListNode;

/**
 * @author mdy
 * @date 2024-12-17 20:19
 * @description
 */
public class pb01_reverseList {

    public static void main(String[] args) {

    }

    public static ListNode reverseList(ListNode head) {
        ListNode newHead = new ListNode();

        while (head != null) {
            ListNode temp = head.next;
            head.next = newHead.next;
            newHead.next = head;
            head = temp;
        }

        return newHead.next;
    }
}
