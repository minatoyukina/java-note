package effective_java;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class PersonKai {
    private final Date birthDate;
    private static final Date BOOM_START;
    private static final Date BOOM_END;


    public PersonKai(Date birthDate) {
        this.birthDate = birthDate;
    }

    static {
        Calendar gmtCal = Calendar.getInstance(TimeZone.getTimeZone("GMT"));
        gmtCal.set(1946, Calendar.JANUARY, 1, 0, 0, 0);
        BOOM_START = gmtCal.getTime();
        gmtCal.set(1965, Calendar.JANUARY, 1, 0, 0, 0);
        BOOM_END = gmtCal.getTime();
    }

    public boolean isBabyBoomer() {
        return birthDate.compareTo(BOOM_START) >= 0 && birthDate.compareTo(BOOM_END) < 0;
    }

    public static void main(String[] args) throws ParseException {
        DateFormat format=new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date parse = format.parse("1964/08/13 13:22:13");
        PersonKai person = new PersonKai(parse);
        System.out.println(person.isBabyBoomer());
    }
}
