package leetcode._201__250._223;

import org.junit.Test;

public class Demo01 {


    @Test
    public void test() {
        System.out.println(computeArea(-2, -2, 2, 2, 1, 1, 3, 3));
        System.out.println(computeArea(-3, 0, 3, 4, 0, -1, 9, 2));
        System.out.println(computeArea(-2, -2, 2, 2, -1, -2, 0, 0));
    }

    @SuppressWarnings("all")
    private int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int width = 0, height = 0;
        if (E <= A && G >= C) width = C - A;
        else if (E >= A && E <= C && G >= A && G <= C) width = G - E;
        else if (E <= A && G > A && G <= C) width = G - A;
        else if (E >= A && E < C && G >= C) width = C - E;

        if (F <= B && H >= D) height = B - D;
        else if (F >= B && F <= D && H >= B && H <= D) height = H - F;
        else if (F <= B && H > B && H <= D) height = H - B;
        else if (F >= B && F < D && H >= D) height = D - F;
        return (C - A) * (D - B) + (G - E) * (H - F) - width * height;

    }
}