package crawler.daomubiji;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Test {

    public static void main(String[] args) throws Exception {
        ExecutorService service = Executors.newFixedThreadPool(5);
        for (int i = 1; i < 9; i++) {
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
                    service.execute(new Write1(ele));
                }
            }
        }
        service.shutdown();
    }
}

class Write1 implements Runnable {
    private Element element;

    public Write1(Element element) {
        this.element = element;
    }

    public void run() {
        try {
            String title = element.select("h1[class=article-title]").text();
            String text = element.select("p").text();
            System.out.println(title + Thread.currentThread().getName());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
