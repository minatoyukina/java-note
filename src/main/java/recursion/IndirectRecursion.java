package recursion;

public class IndirectRecursion {
    private int count;

    private void a() {
        System.out.println(count);
        if (count < 100) {
            count++;
            b();
        }
    }

    private void b() {
        System.out.println(count);
        if (count < 100) {
            count++;
            a();
        }
    }

    public static void main(String[] args) {
        IndirectRecursion recursion = new IndirectRecursion();
        recursion.a();
    }
}
