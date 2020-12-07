package core.collectiontest;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws ParseException {
        Set<Integer> integersA = new HashSet<>(Arrays.asList(1, 2));
        Set<Integer> integersB = new HashSet<>(Arrays.asList(3, 4));

        boolean disjoint = Collections.disjoint(integersA, integersB);

        System.out.println(integersA);
        System.out.println(disjoint);

        Date date1 = new SimpleDateFormat("yyyy-MM-dd").parse("2018-07-15");

        System.out.println(date1);
    }
}
