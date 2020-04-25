package leetcode._328;

import leetcode._1__50._2.ListNode;
import org.junit.Test;

public class Demo01 {

    @Test
    public void test() {


    }


    private ListNode oddEvenList(ListNode head) {
        int index = 1;
        ListNode tmp = head;
        while (tmp != null) {
            if (index % 2 == 0 && tmp.next != null) {
                tmp.next = tmp.next.next;

            }
        }
        return head;
    }
}
