package crawler.yandere;

public class Main {
    public static void main(String[] args) {
        Yande yande=new Yande();
        Thread t1=new Thread(yande);
        Thread t2=new Thread(yande);
        Thread t3=new Thread(yande);
        Thread t4=new Thread(yande);
        Thread t5=new Thread(yande);
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();

    }
}
