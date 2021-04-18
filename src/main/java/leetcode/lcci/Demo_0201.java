package leetcode.lcci;

import leetcode._1__50._2.ListNode;
import leetcode.util.Common;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * @author ccq
 * @since 2021/4/14 10:39
 */
public class Demo_0201 {

    @Test
    public void test() {
        System.out.println(removeDuplicateNodes(Common.arrayToNode(1, 2, 3, 3, 2, 1)));
    }

    private ListNode removeDuplicateNodes(ListNode head) {
        ListNode tmp = head;
        ListNode pre = head;
        Set<Integer> set = new HashSet<>();
        while (tmp != null) {
            if (set.contains(tmp.val)) {
                pre.next = tmp.next;
                tmp = pre.next;
            } else {
                set.add(tmp.val);
                pre = tmp;
                tmp = tmp.next;
            }
        }
        return head;
    }
}
