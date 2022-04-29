package leetcode._401__450._427;

import leetcode.util.Common;
import org.junit.Test;

public class Demo01 {


    @Test
    public void test() {
        System.out.println(construct(Common.strToArray(
                "[[1,1,1,1,0,0,0,0],[1,1,1,1,0,0,0,0],[1,1,1,1,1,1,1,1],[1,1,1,1,1,1,1,1]," +
                        "[1,1,1,1,0,0,0,0],[1,1,1,1,0,0,0,0],[1,1,1,1,0,0,0,0],[1,1,1,1,0,0,0,0]]")));
    }

    private Node construct(int[][] grid) {
        return dfs(grid, 0, 0, grid.length);
    }

    private Node dfs(int[][] grid, int x, int y, int d) {
        if (d == 1) return new Node(grid[x][y] == 1, true);
        Node n1 = dfs(grid, x, y, d / 2);
        Node n2 = dfs(grid, x, y + d / 2, d / 2);
        Node n3 = dfs(grid, x + d / 2, y, d / 2);
        Node n4 = dfs(grid, x + d / 2, y + d / 2, d / 2);
        boolean s1 = n1.val, s2 = n2.val, s3 = n3.val, s4 = n4.val;
        boolean al = n1.isLeaf && n2.isLeaf && n3.isLeaf && n4.isLeaf;
        if (al && s1 && s2 && s3 && s4) return new Node(true, true);
        if (al && !s1 && !s2 && !s3 && !s4) return new Node(false, true);
        Node n = new Node(false, false);
        n.topLeft = n1;
        n.topRight = n2;
        n.bottomLeft = n3;
        n.bottomRight = n4;
        return n;
    }

    static class Node {
        private boolean val;
        private boolean isLeaf;
        private Node topLeft;
        private Node topRight;
        private Node bottomLeft;
        private Node bottomRight;


        public Node() {
            this.val = false;
            this.isLeaf = false;
            this.topLeft = null;
            this.topRight = null;
            this.bottomLeft = null;
            this.bottomRight = null;
        }

        public Node(boolean val, boolean isLeaf) {
            this.val = val;
            this.isLeaf = isLeaf;
            this.topLeft = null;
            this.topRight = null;
            this.bottomLeft = null;
            this.bottomRight = null;
        }

        public Node(boolean val, boolean isLeaf, Node topLeft, Node topRight, Node bottomLeft, Node bottomRight) {
            this.val = val;
            this.isLeaf = isLeaf;
            this.topLeft = topLeft;
            this.topRight = topRight;
            this.bottomLeft = bottomLeft;
            this.bottomRight = bottomRight;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "val=" + val +
                    ", isLeaf=" + isLeaf +
                    ", topLeft=" + topLeft +
                    ", topRight=" + topRight +
                    ", bottomLeft=" + bottomLeft +
                    ", bottomRight=" + bottomRight +
                    '}';
        }
    }
}