package recursion;

public class IndirectRecursion {
    private int count;

    private void a() {
        System.out.println(count);
        b();
    }

    private void b() {
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
