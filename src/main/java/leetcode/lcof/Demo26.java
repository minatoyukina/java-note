package leetcode.lcof;

import leetcode._51__100._100.TreeNode;
import leetcode.util.Common;
import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

public class Demo26 {

    @Test
    public void test() {
        System.out.println(isSubStructure(Common.arrayToTree(1, 2, 3, 4, null, null, 5), Common.arrayToTree(2, 4)));
    }

    private boolean isSubStructure(TreeNode A, TreeNode B) {
        if (A == null || B == null) return false;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(A);
        while (!queue.isEmpty()) {
            TreeNode poll = queue.poll();
            if (poll.val == B.val && dfs(poll, B)) return true;
            if (poll.left != null) queue.offer(poll.left);
            if (poll.right != null) queue.offer(poll.right);
        }
        return false;
    }

    private boolean dfs(TreeNode a, TreeNode b) {
        if (b == null) return true;
        if (a == null || b.val != a.val) return false;
        return dfs(a.left, b.left) && dfs(a.right, b.right);
    }
}
