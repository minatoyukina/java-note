package leetcode._301__350._307;

import org.junit.Test;

@SuppressWarnings("all")
public class Demo01 {


    @Test
    public void test() {
    }

    static class NumArray {

        private Tree tree;
        private int[] nums;

        public NumArray(int[] nums) {
            tree = new Tree(nums);
            this.nums = nums;
        }

        public void update(int index, int val) {
            tree.add(index + 1, val - nums[index]);
            nums[index] = val;
        }

        public int sumRange(int left, int right) {
            return tree.query(left + right + 1) - tree.query(left);
        }
    }


    static class Tree {

        int[] tree;

        Tree(int[] arr) {
            tree = new int[arr.length + 1];
            for (int i = 0; i < arr.length; i++) add(i + 1, arr[i]);
        }

        private int lowBit(int x) {
            return x & -x;
        }

        private int query(int x) {
            int ans = 0;
            for (int i = x; i > 0; i -= lowBit(i)) ans += tree[i];
            return ans;
        }

        private void add(int x, int u) {
            for (int i = x; i < tree.length; i += lowBit(i)) tree[i] += u;
        }
    }

}