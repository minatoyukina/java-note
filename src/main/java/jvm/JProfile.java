package jvm;

public class JProfile  extends Thread{
    public static void main(String[] args) throws InterruptedException {
        for(int i=1; i<10000; i++) {
            new HelloWorld();
            sleep(100); // 休眠100毫秒
        }
    }
}

class HelloWorld {
    HelloWorld() {
        System.out.println("Hello JProfile!");
    }
}
