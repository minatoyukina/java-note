package leetcode._83;

import leetcode._2.ListNode;
import org.junit.Test;

public class Demo01 {

    @Test
    public void test() {
        ListNode node = new ListNode(1);
        node.next = new ListNode(1);
        node.next.next = new ListNode(2);
        node.next.next.next = new ListNode(3);
        node.next.next.next.next = new ListNode(3);
        node.next.next.next.next.next = new ListNode(3);
        node.next.next.next.next.next.next = new ListNode(4);
        System.out.println(deleteDuplicates(node));
    }

    private ListNode deleteDuplicates(ListNode head) {
        ListNode tmp = head;
        while (head != null && tmp.next != null) {
            if (tmp.val == tmp.next.val) {
                tmp.next = tmp.next.next;
            } else {
                tmp = tmp.next;
            }
        }
        return head;
    }
}
