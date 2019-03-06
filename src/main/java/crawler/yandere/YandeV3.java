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
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class YandeV3 {
    public static void main(String[] args) throws Exception {
        long start = System.currentTimeMillis();
        ExecutorService service=Executors.newFixedThreadPool(5);
        for (int i = 1; i < 2; i++) {
            String url = "https://yande.re/post?page=" + i + "&tags=hiten";
            Document doc = Jsoup.connect(url)
                    .userAgent("Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/61.0.3163.100 Safari/537.36")
                    .timeout(99999999)
                    .get();
            Elements elements = doc.select("ul[id=post-list-posts]").select("a[class=directlink largeimg]");
            for (Element element : elements) {
                String image = element.attr("href");
                service.execute(new Get_images("C:\\Users\\chenchuanqi\\下载\\hiten", image));
            }
        }
        service.shutdown();
        service.awaitTermination(1, TimeUnit.DAYS);
        long end = System.currentTimeMillis();
        System.out.printf("耗时：%d s",(end-start)/1000);
    }
}

class Get_images implements Runnable {
    private String filePath;
    private String imgUrl;

    Get_images(String filePath, String imgUrl) {
        this.filePath = filePath;
        this.imgUrl = imgUrl;
    }

    public void run() {
        try {
            String fileName = imgUrl.split("%20")[1] + imgUrl.substring(imgUrl.length() - 4);
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
            System.out.println(imgUrl.split("%20")[1]+" 下载完成 "+Thread.currentThread().getName());
            out.close();
            in.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
