package leetcode.lcci;

import leetcode._1__50._2.ListNode;
import leetcode._51__100._100.TreeNode;
import leetcode.util.Common;
import org.junit.Test;

import java.util.*;

/**
 * @author ccq
 * @since 2021/4/14 10:39
 */
public class Demo_0403 {

    @Test
    public void test() {
        System.out.println(Arrays.toString(listOfDepth(Common.arrayToTree(1, 2, 3, 4, 5, null, 7, 8))));
    }


    private ListNode[] listOfDepth(TreeNode tree) {
        if (tree == null) return null;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(tree);
        List<ListNode> list = new ArrayList<>();
        while (!queue.isEmpty()) {
            int size = queue.size();
            ListNode head = new ListNode(0);
            ListNode tmp = head;
            while (size-- > 0) {
                TreeNode poll = queue.poll();
                assert poll != null;
                tmp.next = new ListNode(poll.val);
                tmp = tmp.next;
                if (poll.left != null) queue.offer(poll.left);
                if (poll.right != null) queue.offer(poll.right);
            }
            list.add(head.next);
        }
        ListNode[] ans = new ListNode[list.size()];
        for (int i = 0; i < list.size(); i++) ans[i] = list.get(i);
        return ans;
    }

}
