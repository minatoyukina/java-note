package leetcode._901__950._950;

import org.junit.Test;

import java.util.Arrays;

public class Demo01 {


    @Test
    public void test() {
        System.out.println(Arrays.toString(deckRevealedIncreasing(new int[]{17, 13, 11, 2, 3, 5, 7})));
    }

    private int[] deckRevealedIncreasing(int[] deck) {
        int[] ans = new int[deck.length];
        Arrays.sort(deck);
        for (int i = deck.length - 1; i >= 0; i--) {
            ans[i] = deck[i];
            int last = ans[ans.length - 1];
            int j = ans.length - 2;
            while (j >= i + 1) ans[j + 1] = ans[j--];
            if (i + 1 <= ans.length - 1) ans[i + 1] = last;
        }
        return ans;
    }

}
