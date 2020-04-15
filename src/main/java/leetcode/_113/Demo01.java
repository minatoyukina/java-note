package leetcode._113;

import leetcode._50__100._100.TreeNode;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Demo01 {

    @Test
    public void test() {
        TreeNode treeNode = new TreeNode(5,
                new TreeNode(4, new TreeNode(11, new TreeNode(7), new TreeNode(2)), null),
                new TreeNode(8, new TreeNode(13), new TreeNode(4, new TreeNode(5), new TreeNode(1))));
        System.out.println(pathSum(treeNode, 22));
        System.out.println(pathSum(treeNode, 0));
    }

    private List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> list = new ArrayList<>();
        dfs(list, root, new ArrayList<>());
        System.out.println(list);
        return list.stream()
                .filter(s -> s.stream().reduce(Integer::sum).orElse(sum - 1) == sum)
                .collect(Collectors.toList());
    }

    private void dfs(List<List<Integer>> list, TreeNode root, List<Integer> key) {
        if (root != null) {
            list.remove(key);
            key.add(root.val);
            list.add(key);
            dfs(list, root.left, new ArrayList<>(key));
            dfs(list, root.right, new ArrayList<>(key));
        }
    }
}
