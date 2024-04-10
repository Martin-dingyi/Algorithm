package ByMartinPratice.链表;

/*
 题目：返回链表第一个回文结构
 分析：解题方法的证明过程不用管，有兴趣可以找资料去看，算法里只需要背。

 * */
public class Code08_LinkedListCycle {
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public static ListNode detectCycle(ListNode head) {
        if (head == null) {
            return null;
        }
        // 1.使用快慢指针遍历链表，如果fast指针没有到null，则链表中存在环
        ListNode fast = head;
        ListNode slow = head;
        do {
            if (fast == null || fast.next == null) {
                return null;
            }
            fast = fast.next.next;
            slow = slow.next;
        } while (fast != slow);
        // 2.在两指针相遇时停下，fast指针调到头部，然后两指针以相同的速度继续前进，相遇地点即为入环点
        fast = head;
        while (fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(3);
        ListNode ptr = head;
        ListNode temp;
        ptr.next = new ListNode(2);
        ptr = ptr.next;
        temp = ptr;
        ptr.next = new ListNode(0);
        ptr = ptr.next;
        ptr.next = new ListNode(-4);
        ptr = ptr.next;
        ptr.next = temp;
        System.out.println(detectCycle(head).val);
    }

}
