package leetcode._1801__1850._1805;

import org.junit.Test;

import java.util.Arrays;

public class Demo01 {


    @Test
    public void test() {
        System.out.println(Arrays.toString("leeec12313fwef34".split("[^a-z]")));
        System.out.println(numDifferentIntegers("0a0"));
    }

    public int numDifferentIntegers(String word) {
        return (int) Arrays.stream(word.split("[a-z]+")).map(s -> {
            while (s.startsWith("0") && !s.equals("0")) s = s.substring(1);
            return s.trim();
        }).filter(s -> !s.isEmpty()).distinct().count();
    }

}