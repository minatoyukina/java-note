package netty.netty.serialize;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.nio.ByteBuffer;

public class UserInfoTest {
    public static void main(String[] args) throws IOException {
        UserInfo info = new UserInfo();
        info.buildUserID(100).buildUserName("Welcome to Netty");
        int loop = 100_0000;
//        ByteArrayOutputStream bos = new ByteArrayOutputStream();
//        ObjectOutputStream os = new ObjectOutputStream(bos);
        ByteArrayOutputStream bos;
        ObjectOutputStream os;
        long start = System.currentTimeMillis();
        for (int i = 0; i < loop; i++) {
            bos = new ByteArrayOutputStream();
            os = new ObjectOutputStream(bos);
            os.writeObject(info);
            os.flush();
            os.close();
            bos.toByteArray();
            bos.close();
        }
        long end = System.currentTimeMillis();
//        os.writeObject(info);
//        os.flush();
//        os.close();
//        byte[] b = bos.toByteArray();
//        System.out.println("The jdk serializable length is: " + b.length);
//        bos.close();
        System.out.println("The jdk serializable cost: " + (end - start));
        System.out.println("--------------");
//        System.out.println("The byte array serializable length is: " + info.codeC().length);
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        long start1 = System.currentTimeMillis();
        for (int i = 0; i < loop; i++) {
            info.codeC(buffer);
        }
        long end1 = System.currentTimeMillis();
        System.out.println("The byte array serializable cost: " + (end1 - start1));
    }
}
