package leetcode._101__150._133;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Demo01 {

    @Test
    public void test() {
        ArrayList<Node> l1 = new ArrayList<>();
        ArrayList<Node> l2 = new ArrayList<>();
        ArrayList<Node> l3 = new ArrayList<>();
        ArrayList<Node> l4 = new ArrayList<>();
        Node a = new Node(1, l1);
        Node b = new Node(2, l2);
        Node c = new Node(3, l3);
        Node d = new Node(4, l4);
        l1.add(b);
        l1.add(d);
        l2.add(a);
        l2.add(c);
        l3.add(b);
        l3.add(d);
        l4.add(a);
        l4.add(c);
        cloneGraph(a).neighbors.get(1).neighbors.forEach(s -> System.out.println(s.val));
    }

    private Node cloneGraph(Node node) {
        Node copy = new Node(node.val);
        dfs(node, copy, new HashSet<>());
        return copy;
    }

    private void dfs(Node node, Node copy, Set<Node> set) {
        List<Node> list = new ArrayList<>();
        copy.neighbors = list;
        set.add(node);
        for (Node neighbor : node.neighbors) {
            Node tmp = new Node(neighbor.val, new ArrayList<>());
            list.add(tmp);
            if (!set.contains(neighbor)) {
                dfs(neighbor, tmp, set);
            } else {
                tmp.neighbors.add(copy);
            }
        }
    }
}
