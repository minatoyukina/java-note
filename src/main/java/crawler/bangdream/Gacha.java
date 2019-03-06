package crawler.bangdream;

import crawler.bangdream.pojo.Card;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.List;
import java.util.Random;

public class Gacha {
    public static void main(String[] args) throws Exception {
        Random random = new Random();
        String urlName = "jdbc:mysql://localhost:3306/bang_dream?serverTimezone=GMT%2B8&useSSL=false";
        String user = "root";
        String password = "123456";
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection = DriverManager.getConnection(urlName, user, password);
        for (int i = 0; i < 9; i++) {
            int nextInt = random.nextInt(200);
            if (nextInt < 6) {
                QueryRunner runner = new QueryRunner();
                String sql = "select * FROM card where card.rarity=4";
                List<Card> query = runner.query(connection, sql, new BeanListHandler<>(Card.class));
                int index = (int) (Math.random() * query.size());
                System.out.println(query.get(index));
            } else if (nextInt < 24) {
                QueryRunner runner = new QueryRunner();
                String sql = "select * FROM card where card.rarity=3";
                List<Card> query = runner.query(connection, sql, new BeanListHandler<>(Card.class));
                int index = (int) (Math.random() * query.size());
                System.out.println(query.get(index));
            } else {
                QueryRunner runner = new QueryRunner();
                String sql = "select * FROM card where card.rarity=2";
                List<Card> query = runner.query(connection, sql, new BeanListHandler<>(Card.class));
                int index = (int) (Math.random() * query.size());
                System.out.println(query.get(index));
            }
        }
        QueryRunner runner = new QueryRunner();
        String sql = "select * FROM card where card.rarity=3 or card.rarity=4";
        List<Card> query = runner.query(connection, sql, new BeanListHandler<>(Card.class));
        int index = (int) (Math.random() * query.size());
        System.out.println(query.get(index));
    }
}
