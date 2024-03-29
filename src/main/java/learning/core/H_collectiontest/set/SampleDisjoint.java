package learning.core.H_collectiontest.set;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class SampleDisjoint {
    public static void main(String[] args) throws ParseException {
        Set<Integer> integersA = new HashSet<>(Arrays.asList(1, 2));
        Set<Integer> integersB = new HashSet<>(Arrays.asList(3, 4));

        boolean disjoint = Collections.disjoint(integersA, integersB);

        System.out.println(integersA);
        System.out.println(disjoint);// true i.e. when not common element found

        Date date1 = new SimpleDateFormat("yyyy-MM-dd").parse("2018-07-15");

        System.out.println(date1);
    }
}
