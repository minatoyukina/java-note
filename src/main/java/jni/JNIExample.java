package jni;

public class JNIExample {

    static {
        System.loadLibrary("test");
    }

    public static native String getStringFromC();

    public static void main(String[] args) {
        System.out.println(System.getProperty("java.library.path"));
        System.out.println(JNIExample.getStringFromC());
    }
}
