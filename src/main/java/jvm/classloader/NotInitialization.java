package jvm.classloader;

class SuperClass {
    static {
        System.out.println("superClass inIt!");
    }

    static int value = 123;
}

class SubClass extends SuperClass {
    static {
        System.out.println("subClass init!");
    }
}

class ConstClass {
    static {
        System.out.println("superClass inIt!");
    }

    public static final String HELLO_WORLD = "hello world";
}

public class NotInitialization {
    public static void main(String[] args) {
        System.out.println(SubClass.value);
        SuperClass[] classes = new SuperClass[10];
        System.out.println(classes);

        System.out.println(ConstClass.HELLO_WORLD);
    }
}
