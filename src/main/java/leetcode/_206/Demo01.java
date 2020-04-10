package leetcode._206;

import leetcode._1__50._2.ListNode;
import org.junit.Test;

import java.util.Stack;

public class Demo01 {

    @Test
    public void test() {
        System.out.println(reverseList(new ListNode(1, new ListNode(2, new ListNode(3)))));
    }

    private ListNode reverseList(ListNode head) {
        Stack<ListNode> stack = new Stack<>();
        while (head != null) {
            stack.push(new ListNode(head.val));
            head = head.next;
        }
        System.out.println(stack);
        ListNode node = stack.pop();
        ListNode tmp = node;
        while (!stack.isEmpty()) {
            tmp.next = stack.pop();
            tmp = tmp.next;
        }
        return node;
    }
}
