package leetcode._951__1000._993;

import leetcode._51__100._100.TreeNode;
import leetcode.util.Common;
import org.junit.Test;

import java.util.*;

public class Demo01 {


    @Test
    public void test() {
        System.out.println(isCousins(Common.arrayToTree(1, 2, 3, null, 4, null, 5), 5, 4));
        System.out.println(isCousins(Common.arrayToTree(1, 2, 3, null, 4, null, 5), 2, 3));
    }

    private boolean isCousins(TreeNode root, int x, int y) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        Map<Integer, Integer> map = new HashMap<>();
        while (!queue.isEmpty()) {
            int size = queue.size();
            Set<Integer> set = new HashSet<>();
            while (size-- > 0) {
                TreeNode poll = queue.poll();
                if (poll == null) continue;
                set.add(poll.val);
                queue.offer(poll.left);
                queue.offer(poll.right);
                if (poll.left != null && poll.right != null) {
                    map.put(poll.left.val, poll.right.val);
                }
            }
            if (set.contains(x) && set.contains(y)
                    && map.getOrDefault(x, 0) != y
                    && map.getOrDefault(y, 0) != x)
                return true;
        }
        return false;
    }
}