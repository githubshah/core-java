package learning.core.comparatorv;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.ToIntFunction;

class ValueThenKeyComparator<K extends Comparable<? super K>, V extends Comparable<? super V>>
    implements Comparator<Map.Entry<K, V>> {
    @Override
    public int compare(Map.Entry<K, V> a, Map.Entry<K, V> b) {
        int diff = b.getValue().compareTo(a.getValue());
        return diff != 0 ? diff : b.getKey().compareTo(a.getKey());
    }
}

class ValueThenKeyComparator1 implements Comparator<Map.Entry<String, Integer>> {
    @Override
    public int compare(Map.Entry<String, Integer> a, Map.Entry<String, Integer> b) {
        int diff = b.getValue().compareTo(a.getValue());
        return diff != 0 ? diff : b.getKey().compareTo(a.getKey());
    }
}

public class Sorting {
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        map.put("a1", 1);
        map.put("1", 10);
        map.put("a", 10);
        map.put("z", 10);
        map.put("a5", 2);
        map.put("a2", 8);

        List<Map.Entry<String, Integer>> list = new ArrayList<>(map.entrySet());
        sorts(list);
        list.forEach(System.out::println);

        Map.Entry<String, Integer> first = list.get(0);
        System.out.println(first.getKey() + ":" + first.getValue());
    }

    private static void sorts(List<Map.Entry<String, Integer>> list) {
        //list.sort(new ValueThenKeyComparator1());

        list.sort((o1, o2) -> {
            int diff = o1.getValue().compareTo(o2.getValue());
            return diff == 0 ? o1.getKey().compareTo(o2.getKey()) : diff;
        });

//        list.sort(
//            Comparator.comparingInt((ToIntFunction<Map.Entry<String, Integer>>) Map.Entry::getValue)
//                .thenComparing(Map.Entry::getKey));
    }

    private static void sop(Map<? extends Number, ?> map) {
        map.forEach((x, y) -> System.out.println(x + ":" + y));
    }
}
