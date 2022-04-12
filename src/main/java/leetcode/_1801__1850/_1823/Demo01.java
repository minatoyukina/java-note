package leetcode._1801__1850._1823;

import org.junit.Test;

import java.util.TreeSet;

public class Demo01 {


    @Test
    public void test() {
        System.out.println(findTheWinner(1, 2));
        System.out.println(findTheWinner(6, 5));
    }

    public int findTheWinner(int n, int k) {
        int pos = 1;
        TreeSet<Integer> set = new TreeSet<>();
        for (int i = 0; i < n; i++) set.add(i + 1);
        while (n > 1) {
            int mod = k % n;
            mod = mod == 0 ? n : mod;
            int remove = pos;
            while (--mod > 0) {
                Integer higher = set.higher(remove);
                remove = higher == null ? set.first() : higher;
            }
            Integer higher = set.higher(remove);
            pos = higher == null ? set.first() : higher;
            set.remove(remove);
            n--;
        }
        return set.iterator().next();
    }

}