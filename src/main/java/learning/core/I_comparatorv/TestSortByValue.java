package learning.core.I_comparatorv;

import java.util.*;
import java.util.Map.Entry;

public class TestSortByValue {

    public static void main(String[] args) {
        Map<String, String> map = new LinkedHashMap<>();

        map.put("C", "AA");
        map.put("B", "AB");
        map.put("A", "AC");

        Set<Entry<String, String>> entries = map.entrySet();

        List<Entry<String, String>> list = new ArrayList<>(entries);

        list.sort(Entry.<String, String>comparingByValue().thenComparing(Entry::getKey));

        map.clear();

        list.forEach(x -> map.put(x.getKey(), x.getValue()));

        System.out.println(map);
    }
}
