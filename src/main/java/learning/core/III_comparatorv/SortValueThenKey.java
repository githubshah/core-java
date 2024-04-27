package learning.core.III_comparatorv;

import java.util.*;
import java.util.Map.Entry;

public class SortValueThenKey {

    public static void main(String[] args) {
        // Sample map
        Map<String, Integer> map = new HashMap<>();
        map.put("apple", 10);
        map.put("banana", 5);
        map.put("orange", 8);
        map.put("grape", 3);

        Comparator<Entry<String, Integer>> entryComparator = Entry.comparingByKey();
        // Sort the map by keys
        Map<String, Integer> sortedMap = map.entrySet().stream()
                .sorted(entryComparator)
                .collect(
                        LinkedHashMap::new, // Use LinkedHashMap to maintain insertion order
                        (newLinkedHashMap, originalMapObj) -> newLinkedHashMap.put(originalMapObj.getKey(), originalMapObj.getValue()),
                        LinkedHashMap::putAll
                );

        // Display the sorted map
        System.out.println("Sorted Map:");
        sortedMap.forEach((key, value) -> System.out.println(key + " : " + value));
    }
}
