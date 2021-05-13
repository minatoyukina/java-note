package leetcode._101__150._148;

import leetcode._1__50._2.ListNode;
import leetcode.util.Common;
import org.junit.Test;

public class Demo01 {


    @Test
    public void test() {
        System.out.println(sortList(Common.arrayToNode(4, 2, 1, 3, 5)));
    }

    private ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode slow = head;
        ListNode fast = head;
        ListNode t1 = null;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            t1 = slow;
            slow = slow.next;
        }
        t1.next = null;
        ListNode left = sortList(head);
        ListNode right = sortList(slow);
        ListNode dummy = new ListNode(0);
        ListNode t2 = dummy;
        while (left != null && right != null) {
            if (left.val < right.val) {
                t2.next = left;
                t2 = t2.next;
                left = left.next;
            } else {
                t2.next = right;
                t2 = t2.next;
                right = right.next;
            }
            if (left != null) t2.next = left;
            if (right != null) t2.next = right;
        }
        return dummy.next;
    }

}