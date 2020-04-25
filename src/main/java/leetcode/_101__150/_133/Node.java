package leetcode._101__150._133;

import java.util.ArrayList;
import java.util.List;

class Node {

    int val;
    List<Node> neighbors;

    Node(int _val) {
        val = _val;
        neighbors = new ArrayList<>();
    }

    Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }

    @Override
    public String toString() {
        return "Node{" +
                "val=" + val +
                ", neighbors=" + neighbors +
                '}';
    }
}
