package leetcode._501__550._515;

import leetcode._51__100._100.TreeNode;
import leetcode.util.Common;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class Demo01 {


    @Test
    public void test() {
        System.out.println(largestValues(Common.arrayToTree(new Integer[]{1, 3, 2, 5, 3, null, 9})));

    }

    private List<Integer> largestValues(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        dfs(root, 0, list);
        return list;
    }

    private void dfs(TreeNode root, int level, List<Integer> list) {
        if (root != null) {
            if (list.size() > level) {
                if (list.get(level) < root.val) list.set(level, root.val);
            } else list.add(root.val);
            dfs(root.left, level + 1, list);
            dfs(root.right, level + 1, list);
        }
    }

}
