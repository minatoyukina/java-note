package leetcode._133;

import java.util.ArrayList;
import java.util.List;

class Node {

    int val;
    List<Node> neighbors;

    Node() {
        val = 0;
        neighbors = new ArrayList<>();
    }

    Node(int _val) {
        val = _val;
        neighbors = new ArrayList<>();
    }

    Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
