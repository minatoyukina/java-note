package leetcode._1651__1700._1689;

import org.junit.Test;

public class Demo01 {


    @Test
    public void test() {
        System.out.println(minPartitions("27346209830709182346"));
        System.out.println(minPartitions("82734"));
    }

    public int minPartitions(String n) {
        int max = 0;
        for (int i = 0; i < n.length(); i++) max = Math.max(max, n.charAt(i) - '0');
        return max;
    }

}