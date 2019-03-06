import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashSet;
import java.util.Set;

public class Test {
    public static void main(String[] args) throws Exception{
        Set<Integer> set=new HashSet<>();
        for (int i=1;i<166;i++) {
            String format = String.format("%03d", i);
            URL url=new URL("http://www.sdvx.in/bandri/obj/data"+format+"ex.png");
            URLConnection connection = url.openConnection();
            InputStream inputStream = connection.getInputStream();
            BufferedImage read = ImageIO.read(inputStream);
            int width = read.getWidth();
            set.add(width);
        }
        System.out.println(set);
        set.stream().sorted((x,y)->y-x).forEach((i)->System.out.print(i+" "));
    }
}



