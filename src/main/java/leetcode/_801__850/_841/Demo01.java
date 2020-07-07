package leetcode._801__850._841;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentSkipListSet;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Demo01 {


    @Test
    public void test() {
        System.out.println(canVisitAllRooms(Arrays.asList(
                Arrays.asList(1, 3),
                Arrays.asList(2, 0, 1),
                Arrays.asList(2, 2),
                Arrays.asList(0, 0)
        )));
    }

    private boolean canVisitAllRooms(List<List<Integer>> rooms) {
        Set<Integer> in = new HashSet<>();
        in.add(0);
        Set<Integer> keys = new ConcurrentSkipListSet<>(rooms.get(0));
        for (int i = 0; i < rooms.size(); i++) {
            for (Integer key : keys) {
                if (!in.contains(key)) {
                    keys.addAll(rooms.get(key));
                    in.add(key);
                }
            }
        }
        return in.equals(IntStream.range(0, rooms.size()).boxed().collect(Collectors.toSet()));
    }

}
