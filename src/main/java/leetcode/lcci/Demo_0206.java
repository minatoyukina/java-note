package leetcode.lcci;

import leetcode._1__50._2.ListNode;
import leetcode.util.Common;
import org.junit.Test;

/**
 * @author ccq
 * @since 2021/4/14 10:39
 */
public class Demo_0206 {

    @Test
    public void test() {
        System.out.println(isPalindrome(Common.arrayToNode(1, 2, 3, 3, 2, 1)));
        System.out.println(isPalindrome(Common.arrayToNode(1, 2, 3, 3, 2)));
    }

    private boolean isPalindrome(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null) {
            if (fast.next != null) fast = fast.next.next;
            else break;
            slow = slow.next;
        }

        ListNode pre = null;
        while (slow != null) {
            ListNode next = slow.next;
            slow.next = pre;
            pre = slow;
            slow = next;
        }

        while (pre != null) {
            if (head.val != pre.val) return false;
            pre = pre.next;
            head = head.next;
        }
        return true;
    }
}
