package PracticeByMyself.class99_其他;

import common.entity.ListNode;
import common.utils.ListUtils;

import java.util.List;

/**
 * @author mdy
 * @date 2024-12-19 16:30
 * @description
 */
public class 旋转链表 {

    public static void main(String[] args) {
        ListNode head = ListUtils.generateList(List.of(1));
        ListUtils.printList(rotateRight(head, 99));
        System.out.println(rotateRight(null, 2));
    }

    public static ListNode rotateRight(ListNode head, int k) {
        if (head == null) {
            return null;
        }

        int size = 0;
        ListNode ptr = head;
        ListNode end = ptr;
        while (ptr != null) {
            end = ptr;
            ptr = ptr.next;
            size++;
        }

        k = size - k % size;

        if (k == size) {
            return head;
        } else {
            ptr = head;
            k--;
            while (k > 0) {
                ptr = ptr.next;
                k--;
            }

            ListNode newHead = ptr.next;
            end.next = head;
            ptr.next = null;
            return newHead;
        }
    }
}
