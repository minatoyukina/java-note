package leetcode._851__900._881;

import org.junit.Test;

import java.util.TreeMap;

public class Demo01 {


    @Test
    public void test() {
        System.out.println(numRescueBoats(new int[]{3, 1, 7}, 7));
        System.out.println(numRescueBoats(new int[]{3, 5, 3, 4}, 7));
    }


    public int numRescueBoats(int[] people, int limit) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int person : people) map.put(person, map.getOrDefault(person, 0) + 1);
        int ans = 0;
        for (int person : people) {
            int x = limit - person;
            if (!map.containsKey(person)) continue;
            if (map.get(person) == 1) map.remove(person);
            else map.put(person, map.get(person) - 1);
            ans++;
            Integer floor = map.floorKey(x);
            if (floor != null) {
                if (map.get(floor) == 1) map.remove(floor);
                else map.put(floor, map.get(floor) - 1);
            }
        }
        return ans;
    }


}