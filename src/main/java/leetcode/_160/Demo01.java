package leetcode._160;

import leetcode._1__50._2.ListNode;
import org.junit.Test;

public class Demo01 {

    @Test
    public void test() {
        System.out.println(Integer.valueOf(new StringBuilder(Integer.toBinaryString(43261596)).reverse().toString(), 10));
        ListNode c = new ListNode(8, new ListNode(4, new ListNode(5)));
        ListNode a = new ListNode(0, new ListNode(0, c));
        ListNode b = new ListNode(1, new ListNode(2, new ListNode(4, c)));
        System.out.println(getIntersectionNode(a, b));
    }

    private ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode a = headA;
        ListNode b = headB;
        while (a != null) {
            while (b != null) {
                if (a == b) return b;
                b = b.next;
            }
            b = headB;
            a = a.next;
        }
        return null;
    }
}
