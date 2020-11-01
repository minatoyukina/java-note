package leetcode._651__700._687;

import javafx.util.Pair;
import leetcode._50__100._100.TreeNode;
import leetcode.util.Common;
import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

public class Demo01 {

    @Test
    public void test() {
        TreeNode node = Common.arrayToTree(new Integer[]{1, 4, 5, 4, 4, 5});
        System.out.println(longestUnivaluePath(node));
    }


    private int longestUnivaluePath(TreeNode root) {
        int ans = 0;
        if (root == null) return ans;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode poll = queue.poll();
            Pair<Integer, Integer> dfs = dfs(poll);
            ans = Math.max(dfs.getKey() + dfs.getValue(), ans);
            if (poll.left != null) queue.offer(poll.left);
            if (poll.right != null) queue.offer(poll.right);
        }
        return ans;
    }

    private Pair<Integer, Integer> dfs(TreeNode root) {
        if (root != null) {
            if (root.left != null) {
                if (root.right != null) {
                    Pair<Integer, Integer> left = dfs(root.left);
                    Pair<Integer, Integer> right = dfs(root.right);
                    int l = root.left.val == root.val ? Math.max(left.getKey(), left.getValue()) + 1 : 0;
                    int r = root.right.val == root.val ? Math.max(right.getKey(), right.getValue()) + 1 : 0;
                    return new Pair<>(l, r);
                } else {
                    Pair<Integer, Integer> left = dfs(root.left);
                    int l = root.left.val == root.val ? Math.max(left.getKey(), left.getValue()) + 1 : 0;
                    return new Pair<>(l, 0);
                }
            } else {
                if (root.right != null) {
                    Pair<Integer, Integer> right = dfs(root.right);
                    int r = root.right.val == root.val ? Math.max(right.getKey(), right.getValue()) + 1 : 0;
                    return new Pair<>(0, r);
                }
            }
        }
        return new Pair<>(0, 0);
    }
}
