package leetcode._1851__1900._1897;

import org.junit.Test;

import java.util.Arrays;

public class Demo01 {


    @Test
    public void test() {
        System.out.println(makeEqual(new String[]{"bcc", "acaab", "bca"}));
    }

    public boolean makeEqual(String[] words) {
        int[] arr = new int[26];
        for (String word : words) for (int i = 0; i < word.length(); i++) arr[word.charAt(i) - 'a']++;
        return Arrays.stream(arr).allMatch(x -> x % words.length == 0);
    }


}