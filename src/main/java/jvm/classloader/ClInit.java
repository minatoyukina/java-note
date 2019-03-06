package jvm.classloader;

public class ClInit {
    static class Parent {
        static int A = 1;

        static {
            A = 2;
        }
    }

    static class Sub extends Parent {
        static int B = A;
    }

    public static void main(String[] args) {
        System.out.println(Sub.B);
    }
}
