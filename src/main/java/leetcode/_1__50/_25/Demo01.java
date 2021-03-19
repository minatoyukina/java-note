package leetcode._1__50._25;

import leetcode._1__50._2.ListNode;
import leetcode.util.Common;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class Demo01 {

    @Test
    public void test() {
        System.out.println(reverseKGroup(Common.arrayToNode(1, 2, 3, 4), 2));
        System.out.println(reverseKGroup(Common.arrayToNode(1, 2, 3, 4, 5), 3));
    }

    private ListNode reverseKGroup(ListNode head, int k) {
        List<Integer> list = new ArrayList<>();
        ListNode tmp = head;
        while (tmp != null) {
            list.add(tmp.val);
            tmp = tmp.next;
        }
        int i = 0;
        while (i < list.size()) {
            for (int x = i; x <= (i + i + k - 1) / 2; x++) {
                if (x >= list.size() || i + i + k - 1 - x >= list.size()) break;
                Integer pre = list.get(x);
                list.set(x, list.get(i + i + k - 1 - x));
                list.set(i + i + k - 1 - x, pre);
            }
            i += k;
        }
        ListNode root = null;
        ListNode t = null;
        for (int x : list) {
            if (root == null) {
                root = new ListNode(x);
                t = root;
            } else {
                t.next = new ListNode(x);
                t = t.next;
            }
        }
        return root;
    }

}
