package learning.print_collection;

import java.util.*;

public class MapToString {

    public static void main(String[] args) {

        Map<String, Integer> map = new HashMap<>();
        map.put("a", 1);
        map.put("b", 2);

        List<Map<String, Integer>> maps = Arrays.asList(map);
        System.out.println(maps); // method 1
        System.out.println(Collections.singletonList(map)); // method 2
    }
}
