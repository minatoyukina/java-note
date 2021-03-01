package leetcode._301__350._328;

import leetcode._1__50._2.ListNode;
import leetcode.util.Common;
import org.junit.Test;

public class Demo01 {

    @Test
    public void test() {
        System.out.println(oddEvenList(Common.arrayToNode(new int[]{1, 2, 3, 4, 5, 6})));
        System.out.println(oddEvenList(Common.arrayToNode(new int[]{1, 2})));
        System.out.println(oddEvenList(Common.arrayToNode(new int[]{1})));
        System.out.println(oddEvenList(null));
    }


    private ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode slow = head;
        ListNode fast = head.next;
        ListNode tmp = fast;
        while (slow != null && fast != null) {
            slow.next = fast.next;
            slow = slow.next;
            if (fast.next != null) {
                fast.next = fast.next.next;
                fast = fast.next;
            }
        }

        ListNode t = head;
        while (true) {
            if (t.next == null) {
                t.next = tmp;
                return head;
            }
            t = t.next;
        }
    }
}
