package leetcode._401__450._429;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Demo01 {


    @Test
    public void test() {
        Node node = new Node(3, Arrays.asList(new Node(5), new Node(6)));
        System.out.println(levelOrder(new Node(1, Arrays.asList(node, new Node(2), node))));
    }

    private List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> list = new ArrayList<>();
        levelOrder(root, list, 0);
        return list;
    }

    private void levelOrder(Node root, List<List<Integer>> list, int level) {
        if (root != null) {
            if (level >= list.size()) list.add(new ArrayList<>());
            list.get(level).add(root.val);
            List<Node> children = root.children;
            if (children != null) for (Node child : children) levelOrder(child, list, level + 1);
        }
    }

}
