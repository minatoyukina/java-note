package leetcode._351__400._372;

import org.junit.Test;

public class Demo01 {


    @Test
    public void test() {
        System.out.println(superPow(2147483647, new int[]{2, 0, 0}));
        System.out.println(superPow(2, new int[]{1, 0}));
        System.out.println(superPow(2, new int[]{3}));
    }

    private int superPow(int a, int[] b) {
        return dfs(a, b, 0);
    }

    private int dfs(int a, int[] b, int index) {
        if (index == b.length - 1) return (int) (Math.pow(a, b[b.length - 1]) % 1337);
        if (b[b.length - 1] % 2 == 0) {
            for (int i = index; i < b.length; i++) {
                if (b[i] % 2 == 1) b[i + 1] += 10;
                b[i] /= 2;
            }
            return dfs((int) ((long) a * a % 1337), b, b[index] == 0 ? index + 1 : index);
        } else {
            b[b.length - 1]--;
            return (int) ((long) a * dfs(a, b, index) % 1337);
        }
    }

}