package oop.sub;

class InnerClass {
    static class StaticInner {
        private int age;

        void test() {

        }

        static void test1() {

        }
    }

    class Inner {
        private int age;

        void test() {
        }

//        private static void test1(){}

    }

    private void test() {
        Inner inner = new Inner();
        inner.test();
        StaticInner staticInner = new StaticInner();
        staticInner.test();
        StaticInner.test1();
    }

    public static void main(String[] args) {
        StaticInner staticInner = new StaticInner();
        staticInner.age = 4;
        InnerClass.Inner inner = new InnerClass().new Inner();
        inner.age = 4;
    }
}

class Test {
    public static void main(String[] args) {
        InnerClass.StaticInner.test1();
        InnerClass.StaticInner staticInner = new InnerClass.StaticInner();
        staticInner.test();
        InnerClass.Inner inner = new InnerClass().new Inner();
        inner.test();
    }
}


