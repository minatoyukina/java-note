package leetcode._1101__1150._1146;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class Demo01 {


    @Test
    public void test() {
        SnapshotArray array = new SnapshotArray(1);
        array.set(0, 15);
        array.snap();
        array.snap();
        array.snap();
        System.out.println(array.get(0, 2));
        array.snap();
        array.snap();
        System.out.println(array.get(0, 0));
    }

    @SuppressWarnings("all")
    class SnapshotArray {

        private Map<Integer, Map<Integer, Integer>> map;
        private int snap;

        public SnapshotArray(int length) {
            map = new HashMap<>();
        }

        public void set(int index, int val) {
            Map<Integer, Integer> map = this.map.getOrDefault(snap, new HashMap<>());
            map.put(index, val);
            this.map.put(snap, map);
        }

        public int snap() {
            Map<Integer, Integer> map = this.map.getOrDefault(snap, new HashMap<>());
            Map<Integer, Integer> clone = new HashMap<>();
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                clone.put(entry.getKey(), entry.getValue());
            }
            this.map.put(snap + 1, clone);
            return snap++;
        }

        public int get(int index, int snap_id) {
            return map.getOrDefault(snap_id, new HashMap<>()).getOrDefault(index, 0);
        }
    }

}