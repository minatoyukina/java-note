package leetcode.lcci;

import leetcode._1__50._2.ListNode;
import leetcode.util.Common;
import org.junit.Test;

/**
 * @author ccq
 * @since 2021/4/14 10:39
 */
public class Demo_0207 {

    @Test
    public void test() {
        ListNode a = Common.arrayToNode(1, 2, 3);
        ListNode b = Common.arrayToNode(1, 2);
        ListNode c = Common.arrayToNode(4, 5);
        a.next.next.next = c;
        b.next.next = c;
        System.out.println(getIntersectionNode(a, b));
    }

    private ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode t1 = headA, t2 = headB;
        int l1 = 0, l2 = 0;
        while (t1 != null) {
            l1++;
            t1 = t1.next;
        }
        while (t2 != null) {
            l2++;
            t2 = t2.next;
        }
        ListNode t3 = l2 > l1 ? headB : headA, t4 = l2 > l1 ? headA : headB;
        for (int i = 0; i < Math.abs(l2 - l1); i++) t3 = t3.next;
        while (t3 != null) {
            if (t3 == t4) return t3;
            t3 = t3.next;
            t4 = t4.next;
        }
        return null;
    }
}
