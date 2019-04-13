package oop.sub;

import org.junit.Test;

class StaticFinal {
    public static void test() {
        System.out.println("father");
    }

    public void test1() {
        System.out.println("father");
    }

    public static final void test2() {
        System.out.println("father");
    }
}

class B extends StaticFinal {
    public static void test() {
        System.out.println("son");
    }

    public void test1() {
        System.out.println("son");
    }

    public static void main(String[] args) {
        StaticFinal staticFinal=new B();
        staticFinal.test();
    }


//    public static void test2() {
//        System.out.println("son");
//    }
}

public class StaticFinalTest {
    public static void main(String[] args) {
        StaticFinal staticFinal = new B();
        StaticFinal.test();
        staticFinal.test();
        staticFinal.test1();
    }

}
