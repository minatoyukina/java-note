package data_structure;

import java.io.File;

public class Dir {
    private static void listAll(File file) {
        if (file.isDirectory()) {
            File[] files = file.listFiles();
            assert files != null;
            for (File child : files) {
                listAll(child);
                System.out.println(child);
            }
        } else
            System.out.println(file);
    }



    public static void main(String[] args) {
        File file = new File("D:\\Office\\NT");
        listAll(file);
    }
}
