package leetcode._50__100._92;

import leetcode._1__50._2.ListNode;
import leetcode.util.Common;
import org.junit.Test;

import java.util.Stack;

public class Demo01 {

    @Test
    public void test() {
        System.out.println(reverseBetween(Common.arrayToNode(1, 2, 3, 4, 5), 2, 4));
        System.out.println(reverseBetween(Common.arrayToNode(1, 2, 3, 4, 5), 1, 2));
    }


    private ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode t1 = head;
        Stack<Integer> stack = new Stack<>();
        int n = right - left;
        ListNode t2 = null;
        while (t1 != null) {
            if (left == 1) {
                ListNode t3 = t1;
                t2 = t1;
                for (int i = 0; i <= n; i++) {
                    if (t3 != null) {
                        stack.push(t3.val);
                        t3 = t3.next;
                    }
                }
                break;
            } else left--;
            t1 = t1.next;
        }
        while (!stack.isEmpty() && t2 != null) {
            t2.val = stack.pop();
            t2 = t2.next;
        }
        return head;
    }
}
