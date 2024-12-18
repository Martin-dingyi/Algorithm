package Utils;

import PracticeByMyself.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author mdy
 * @date 2024-12-17 20:56
 * @description
 */
public class ListNodeUtils {

    public static ListNode generateList(List<Integer> numList) {

        ListNode head = new ListNode();
        ListNode ptr = head;

        for (Integer num : numList) {
            ptr.next = new ListNode(num);
            ptr = ptr.next;
        }

        return head.next;
    }

    public static ListNode generateRandomList(int maxSize, int maxNum) {
        List<Integer> numList = new ArrayList<>();

        int size = (int) (Math.random() * ++maxSize);
        for (int i = 0; i < size; i++) {
            numList.add((int) (Math.random() * ++maxNum));
        }

        return generateList(numList);
    }

    public static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.println();
    }
}
