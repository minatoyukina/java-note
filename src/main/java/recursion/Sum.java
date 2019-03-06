package recursion;

public class Sum {
    public static void main(String[] args) {
        System.out.println(sum(100));
        System.out.println(tailSum(100, 1));
    }

    private static int sum(int i) {
//        if (i == 1) return 1;
//        else return sum(i - 1) + i;
        return (i == 1) ? 1 : sum(i - 1) + i;
    }

    private static int tailSum(int i, int j) {
        return (i <= 1) ? j : tailSum(i - 1, i+j);
    }
}
