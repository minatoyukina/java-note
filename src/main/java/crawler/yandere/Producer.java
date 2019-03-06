package crawler.yandere;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.concurrent.BlockingQueue;

public class Producer extends Thread {
    private BlockingQueue queue;

    public Producer(BlockingQueue queue) {
        this.queue = queue;
    }



    public void run() {
        while (true) {
            try {
                for (int i = 1; i < 2; i++) {
                    String url = "https://yande.re/post?page=" + i + "&tags=ssss.gridman";
                    Document doc = Jsoup.connect(url)
                            .userAgent("Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/61.0.3163.100 Safari/537.36")
                            .timeout(99999999)
                            .get();
                    Elements elements = doc.select("ul[id=post-list-posts]").select("a[class=directlink largeimg]");
                    for (Element element : elements) {
                        String image = element.attr("href");
                        queue.put(image);
                        System.out.println(image.split("%")[1] + " 进入队列 " + Thread.currentThread().getName());
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            break;
        }
    }
}
