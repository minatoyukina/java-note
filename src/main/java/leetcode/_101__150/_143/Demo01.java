package leetcode._101__150._143;

import leetcode._1__50._2.ListNode;
import leetcode.util.Common;
import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Demo01 {

    @Test
    public void test() {
        ListNode node = Common.arrayToNode(1, 2, 3);
        reorderList(node);
        System.out.println(node);
    }

    private void reorderList(ListNode head) {
        if (head == null || head.next == null) return;
        ListNode tmp3 = head;
        int count = 0;
        while (tmp3 != null) {
            count++;
            tmp3 = tmp3.next;
        }
        Queue<ListNode> queue = new LinkedList<>();
        Stack<ListNode> stack = new Stack<>();
        ListNode tmp1 = head;
        int i = 0;
        while (tmp1 != null) {
            if (i <= (count - 1) / 2) {
                queue.add(tmp1);
            } else {
                stack.add(tmp1);
            }
            i++;
            tmp1 = tmp1.next;
        }

        ListNode tmp2 = head;
        while (!queue.isEmpty() && !stack.isEmpty()) {
            ListNode poll = queue.poll();
            ListNode pop = stack.pop();
            tmp2.next = poll;
            tmp2 = tmp2.next;
            tmp2.next = pop;
            tmp2 = tmp2.next;
            if (stack.isEmpty()) {
                tmp2.next = null;
            }
        }
        if (!queue.isEmpty()) {
            ListNode poll = queue.poll();
            poll.next = null;
            tmp2.next = poll;
        }
    }
}
