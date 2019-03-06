package concurrent.pipereadwrite;

import java.io.PipedReader;
import java.io.PipedWriter;

public class RunRW {
    public static void main(String[] args) throws Exception {
        WriteData writeData = new WriteData();
        ReadData readData = new ReadData();
        PipedReader inputStream = new PipedReader();
        PipedWriter outputStream = new PipedWriter();
        outputStream.connect(inputStream);
        ThreadRead threadRead = new ThreadRead(readData, inputStream);
        ThreadWrite threadWrite = new ThreadWrite(writeData, outputStream);
        threadRead.start();
        Thread.sleep(2000);
        threadWrite.start();
    }
}
