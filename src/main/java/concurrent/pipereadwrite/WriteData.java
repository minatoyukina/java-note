package concurrent.pipereadwrite;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.PipedWriter;

public class WriteData {
    private String title;
    private String text;

    public void write(PipedWriter output) {
        try {
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
                        title = ele.select("h1[class=article-title]").text();
                        text = ele.select("p").text();
//                        System.out.println(title);
//                        System.out.println(text);
                        output.write(title+"\n");
                        output.write(text);
                    }
                }
                output.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
