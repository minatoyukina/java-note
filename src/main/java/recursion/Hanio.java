package recursion;

public class Hanio {
    private static int count;
    public static void main(String[] args) {
        int i = 6;
        char a = 'A', b = 'B', c = 'C';
        hanio(i, a, b, c);
        System.out.println(count);
    }

    private static void hanio(int i, char a, char b, char c) {
        if (i == 1) {
            System.out.println("move " + i + " from " + a + " to " + c);
            count++;
        } else {
            hanio(i - 1, a, c, b);
            count++;
            System.out.println("move " + i + " from " + a + " to " + c);
            hanio(i - 1, b, a, c);
        }
    }
}
