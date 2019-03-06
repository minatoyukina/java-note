package jvm.classloader;

import com.sun.xml.internal.messaging.saaj.util.ByteOutputStream;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class MyClassLoader extends ClassLoader {
    private String rootDir;

    static {
        System.out.println("MyClassLoader");
    }

    private MyClassLoader(String rootDir) {
        this.rootDir = rootDir;
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        Class<?> c = findLoadedClass(name);
        ClassLoader parent = this.getParent();
        try {
            c = parent.loadClass(name);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        if (c != null)
            return c;
        else
            try {
                byte[] classData = getClassData(name);
                if (classData == null)
                    throw new ClassNotFoundException();
                else {
                    c = defineClass(name, classData, 0, classData.length);
                    return c;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        return null;
    }

    private byte[] getClassData(String className) throws IOException {
        String path = rootDir + "/" + className.replace('.', '/') + ".class";
        InputStream inputStream = null;
        ByteOutputStream outputStream = new ByteOutputStream();
        try {
            inputStream = new FileInputStream(path);
            byte[] buffer = new byte[1024];
            int temp;
            while ((temp = inputStream.read(buffer)) != -1)
                outputStream.write(buffer, 0, temp);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (inputStream != null)
                inputStream.close();
            outputStream.close();
        }
        return null;
    }

    public static void main(String[] args) throws ClassNotFoundException {
        ClassLoader classLoader = MyClassLoader.class.getClassLoader();
        while (classLoader!= null) {
            System.out.println(classLoader);
            classLoader = classLoader.getParent();
        }
        System.out.println("------");

        MyClassLoader loader1 = new MyClassLoader("C:/Users/chenchuanqi/桌面");
        MyClassLoader loader2 = new MyClassLoader("C:/Users/chenchuanqi/桌面");
        Class<?> c1 = loader1.loadClass("Test");
        Class<?> c2 = loader1.loadClass("Test");
        Class<?> c3 = loader2.loadClass("Test");

        Class<?> cString = loader2.loadClass("java.lang.Integer");
        Class<?> cMyClassLoaderTest = loader2.loadClass("jvm.classloader.MyClassLoader");
        System.out.println(c1.hashCode() + "##:classLoader" + c1.getClassLoader());
        System.out.println(c2.hashCode());
        System.out.println(c3.hashCode());
        System.out.println(cString.hashCode() + " cString##:classLoader " + c1.getClassLoader());
        System.out.println(cMyClassLoaderTest.hashCode() + " cMyClassLoaderTest##:classLoader " + cMyClassLoaderTest.getClassLoader());
    }
}
