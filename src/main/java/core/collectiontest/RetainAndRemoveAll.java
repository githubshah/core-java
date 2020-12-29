package core.collectiontest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RetainAndRemoveAll {
    public static void main(String[] args) {
        List<String> a1 = new ArrayList<>(Arrays.asList("1", "2", "3", "4", "5", "10"));
        List<String> a2 = new ArrayList<>(Arrays.asList("4", "5", "6", "7", "8"));

        //a1.removeAll(a2); // 1,2,3, 10
        a1.retainAll(a2); // 4, 5   i.e common element between both arrays
        System.out.println(a1);
    }
}
