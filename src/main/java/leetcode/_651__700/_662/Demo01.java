package leetcode._651__700._662;

import leetcode._50__100._100.TreeNode;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class Demo01 {


    @Test
    public void test() {
        System.out.println(widthOfBinaryTree(new TreeNode(1,
                new TreeNode(1, new TreeNode(5), new TreeNode(3)))
        ));
        System.out.println(widthOfBinaryTree(new TreeNode(1,
                new TreeNode(1, new TreeNode(1, null, new TreeNode(1))),
                new TreeNode(1, null, new TreeNode(1, null, new TreeNode(1))))
        ));

    }

    private int widthOfBinaryTree(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        dfs(root, list, 0, 0);
        return list.stream().map(s -> {
            int last = s.get(s.size() - 1);
            int first = s.get(0);
            return last * first < 0 ? last - first : last - first + 1;
        }).max(Integer::compareTo).orElse(0);
    }

    private void dfs(TreeNode root, List<List<Integer>> list, int n, int offset) {
        if (root != null) {
            if (list.size() <= n) {
                List<Integer> sub = new ArrayList<>();
                sub.add(offset);
                list.add(sub);
            } else {
                list.get(n).add(offset);
            }
            offset *= 2;
            dfs(root.left, list, n + 1, offset >= 0 ? offset - 1 : offset);
            dfs(root.right, list, n + 1, offset <= 0 ? offset + 1 : offset);
        }
    }
}
