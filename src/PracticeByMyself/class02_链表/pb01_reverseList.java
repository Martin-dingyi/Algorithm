package PracticeByMyself.class02_链表;

import common.entity.ListNode;
import common.utils.ListUtils;

import java.util.List;

/**
 * @author mdy
 * @date 2024-12-17 20:19
 * @description
 */
public class pb01_reverseList {

    public static void main(String[] args) {
        ListNode head = ListUtils.generateList(List.of(1, 2, 3, 4));
        ListNode listNode = reverseList(head);
        ListUtils.printList(listNode);
    }

    public static ListNode reverseList(ListNode head) {
        ListNode pre = null, cur = head;

        while (cur != null) {
            ListNode temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }

        return pre;
    }
}
