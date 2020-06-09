package leetcode._877;

import org.junit.Test;

import java.util.LinkedList;

public class Demo01 {


    @Test
    public void test() {
        System.out.println(stoneGame(new int[]{5, 3, 4, 5}));
        System.out.println(stoneGame(new int[]{4, 3, 4, 3, 2, 5}));
    }

    @SuppressWarnings("all")
    private boolean stoneGame(int[] piles) {
        LinkedList<Integer> list = new LinkedList<>();
        for (int pile : piles) list.add(pile);
        int a = 0, b = 0;
        int index = 1;
        while (list.size() >= 2) {
            if (list.peekFirst() >= list.pollLast()) {
                if (index % 2 == 1) a += list.pollFirst();
                else b += list.pollFirst();
            } else {
                if (index % 2 == 1) a += list.pollLast();
                else b += list.pollLast();
            }
            index++;
        }
        return a > b;
    }

}
