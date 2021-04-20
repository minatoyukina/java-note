package leetcode.lcci;

import leetcode._1__50._2.ListNode;
import leetcode.util.Common;
import org.junit.Test;

/**
 * @author ccq
 * @since 2021/4/14 10:39
 */
public class Demo_0205 {

    @Test
    public void test() {
        System.out.println(addTwoNumbers(Common.arrayToNode(1), Common.arrayToNode(9, 8)));
        System.out.println(addTwoNumbers(Common.arrayToNode(7, 1, 6), Common.arrayToNode(5, 9, 2)));
    }

    private ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (length(l1) < length(l2)) {
            ListNode tmp = l1;
            l1 = l2;
            l2 = tmp;
        }
        int carry = 0;
        ListNode ans = l1;
        while (l1 != null) {
            if (l2 != null) {
                l1.val += l2.val + carry;
                if (l1.val >= 10) {
                    l1.val -= 10;
                    carry = 1;
                } else carry = 0;
                l2 = l2.next;
            } else {
                l1.val += carry;
                if (l1.val >= 10) l1.val -= 10;
                else carry = 0;
            }
            if (l1.next == null && carry == 1) {
                l1.next = new ListNode(1);
                return ans;
            }
            l1 = l1.next;
        }
        return ans;
    }

    private int length(ListNode node) {
        ListNode tmp = node;
        int ans = 0;
        while (tmp != null) {
            ans++;
            tmp = tmp.next;
        }
        return ans;
    }
}
