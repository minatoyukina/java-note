package leetcode._101__150._147;

import leetcode._1__50._2.ListNode;
import org.junit.Test;

public class Demo01 {


    @Test
    public void test() {
        System.out.println(insertionSortList(new ListNode(4, new ListNode(2, new ListNode(1, new ListNode(3))))));
        System.out.println(insertionSortList(new ListNode(-1, new ListNode(5, new ListNode(3, new ListNode(4, new ListNode(0)))))));
    }

    private ListNode insertionSortList(ListNode head) {
        ListNode cur = head;
        label:
        while (cur != null) {
            ListNode next = cur.next;
            if (next != null) {
                if (next.val < cur.val) {
                    ListNode tmp = head;
                    while (tmp != null) {
                        if (tmp == next) {
                            cur.next = next.next;
                            next.next = head;
                            head = next;
                            continue label;
                        }
                        if (next.val >= tmp.val && ((tmp.next == null || next.val <= tmp.next.val))) {
                            cur.next = next.next;
                            next.next = tmp.next;
                            tmp.next = next;
                            continue label;
                        }
                        tmp = tmp.next;
                    }
                }
            }
            cur = cur.next;
        }
        return head;
    }

}