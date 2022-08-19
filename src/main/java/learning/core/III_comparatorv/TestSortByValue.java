package learning.core.III_comparatorv;

import java.util.*;
import java.util.Map.Entry;

public class TestSortByValue {

    public static void main(String[] args) {
        Map<String, String> map = new LinkedHashMap<>();

        map.put("AC", "AA");
        map.put("ZB", "AB");
        map.put("CC", "AB");
        map.put("CB", "BC");
        map.put("CA", "BC");

        Set<Entry<String, String>> entries = map.entrySet();

        List<Entry<String, String>> list = new ArrayList<>(entries);


        Comparator<Entry<String, String>> entryComparator =
                Entry.<String, String>comparingByValue().thenComparing(Entry::getKey);

        list.sort((o1, o2) -> {
            int i1 = o1.getKey().compareTo(o2.getKey());
            int i2 = o1.getValue().compareTo(o2.getValue());
            return i2 != 0 ? i2 : i1;
        });

        map.clear();

        list.forEach(x -> map.put(x.getKey(), x.getValue()));

        System.out.println(map);
    }
}
