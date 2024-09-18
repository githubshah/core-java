package learning.print_collection;

import java.util.*;

public class MapToString {

    public static void main(String[] args) {

        Map<String, Integer> map = new HashMap<>();
        map.put("a", 1);
        map.put("b", 2);

        System.out.println(map); // method 1
    }
}
