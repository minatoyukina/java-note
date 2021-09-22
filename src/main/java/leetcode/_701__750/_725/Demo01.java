package leetcode._701__750._725;

import leetcode._1__50._2.ListNode;
import leetcode.util.Common;
import org.junit.Test;

import java.util.Arrays;

public class Demo01 {


    @Test
    public void test() {
        System.out.println(Arrays.toString(splitListToParts(null, 5)));
        System.out.println(Arrays.toString(splitListToParts(Common.arrayToNode(1, 2, 3, 4, 5, 6), 4)));
    }

    public ListNode[] splitListToParts(ListNode head, int k) {
        int len = 0;
        ListNode t1 = head;
        while (t1 != null) {
            len++;
            t1 = t1.next;
        }
        int x = len / k, y = len % k;
        ListNode[] listNodes = new ListNode[k];
        ListNode t2 = head;
        for (int i = 0; i < k; i++) {
            int z = x + (y > 0 ? 1 : 0);
            listNodes[i] = t2;
            ListNode t3 = t2;
            while (z-- > 0 && t3 != null) {
                t2 = t2.next;
                if (z == 0) t3.next = null;
                t3 = t3.next;
            }
            y--;
        }
        return listNodes;
    }

}