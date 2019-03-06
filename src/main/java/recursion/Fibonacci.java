package recursion;

public class Fibonacci {
    public static void main(String[] args) {
        for (int i = 1; i < 4; i++) {
            System.out.println(fibonacci(i));
        }
    }

    private static int fibonacci(int n){
        if (n<=2)
            return 1;
        else
            return fibonacci(n-1)+fibonacci(n-2);
    }
}
