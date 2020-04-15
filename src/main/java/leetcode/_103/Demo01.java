package leetcode._103;

import leetcode._50__100._100.TreeNode;
import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

public class Demo01 {

    @Test
    public void test() {
        System.out.println(zigzagLevelOrder(new TreeNode(3,
                new TreeNode(9),
                new TreeNode(20, new TreeNode(15), new TreeNode(7, new TreeNode(3), new TreeNode(2))))));
    }

    private List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        Map<Integer, LinkedList<Integer>> map = new HashMap<>();
        dfs(root, map, 0);
        return map.entrySet().stream().map(Map.Entry::getValue).collect(Collectors.toList());
    }

    private void dfs(TreeNode root, Map<Integer, LinkedList<Integer>> map, int count) {
        if (root != null) {
            LinkedList<Integer> list = map.get(count) == null ? new LinkedList<>() : map.get(count);
            if (count % 2 == 0) list.addFirst(root.val);
            else list.addLast(root.val);
            map.put(count++, list);
            dfs(root.right, map, count);
            dfs(root.left, map, count);
        }
    }

}
