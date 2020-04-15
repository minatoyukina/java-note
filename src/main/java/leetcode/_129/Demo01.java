package leetcode._129;

import leetcode._50__100._100.TreeNode;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class Demo01 {

    @Test
    public void test() {
        System.out.println(sumNumbers(new TreeNode(1, new TreeNode(2), new TreeNode(2))));

    }

    private int sumNumbers(TreeNode root) {
        List<String> list = new ArrayList<>();
        dfs(list, root, "");
        System.out.println(list);
        return list.stream().map(Integer::parseInt).reduce(Integer::sum).orElse(0);
    }

    private void dfs(List<String> list, TreeNode root, String key) {
        if (root != null) {
            list.remove(key);
            key = key + root.val;
            list.add(key);
            dfs(list, root.left, key);
            dfs(list, root.right, key);
        }
    }
}
