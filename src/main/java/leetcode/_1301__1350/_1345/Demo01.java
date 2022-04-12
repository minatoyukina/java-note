package leetcode._1301__1350._1345;

import org.junit.Test;

import java.util.*;

public class Demo01 {


    @Test
    public void test() {
        System.out.println(minJumps(new int[]{1}));
        System.out.println(minJumps(new int[]{100, -23, -23, 404, 100, 23, 23, 23, 3, 404}));
    }

    static class Entity {
        int pre;
        int cur;
        int next;

        public Entity(int pre, int cur, int next) {
            this.pre = pre;
            this.cur = cur;
            this.next = next;
        }

        @Override
        public int hashCode() {
            return pre * 31 + next;
        }

        @Override
        public boolean equals(Object obj) {
            if (!(obj instanceof Entity)) return false;
            Entity o = (Entity) obj;
            return o.pre == pre && o.next == next;
        }
    }

    public int minJumps(int[] arr) {
        Map<Integer, Set<Entity>> map = new HashMap<>();
        for (int x = 0; x < arr.length; x++) {
            int y = arr[x];
            Set<Entity> set = map.getOrDefault(y, new HashSet<>());
            set.add(new Entity(x - 1 < 0 ? -1 : arr[x - 1], x, x + 1 >= arr.length ? -1 : arr[x + 1]));
            map.put(y, set);
        }
        Set<Integer> visited = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        visited.add(0);
        int step = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                Integer cur = queue.poll();
                assert cur != null;
                if (cur == arr.length - 1) return step;
                Set<Entity> set = map.getOrDefault(arr[cur], Collections.emptySet());
                for (Entity next : set)
                    if (!visited.contains(next.cur)) {
                        queue.add(next.cur);
                        visited.add(next.cur);
                    }
                if (cur - 1 > 0 && !visited.contains(cur - 1)) {
                    queue.add(cur - 1);
                    visited.add(cur - 1);
                }
                if (cur + 1 < arr.length && !visited.contains(cur + 1)) {
                    queue.add(cur + 1);
                    visited.add(cur + 1);
                }
            }
            step++;
        }
        return step;
    }


}