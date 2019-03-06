package jvm.thread;

import java.util.Vector;

public class VectorNotAbsoluteSafe {
    private static Vector<Integer> vector = new Vector<>();

    public static void main(String[] args) {
        while (true) {
            synchronized (vector) {
                for (int i = 0; i < 10; i++) {
                    vector.add(i);
                }
            }
            new Thread(() -> {
                synchronized (vector) {
                    for (int i = 0; i < vector.size(); i++) {
                        vector.remove(i);
                    }
                }
            }).start();
            new Thread(() -> {
                for (int i = 0; i < vector.size(); i++) {
                    System.out.println(vector.get(i));
                }
            }).start();
            while (Thread.activeCount() > 20) ;
        }
    }


}
