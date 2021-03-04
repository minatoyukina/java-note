package leetcode._451__500._470;

import org.junit.Test;

import java.util.Random;

public class Demo01 {


    @Test
    public void test() {
        for (int i = 0; i < 100000; i++) {
            System.out.println(rand10());
        }
    }

    // (rand7()-1)*7+rand7(), 1-49平均分布
    private int rand10() {
        int i = rand7() * rand7();
        if (i < 5 || i > 42) {
            return rand10();
        }
        if (i == 6) return 1;
        else if (i == 12) return 2;
        else if (i == 5 || i == 7) return 3;
        else if (i == 8 || i == 10) return 4;
        else if (i == 14 || i == 15) return 5;
        else if (i == 18 || i == 20) return 6;
        else if (i == 21 || i == 24) return 7;
        else if (i == 28 || i == 30) return 8;
        else if (i == 35 || i == 42) return 9;
        else return 10;
    }

    private int rand7() {
        return new Random().nextInt(7) + 1;
    }

}
