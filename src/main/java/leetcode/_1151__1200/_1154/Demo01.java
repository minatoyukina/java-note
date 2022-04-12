package leetcode._1151__1200._1154;

import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Demo01 {


    @Test
    public void test() {
        System.out.println(dayOfYear("2019-02-10"));
    }

    public int dayOfYear(String date) {
        try {
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            long t2 = format.parse(date).getTime();
            long t1 = format.parse(date.substring(0, 5) + "01-01").getTime();
            return 1 + (int) ((t2 - t1) / (1000 * 60 * 60 * 24));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return 0;
    }

}