package learning.core.H_collectiontest.nullAccept;

import java.util.*;

enum Color {
    RED, GREEN;
}

public class NullAccept {
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        map.put(null, "shaid");
        map.put(null, "hussain");
        System.out.println(map);


        Set<String> set1 = new HashSet<>();
        set1.add(null);
        set1.add(null);
        System.out.println(set1);

        List<String> list = new ArrayList<>();
        list.add(null);
        list.add(null);
        System.out.println(list);

        EnumSet<Color> games = EnumSet.allOf(Color.class);

        // Printing EnumSet elements to the console
        System.out.println("EnumSet: " + games);

    }
}
