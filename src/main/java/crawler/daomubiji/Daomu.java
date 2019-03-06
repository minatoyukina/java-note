package crawler.daomubiji;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Daomu {
    private static List<String> parse_url(String url) throws IOException {
        Document document = Jsoup.connect(url)
                .userAgent("Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/61.0.3163.100 Safari/537.36")
                .get();
        Elements elements = document.select("article[class=excerpt excerpt-c3]").select("a");
        List<String> list = new ArrayList<String>();
        for (Element element : elements)
            list.add(element.attr("href"));
        return list;
    }

    private static void parse_page(String url) throws Exception {
        for (int i = 0; i <parse_url(url).size(); i++) {
            String link = parse_url(url).get(i);
            Document document = Jsoup.connect(link)
                    .userAgent("Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/61.0.3163.100 Safari/537.36")
                    .get();
            Elements elements = document.select("div[class=content]");
            for (Element element : elements) {
                String title = element.select("h1[class=article-title]").text();
                String text = element.select("p").text();
//                Thread.sleep(2000);
                System.out.println(title);
                System.out.println(text);
                FileOutputStream fos=new FileOutputStream(new File("盗墓笔记.txt"),true);
                fos.write((title+"\n").getBytes());
                fos.write((text+"\n").getBytes());
                fos.close();
            }
        }
    }


    public static void main(String[] args) throws Exception {
        long startTime=System.currentTimeMillis();
        for (int i = 1; i < 9; i++) {
            String url = "http://www.crawler.daomubiji.com/dao-mu-bi-ji-" + i;
            parse_page(url);
        }
        long endTime=System.currentTimeMillis();
        System.out.println("耗时："+(endTime-startTime));
    }
}
