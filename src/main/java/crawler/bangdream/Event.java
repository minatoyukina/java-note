package crawler.bangdream;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;

public class Event {


    public static void main(String[] args) {

        try {
            Document document = Jsoup.connect("https://bandori.party/events/")
                    .userAgent("Mozilla/5.0 (Linux; Android 6.0; Nexus 5 Build/MRA58N) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/61.0.3163.100 Mobile Safari/537.36")
                    .get();
            String url = document.select("div[class=row items]").select("a").attr("href");
            System.out.println(url);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
