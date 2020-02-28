package MaxPath;

import javax.xml.bind.DatatypeConverter;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class MaxWeight {
    public static void main(String[] args) {

        Object dateString = "2019-10-17T07:57:25.750Z";

        Calendar calendar = DatatypeConverter.parseDateTime(dateString.toString());

        Date time = calendar.getTime();

        System.out.println(time);

    }

    enum Fruit {
        Mango,
        Apple
    }
}
