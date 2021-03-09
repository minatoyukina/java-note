package leetcode._51__100._83;

import leetcode._1__50._2.ListNode;
import leetcode.util.Common;
import org.junit.Test;

public class Demo01 {

    @Test
    public void test() {
        System.out.println(deleteDuplicates(Common.arrayToNode(1, 2, 3, 3, 4, 4, 5, 5, 5)));
    }

    private ListNode deleteDuplicates(ListNode head) {
        if (head == null) return null;
        while (head != null) {
            boolean flag = false;
            while (head.next != null && head.val == head.next.val) {
                flag = true;
                head = head.next;
            }
            if (flag) head = head.next;
            else break;
        }
        ListNode tmp = head;
        label:
        while (tmp != null) {
            ListNode t1 = tmp;
            boolean flag = false;
            while (t1 != null) {
                if (t1.next != null) {
                    if (t1.next.next != null) {
                        if (t1.next.val == t1.next.next.val) {
                            flag = true;
                        } else {
                            if (flag) {
                                tmp.next = t1.next.next;
                                continue label;
                            } else break;
                        }
                    } else {
                        if (flag) {
                            tmp.next = null;
                            return head;
                        }
                    }
                }
                t1 = t1.next;
            }
            tmp = tmp.next;
        }
        return head;
    }
}
