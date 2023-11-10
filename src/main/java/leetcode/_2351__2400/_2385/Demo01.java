package leetcode._2351__2400._2385;

import leetcode._51__100._100.TreeNode;
import leetcode.util.Common;
import org.junit.Test;

import java.util.*;

public class Demo01 {


    @Test
    public void test() {
        System.out.println(amountOfTime(Common.arrayToTree(1, 5, 3, null, 4, 10, 6, 9, 2), 3));
    }

    public int amountOfTime(TreeNode root, int start) {
        Map<Integer, List<TreeNode>> map = new HashMap<>();
        dfs(root, null, map);
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> effected = new HashSet<>();
        queue.offer(start);
        effected.add(start);
        int step = 0;
        while (!queue.isEmpty()) {
            int total = effected.size();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Integer poll = queue.poll();
                for (TreeNode treeNode : map.get(poll))
                    if (treeNode != null && effected.add(treeNode.val)) queue.offer(treeNode.val);
            }
            if (effected.size() != total) step++;
        }
        return step;
    }

    private void dfs(TreeNode root, TreeNode parent, Map<Integer, List<TreeNode>> map) {
        if (root == null) return;
        map.put(root.val, Arrays.asList(parent, root.left, root.right));
        dfs(root.left, root, map);
        dfs(root.right, root, map);
    }

}