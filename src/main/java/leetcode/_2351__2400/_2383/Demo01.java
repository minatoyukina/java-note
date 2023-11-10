package leetcode._2351__2400._2383;

import org.junit.Test;

public class Demo01 {


    @Test
    public void test() {
        System.out.println(minNumberOfHours(5, 3, new int[]{1, 4, 3, 2}, new int[]{2, 6, 3, 1}));
    }

    public int minNumberOfHours(int initialEnergy, int initialExperience, int[] energy, int[] experience) {
        int maxExp = 0, maxEng = 0;
        for (int i : experience) {
            if (initialExperience <= i) {
                maxExp += i - initialExperience + 1;
                initialExperience += i - initialExperience + 1;
            }
            initialExperience += i;
        }
        for (int i : energy) {
            if (initialEnergy <= i) {
                maxEng += i - initialEnergy + 1;
                initialEnergy += i - initialEnergy + 1;
            }
            initialEnergy -= i;
        }
        return maxEng + maxExp;
    }

}