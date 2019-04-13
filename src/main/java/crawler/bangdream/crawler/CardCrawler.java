package crawler.bangdream.crawler;

import crawler.bangdream.pojo.Card;
import crawler.bangdream.pojo.Panel;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class CardCrawler {
    public static void main(String[] args) throws Exception {
        for (int i = 1092; i < 1097; i++) {
            int temp = Integer.parseInt(Math.round(Math.random() * (UserAgent.length - 1)) + "");
            String url = "https://bandori.party/card/" + i;
            Document document = Jsoup.connect(url)
                    .userAgent(UserAgent[temp])
                    .ignoreHttpErrors(true)
                    .get();
            Elements elements = document.select("div[class=card-info]");
            for (Element ele : elements) {
                Panel panel = new Panel();
                panel.setNumber(i);
                panel.setPerformance(Integer.parseInt(ele.select("div[class=tab-pane]").last().select("div[class=row]").eq(0).select("div").eq(2).text()));
                panel.setTechnique(Integer.parseInt(ele.select("div[class=tab-pane]").last().select("div[class=row]").eq(1).select("div").eq(2).text()));
                panel.setVisual(Integer.parseInt(ele.select("div[class=tab-pane]").last().select("div[class=row]").eq(2).select("div").eq(2).text()));
                panel.setOverall(Integer.parseInt(ele.select("div[class=tab-pane]").last().select("div[class=row]").eq(3).select("div").eq(2).text()));
                Card card = new Card();
                card.setNumber(i);
                card.setPanel(panel);
                card.setMember(ele.select("tr[data-field=member]").select("span").eq(1).text().replace("Open member", "").trim());
                card.setTitle(ele.select("tr[data-field=card_name]").select("p").text());
                card.setRarity(ele.select("tr[data-field=rarity]").select("td").last().children().size());
                card.setAttribute(ele.select("tr[data-field=attribute]").select("td").last().text());
                card.setSkill(ele.select("tr[data-field=skill_type]").select("p").text());
                card.setIcon(ele.select("tr[data-field=images]").select("a").eq(0).attr("href").replace("//", ""));
                card.setIcon_trained(ele.select("tr[data-field=images]").select("a").eq(1).attr("href").replace("//", ""));
                System.out.println(card);
                Thread.sleep((long) (Math.random() * 3000 + 3000));

                String urlName = "jdbc:mysql://localhost:3306/bang_dream?serverTimezone=GMT%2B8&useSSL=false";
                String user = "root";
                String password = "123456";
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection connection = DriverManager.getConnection(urlName, user, password);
                PreparedStatement statement = connection.prepareStatement("insert into card(number,member,title,rarity,attribute,skill,Icon,Icon_trained) values(?,?,?,?,?,?,?,?)");
                statement.setInt(1, card.getNumber());
                statement.setString(2, card.getMember());
                statement.setString(3, card.getTitle());
                statement.setInt(4, card.getRarity());
                statement.setString(5, card.getAttribute());
                statement.setString(6, card.getSkill());
                statement.setString(7, card.getIcon());
                statement.setString(8, card.getIcon_trained());
                PreparedStatement statement1 = connection.prepareStatement("insert into panel(Number,Performance,Technique,Visual,Overall) values(?,?,?,?,?)");
                statement1.setInt(1, panel.getNumber());
                statement1.setInt(2, panel.getPerformance());
                statement1.setInt(3, panel.getTechnique());
                statement1.setInt(4, panel.getVisual());
                statement1.setInt(5, panel.getOverall());
                statement.execute();
                statement1.execute();
            }
        }
    }

    private static String[] UserAgent = {
            "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.13 (KHTML, like Gecko) Chrome/24.0.1290.1 Safari/537.13",
            "Mozilla/5.0 (Windows NT 6.1; WOW64; rv:17.0) Gecko/20100101 Firefox/17.0",
            "Mozilla/5.0 (compatible; MSIE 9.0; Windows NT 6.1; WOW64; Trident/5.0; LBBROWSER)",
            "Mozilla/5.0 (compatible; MSIE 9.0; Windows NT 6.1; WOW64; Trident/5.0)",
            "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/535.12 (KHTML, like Gecko) Maxthon/3.0 Chrome/18.0.966.0 Safari/535.12",
            "Mozilla/4.0 (compatible; MSIE 7.0; Windows NT 6.1; WOW64; Trident/5.0; SLCC2; .NET CLR 2.0.50727; .NET CLR 3.5.30729; .NET CLR 3.0.30729; Media Center PC 6.0; .NET4.0C; .NET4.0E)",
            "Opera/9.80 (Windows NT 6.1; WOW64) Presto/2.12.388 Version/12.12",
            "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 6.1; WOW64; SLCC2; .NET CLR 2.0.50727; .NET CLR 3.5.30729; .NET CLR 3.0.30729; Media Center PC 6.0; .NET4.0C; .NET4.0E)",
            "Mozilla/4.0 (compatible; MSIE 7.0; Windows NT 6.1; WOW64; Trident/4.0; SLCC2; .NET CLR 2.0.50727; .NET CLR 3.5.30729; .NET CLR 3.0.30729; Media Center PC 6.0; .NET4.0C; .NET4.0E)",
            "Mozilla/4.0 (compatible; MSIE 7.0; Windows NT 6.1; WOW64; Trident/5.0; SLCC2; .NET CLR 2.0.50727; .NET CLR 3.5.30729; .NET CLR 3.0.30729; Media Center PC 6.0; .NET4.0C; .NET4.0E)",
            "Mozilla/5.0 (compatible; MSIE 9.0; Windows NT 6.1; WOW64; Trident/5.0; qihu theworld)",
            "Mozilla/5.0 (compatible; MSIE 9.0; Windows NT 6.1; WOW64; Trident/5.0; QQBrowser/7.0.4350.400)",
            "Mozilla/5.0 (Macintosh; U; Intel Mac OS X 10_6_8; en-us) AppleWebKit/534.57.2 (KHTML, like Gecko) Version/5.1.6 Safari/534.57.2"
    };
}
