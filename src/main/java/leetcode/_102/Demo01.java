package leetcode._102;

import leetcode._100.TreeNode;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Demo01 {

    @Test
    public void test() {
        System.out.println(levelOrder(new TreeNode(3,
                new TreeNode(9),
                new TreeNode(20, new TreeNode(15), new TreeNode(7)))));
    }

    private List<List<Integer>> levelOrder(TreeNode root) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        dfs(root, map, 0);
        return map.entrySet().stream().map(Map.Entry::getValue).collect(Collectors.toList());
    }

    private void dfs(TreeNode root, Map<Integer, List<Integer>> map, int count) {
        if (root != null) {
            List<Integer> list = map.get(count) == null ? new ArrayList<>() : map.get(count);
            list.add(root.val);
            map.put(count++, list);
            dfs(root.left, map, count);
            dfs(root.right, map, count);
        }
    }

}
