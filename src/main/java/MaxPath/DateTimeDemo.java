package MaxPath;

import javax.xml.bind.DatatypeConverter;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class DateTimeDemo {
    public static void main(String[] args) {

        Object dateString = "2019-10-17T07:57:25.750Z";

        Calendar calendar = DatatypeConverter.parseDateTime(dateString.toString());

        Date time = calendar.getTime();

        System.out.println(time);

        LocalDate date = LocalDate.parse("2018-05-05");
        LocalDateTime dateTime = LocalDateTime.parse("2018-05-05T11:50:55");

        String dateInString = "Mon, 05 May 1980";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("EEE, d MMM yyyy", Locale.ENGLISH);
        LocalDate dateTime1 = LocalDate.parse(dateInString, formatter);

    }

    enum Fruit {
        Mango,
        Apple
    }
}
