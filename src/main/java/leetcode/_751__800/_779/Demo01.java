package leetcode._751__800._779;

import org.junit.Test;

public class Demo01 {


    @Test
    public void test() {
        System.out.println(kthGrammar(3, 2));
        System.out.println(kthGrammar(3, 4));
        System.out.println(kthGrammar(30, 434991989));
    }

    private int kthGrammar(int N, int K) {
        if (N <= 2) return K > 1 ? 1 : 0;
        int total = (int) Math.pow(2, N - 1);
        if (K <= total / 2) return kthGrammar(N - 1, K);
        else return kthGrammar(N - 1, K - total * (K > total * 3 / 4 ? 3 : 1) / 4);
    }

}
