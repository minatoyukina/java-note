package leetcode._751__800._780;

import org.junit.Test;

public class Demo01 {


    @Test
    public void test() {
        System.out.println(reachingPoints(35, 13, 455955547, 420098884));
        System.out.println(reachingPoints(1, 1, 3, 5));
    }

    private boolean reachingPoints(int sx, int sy, int tx, int ty) {
        while (tx >= sx && ty >= sy) {
            if (sx == tx && sy == ty) return true;
            if (tx > ty) {
                if (ty > sy) tx %= ty;
                else return (tx - sx) % ty == 0;
            } else {
                if (tx > sx) ty %= tx;
                else return (ty - sy) % tx == 0;
            }
        }
        return false;
    }

}