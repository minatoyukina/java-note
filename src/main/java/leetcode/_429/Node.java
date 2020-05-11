package leetcode._429;

import java.util.List;

class Node {

    int val;
    List<Node> children;

    Node(int _val) {
        val = _val;
    }

    Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
}
