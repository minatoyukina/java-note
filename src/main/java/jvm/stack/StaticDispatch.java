package jvm.stack;

public class StaticDispatch {
    static abstract class Human {
    }

    static class Man extends Human {
    }

    static class Woman extends Human {
    }

    private void sayHello(Human guy) {
        System.out.println("hello,guy");
    }

    public void sayHello(Man guy) {
        System.out.println("hello,gentleman");
    }

    public void sayHello(Woman guy) {
        System.out.println("hello,lady");
    }

    public static void main(String[] args) {
        Human man = new Man();
//        new Man();
//        Human man;
        Human woman = new Woman();
        StaticDispatch sr = new StaticDispatch();
        man=new Woman();
        sr.sayHello(man);
        sr.sayHello((Woman) man);
//        sr.sayHello((Man) man);
        sr.sayHello(woman);
    }
}
