package PracticeByMyself.class02_链表;

import common.entity.ListNode;
import common.utils.ListUtils;

import java.util.List;

/**
 * @author mdy
 * @date 2024-12-19 9:42
 * @description <a href="https://leetcode.cn/problems/palindrome-linked-list/">...</a>
 * 思路1：使用快慢指针找到链表中点，将链表一分为二，倒置后半段链表，然后比较
 */
public class pb99_回文链表 {

    public static void main(String[] args) {
        ListNode head = ListUtils.generateList(List.of(1,2,2,1));
        System.out.println(isPalindrome(head));
    }

    public static boolean isPalindrome(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode midNode = slow.next;
        midNode = reverseList(midNode);

        while (midNode != null) {
            if (head.val != midNode.val) {
                return false;
            }
            head = head.next;
            midNode = midNode.next;
        }
        return true;
    }

    private static ListNode reverseList(ListNode head) {
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
