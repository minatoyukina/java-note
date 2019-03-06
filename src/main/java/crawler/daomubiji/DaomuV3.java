package crawler.daomubiji;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.FileOutputStream;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class DaomuV3 {

    public static void main(String[] args) throws Exception {
        long startTime=System.currentTimeMillis();
        ExecutorService service = Executors.newFixedThreadPool(5);
        for (int i = 1; i < 2; i++) {
            String url = "http://www.crawler.daomubiji.com/dao-mu-bi-ji-" + i;
            Document document = Jsoup.connect(url)
                    .userAgent("Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/61.0.3163.100 Safari/537.36")
                    .get();
            Elements elements = document.select("article[class=excerpt excerpt-c3]").select("a");
            for (Element uri : elements) {
                String link = uri.attr("href");
                document = Jsoup.connect(link).get();
                elements = document.select("div[class=content]");
                for (Element ele : elements) {
                    String title = ele.select("h1[class=article-title]").text();
                    String text = ele.select("p").text();
                    service.execute(new Write(title, text));
                }
            }
        }
        service.shutdown();
        long endTime=System.currentTimeMillis();
        System.out.println("耗时："+(endTime-startTime));
    }
}

class Write implements Runnable {
    private String title;
    private String text;

    public Write(String title, String text) {
        this.title = title;
        this.text = text;
    }

    public void run() {
        try {
            FileOutputStream fos = new FileOutputStream(new File("盗墓笔记V2.txt"), true);
            fos.write((title + "\n").getBytes());
            fos.write((text + "\n").getBytes());
            System.out.println(title+" 下载完成 "+Thread.currentThread().getName());
            fos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}