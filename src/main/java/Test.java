import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class Test {

    public static void main(String[] args) throws Exception {
        RandomAccessFile file = new RandomAccessFile("text.txt", "rw");

        file.write("hello world scala".getBytes());
        file.seek(0);
        System.out.println(file.readLine());

        file.seek(0);
        FileChannel channel = file.getChannel();
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        System.out.println(buffer);
        channel.read(buffer);
        System.out.println(buffer);
        buffer.flip();
        System.out.println(buffer);
        while (buffer.hasRemaining())
            System.out.print((char) buffer.get());
        System.out.println();
        buffer.flip();
        System.out.println(buffer);
        while (buffer.hasRemaining())
            System.out.print((char) buffer.get());
        System.out.println();


    }


}



