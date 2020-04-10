package leetcode._1__50._24;

import leetcode._1__50._2.ListNode;
import org.junit.Test;

public class Demo01 {

    @Test
    public void test() {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(4);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);
        l2.next.next.next = new ListNode(5);
        System.out.println(swapPairs(l1));
        System.out.println(swapPairs(l2));
    }

    private ListNode swapPairs(ListNode head) {
        ListNode node = head;
        while (head != null) {
            int tmp;
            tmp = head.val;
            if (head.next != null) {
                head.val = head.next.val;
                head.next.val = tmp;
                head = head.next.next;
            } else {
                break;
            }
        }
        return node;
    }
}
