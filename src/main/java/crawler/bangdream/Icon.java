package crawler.bangdream;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

public class Icon {
    public static void main(String[] args) throws Exception {
        String url = "https://zh.moegirl.org/BanG_Dream!";
        Document document = Jsoup.connect(url)
                .userAgent("Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/61.0.3163.100 Safari/537.36")
                .get();
        Elements elements = document.select("table[class=nowraplinks navbox-subgroup]").select("img");
        for (Element uri : elements) {
            String link = uri.attr("src");
            String fileName = uri.attr("alt");
            File file = new File("C:\\Users\\chenchuanqi\\下载\\bang dream\\icon\\" + fileName);
            URL url1 = new URL(link);
            URLConnection connection = url1.openConnection();
            connection.setRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 5.0; Windows NT; DigExt)");
            connection.setConnectTimeout(10 * 1000);
            InputStream in = connection.getInputStream();
            BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(file));
            byte[] buf = new byte[1024];
            int size;
            while ((size = in.read(buf)) != -1) {
                out.write(buf, 0, size);
            }
            System.out.println(fileName + " 下载完成");
            out.close();
            in.close();
        }
    }
}

