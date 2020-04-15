package leetcode._119;

import leetcode._50__100._100.TreeNode;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Demo01 {

    @Test
    public void test() {
        System.out.println(rightSideView(new TreeNode(1, new TreeNode(2), null)));
        System.out.println(rightSideView(new TreeNode(1,
                new TreeNode(2, null, new TreeNode(5)),
                new TreeNode(3, null, new TreeNode(4)))));
    }

    private List<Integer> rightSideView(TreeNode root) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        runOver(map, root, 0);
        List<Integer> list = new ArrayList<>();
        map.forEach((x, y) -> list.add(y.get(y.size() - 1)));
        return list;
    }

    private void runOver(Map<Integer, List<Integer>> map, TreeNode root, int count) {
        if (root != null) {
            List<Integer> list = map.get(count) == null ? new ArrayList<>() : map.get(count);
            list.add(root.val);
            map.putIfAbsent(count++, list);
            runOver(map, root.left, count);
            runOver(map, root.right, count);
        }
    }


}
