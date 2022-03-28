package leetcode._1451__1500._1462;

import leetcode.util.Common;
import org.junit.Test;

import java.util.*;

public class Demo01 {

    @Test
    public void test() {
        System.out.println(checkIfPrerequisite(5,
                Common.strToArray("[[3,4],[2,3],[1,2],[0,1]]"),
                Common.strToArray("[[0,4],[4,0],[1,3],[3,0]]")));
    }

    @SuppressWarnings("all")
    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        Map<Integer, Node> map = new HashMap<>();
        for (int[] prerequisite : prerequisites) {
            int x = prerequisite[0], y = prerequisite[1];
            Node node = map.get(y);
            if (node == null) node = new Node(y);
            Node pre = map.get(x);
            if (pre == null) pre = new Node(x);
            map.put(x, pre);
            map.put(y, node);
            pre.next.add(node);
            Queue<Node> queue = new LinkedList<>();
            queue.offer(node);
            while (!queue.isEmpty()) {
                Node poll = queue.poll();
                poll.set.add(pre.val);
                poll.set.addAll(pre.set);
                poll.pre.add(pre);
                queue.addAll(poll.next);
            }
        }
        List<Boolean> list = new ArrayList<>();
        for (int[] query : queries) {
            if (!map.containsKey(query[1])) list.add(false);
            else list.add(map.get(query[1]).set.contains(query[0]));
        }
        return list;
    }

    static class Node {
        Set<Node> pre = new HashSet<>();
        Set<Node> next = new HashSet<>();
        int val;
        Set<Integer> set = new HashSet<>();

        public Node(int val) {
            this.val = val;
        }
    }

}