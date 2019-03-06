package recursion;

public class Factorial {
    public static void main(String[] args) {
        int i = 6;
        System.out.println(factorial(i));
    }

    private static int factorial(int i) {
        if (i == 1)
            return 1;
        else
            return factorial(i-1)*i;
    }
}
