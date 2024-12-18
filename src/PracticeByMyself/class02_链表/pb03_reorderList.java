package PracticeByMyself.class02_链表;

import common.entity.ListNode;
import common.utils.ListUtils;

import java.util.List;

/**
 * @author mdy
 * @date 2024-12-17 20:42
 * @description <a href="https://leetcode.cn/problems/reorder-list/submissions/587729826/">...</a>
 */
public class pb03_reorderList {

    public static void main(String[] args) {
        ListNode head = ListUtils.generateList(List.of(1,2,3,4,5));
        ListUtils.printList(head);
        reorderList(head);
        ListUtils.printList(head);

    }

    public static void reorderList(ListNode head) {
        // 思路1：复制一份倒置的链表，然后两链表交替合并成新链表，每次指针跳两步
        // 思路2：找到链表的中点，倒置中点后面的链表，然后拿两个链表交叉合并。
        ListNode midNode = getMidNode(head);
        ListNode reversedListHead = getReversedList(midNode.next);

        ListNode ptr1 = head;
        ListNode ptr2 = reversedListHead;

        while (ptr2 != null) {
            ListNode temp = ptr2.next;

            ptr2.next = ptr1.next;
            ptr1.next = ptr2;

            ptr1 = ptr2.next;
            ptr2 = temp;
        }
        ptr1.next = null;

    }

    private static ListNode getMidNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while(fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    private static ListNode getReversedList(ListNode head) {
        ListNode reversedListHead = new ListNode();

        while (head != null) {
            ListNode temp = head.next;
            head.next = reversedListHead.next;
            reversedListHead.next = head;
            head = temp;
        }

        return reversedListHead.next;
    }
}
