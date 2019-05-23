package design_pattern.singleton;

public class SafetyTest {
    public static void main(String[] args) {
//        Runnable runnable=()-> System.out.println(ThreadSafeDoubleCheckLocking.getInstance());
        Runnable runnable=()-> System.out.println(EnumSingleton.INSTANCE);
//        Runnable runnable=()-> System.out.println(Lazy.getInstance());
        new Thread(runnable).start();
        new Thread(runnable).start();
        new Thread(runnable).start();
        new Thread(runnable).start();
        new Thread(runnable).start();
        new Thread(runnable).start();
    }
}
