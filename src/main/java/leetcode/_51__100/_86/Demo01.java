package leetcode._51__100._86;

import leetcode._1__50._2.ListNode;
import leetcode.util.Common;
import org.junit.Test;

public class Demo01 {

    @Test
    public void test() {
        System.out.println(partition(Common.arrayToNode(4, 4, 3, 2, 5, 2), 3));
        System.out.println(partition(Common.arrayToNode(2, 1, 3, 2), 2));
        System.out.println(partition(Common.arrayToNode(1, 1), 0));
    }

    private ListNode partition(ListNode head, int x) {
        if (head == null || head.next == null) return head;
        ListNode tmp = head;
        ListNode first = head.val < x ? head : null;
        ListNode second = head.val >= x ? head : null;
        ListNode pre = first;
        ListNode nex = second;
        while (true) {
            if (tmp.val < x && pre != tmp) {
                if (pre == null) {
                    first = tmp;
                    pre = first;
                } else {
                    pre.next = tmp;
                    pre = pre.next;
                }
            }
            if (tmp.val >= x && nex != tmp) {
                if (nex == null) {
                    second = tmp;
                    nex = second;
                } else {
                    nex.next = tmp;
                    nex = nex.next;
                }

            }
            if (tmp.next == null) {
                if (nex != null) nex.next = null;
                if (pre != null) pre.next = second;
                break;
            }
            tmp = tmp.next;
        }
        return first == null ? second : first;
    }
}
