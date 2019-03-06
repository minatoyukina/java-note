package data_structure;

public class NLogN {
    private static <T extends Comparable<? super T>> int binarySearch(T[] a, T x) {
        int low = 0, high = a.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (a[mid].compareTo(x) < 0) low = mid + 1;
            else if (a[mid].compareTo(x) > 0) high = mid - 1;
            else return mid;
        }
        return -1;
    }

    private static long gcd(long m, long n) {
        while (n != 0) {
            long rem = m % n;
            m = n;
            n = rem;
        }
        return m;
    }

    private static long pow(long x, int n) {
        if (n == 0) return 1;
        if (n == 1) return x;
        if (n % 2 == 0) return pow(x * x, n / 2);
        else return pow(x * x, n / 2) * x;
    }

    private static double problemPrim(int n) {
        int rel = 0, tot = 0;
        for (int i = 0; i <= n; i++) {
            for (int j = 1 + i; j <= n; j++) {
                tot++;
                if (gcd(i, j) == 1) rel++;
            }
        }
        return (double) rel / tot;
    }

    public static void main(String[] args) {
        Integer[] arr = {1, 2, 3, 4, 5, 6, 7};
        Long[] arr1 = {1L, 2L, 3L, 4L, 5L, 6L, 7L};
        String[] string={"hello","world","java"};
        System.out.println(binarySearch(string,"java"));
        System.out.println(binarySearch(arr, 5));
        System.out.println(binarySearch(arr1, 5L));
        System.out.println(gcd(15, 6));
        System.out.println(pow(2, 6));
        System.out.println(problemPrim(2000));
    }
}
