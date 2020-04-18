package leetcode._1__50._61;

import leetcode._1__50._2.ListNode;
import org.junit.Test;

public class Demo01 {

    @Test
    public void test() {
        System.out.println(rotateRight(new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5))))), 2));
        System.out.println(rotateRight(new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5))))), 8));
        System.out.println(rotateRight(new ListNode(1, new ListNode(2)), 1));
    }

    @Test
    public void testCut() {
        cut(new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5))))), 3);
        cut(new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5))))), 2);
    }

    private void cut(ListNode head, int k) {
        ListNode pre = head, su = null;
        int count = 1;
        while (pre != null) {
            if (count++ == k) {
                su = pre.next;
                pre.next = null;
                break;
            }
            pre = pre.next;
        }
        System.out.println(head);
        System.out.println(su);
    }

    private ListNode rotateRight(ListNode head, int k) {
        if (head == null) return null;
        ListNode t1 = head;
        int length = 0;
        while (t1 != null) {
            length++;
            t1 = t1.next;
        }
        k = k % length;
        if (k == 0) return head;

        ListNode pre = head, su = null;
        int count = 1;
        while (pre != null) {
            if (count++ == length - k) {
                su = pre.next;
                pre.next = null;
                break;
            }
            pre = pre.next;
        }

        ListNode t2 = su;
        while (t2 != null) {
            if (t2.next == null) {
                t2.next = head;
                break;
            }
            t2 = t2.next;
        }
        return su;
    }
}
