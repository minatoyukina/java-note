package concurrent.pipereadwrite;

import java.io.PipedReader;

public class ReadData {
    public void read(PipedReader input) {
        try {
            char[] chars=new char[2048];
            int readLength=input.read(chars);
            while (readLength!=-1){
                String newData=new String(chars,0,readLength);
                System.out.println(newData);
                readLength=input.read(chars);
            }
            input.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
