package oop.sub;

import java.math.BigDecimal;
import java.util.Arrays;

public class Father {
    private int age;
    public String gender;
    BigDecimal bigDecimal=BigDecimal.ONE;

    public Father(int age) {
        this.age = age;
    }

    public void test() {
        System.out.println("I'm your father");
    }

    void test1() {
        System.out.println("I'm father method1");
    }

    void test3() {
        System.out.println("I'm father method3");
    }

    static void test4() {
        System.out.println("I'm static");
    }

    public static void main(String[] args) {
        Father father = new Son(5);
        father.age=9;
        father.test();
        father.test3();
//        father.test2();
        ((Son) father).test2();

        Son son = new Son(9);
        son.test3();
        son.test4();
    }
}

class Son extends Father {

    public Son(int age) {
        super(age);
    }

    @Override
    public void test() {
        System.out.println("Son");
    }

    @Override
    public void test1() {
        test3();
    }


    void test2() {
        String[] strings=new String[1];
//        Son.main(strings);
        System.out.println("I'm myself");
    }

    public static void main(String[] args) {
        Son son=new Son(2);
        son.gender="boy";
        System.out.println(Arrays.toString(args));
        Father.main(args);
    }
}
