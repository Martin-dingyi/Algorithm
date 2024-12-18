package PracticeByMyself.class06_链表;

import PracticeByMyself.ListNode;

/**
 * @author mdy
 * @date 2024-12-17 20:34
 * @description <a href="https://leetcode.cn/problems/merge-two-sorted-lists/">...</a>
 */
public class pb02_mergeTwoLists {

    public static void main(String[] args) {

    }

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode sortedList = new ListNode();
        ListNode sortedHead = sortedList;

        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                sortedList.next = list1;
                list1 = list1.next;
            } else {
                sortedList.next = list2;
                list2 = list2.next;
            }
            sortedList = sortedList.next;
        }

        sortedList.next = list1 != null ? list1 : list2;

        return sortedHead.next;
    }
}
