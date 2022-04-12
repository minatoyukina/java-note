package leetcode._701__750._748;

import org.junit.Test;

import java.util.Locale;

public class Demo01 {


    @Test
    public void test() {
        System.out.println(shortestCompletingWord("Ah71752", new String[]{"suggest", "letter", "of", "husband", "easy", "education", "drug", "prevent", "writer", "old"}));
        System.out.println(shortestCompletingWord("1s3 PSt", new String[]{"step", "steps", "stripe", "stepple"}));
    }

    public String shortestCompletingWord(String licensePlate, String[] words) {
        int[] plat = licensePlate.toLowerCase(Locale.ROOT).chars().filter(s -> s >= 'a' && s < 'z').sorted().toArray();
        String ans = null;
        label:
        for (String word : words) {
            int[] arr = word.chars().sorted().toArray();
            int pos = 0;
            for (int j = 0; j < plat.length; j++) {
                int i = plat[j];
                while (pos < arr.length && arr[pos] != i) pos++;
                if (++pos > arr.length && j >= plat.length - 1) continue label;
            }
            if (ans == null || word.length() < ans.length()) ans = word;
        }
        return ans;
    }

}