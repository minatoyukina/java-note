package leetcode._501__550._513;

import leetcode._50__100._100.TreeNode;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class Demo01 {


    @Test
    public void test() {
        System.out.println(findBottomLeftValue(new TreeNode(2, new TreeNode(1), new TreeNode(3))));

    }

    private int findBottomLeftValue(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        dfs(root, 0, list);
        return list.get(list.size() - 1).get(0);
    }

    private void dfs(TreeNode root, int level, List<List<Integer>> list) {
        if (root != null) {
            if (list.size() <= level) list.add(new ArrayList<>());
            list.get(level).add(root.val);
            dfs(root.left, level + 1, list);
            dfs(root.right, level + 1, list);
        }
    }

}
