package crawler.yandere;

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

public class Yande extends Thread {
    public static void get_html(String url) {
        try {
            Document doc = Jsoup.connect(url)
                    .userAgent("Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/61.0.3163.100 Safari/537.36")
                    .timeout(99999999)
                    .get();
            Elements elements = doc.select("ul[id=post-list-posts]").select("a[class=directlink largeimg]");
            for (Element element : elements) {
                String image = element.attr("href");
                get_images("C:\\Users\\chenchuanqi\\下载\\img", image);
                System.out.println(image + "  ------->下载完成 " + Thread.currentThread().getName());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void get_images(String filePath, String imgUrl) throws Exception {
        File dir = new File(filePath);
        if (!dir.exists()) {
            dir.mkdirs();
        }

        String fileName = imgUrl.split("%")[1] + ".jpg";
        File file = new File(filePath + File.separator + fileName);
        URL url = new URL(imgUrl);
        URLConnection connection = url.openConnection();
        connection.setConnectTimeout(10 * 1000);
        InputStream in = connection.getInputStream();
        BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(file));
        byte[] buf = new byte[1024];
        int size;
        while ((size = in.read(buf)) != -1) {
            out.write(buf, 0, size);
        }
        out.close();
        in.close();
    }

    @Override
    public void run() {
        for (int i = 1; i < 12; i++) {
            String url = "https://yande.re/post?page=" + i + "&tags=ssss.gridman";
            get_html(url);
        }
    }
}
