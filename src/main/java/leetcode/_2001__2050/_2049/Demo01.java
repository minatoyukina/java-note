package leetcode._2001__2050._2049;

import org.junit.Test;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

/**
 * @author chenchuanqi
 * @version 1.0
 * @since 2022/1/20 09:58
 */
public class Demo01 {

    @Test
    public void test() {
        System.out.println(countHighestScoreNodes(new int[]{-1, 2, 0, 2, 0}));
    }

    public int countHighestScoreNodes(int[] parents) {
        int n = parents.length;
        Map<Integer, Tree> map = new HashMap<>();
        for (int i = 0; i < n; i++) map.put(i, new Tree(i));
        for (int i = 1; i < parents.length; i++) {
            Tree tree = map.get(parents[i]);
            if (tree.left == null) tree.left = map.get(i);
            else tree.right = map.get(i);
        }
        Tree root = map.get(0);
        count(root);
        HashMap<Long, Integer> ans = new HashMap<>();
        max(root, n, ans);
        return ans.entrySet().stream().max(Comparator.comparingLong(Map.Entry::getKey)).map(Map.Entry::getValue).orElse(0);
    }

    private int count(Tree tree) {
        if (tree == null) return 0;
        tree.count = count(tree.left) + count(tree.right) + 1;
        return tree.count;
    }

    private void max(Tree tree, int n, Map<Long, Integer> map) {
        if (tree == null) return;
        long left = tree.left == null ? 1 : tree.left.count, right = tree.right == null ? 1 : tree.right.count;
        long score = left * right * (n - tree.count == 0 ? 1 : (n - tree.count));
        map.put(score, map.getOrDefault(score, 0) + 1);
        max(tree.left, n, map);
        max(tree.right, n, map);
    }

    static class Tree {
        int val;
        Tree left;
        Tree right;
        int count;

        public Tree(int val) {
            this.val = val;
        }
    }


}
