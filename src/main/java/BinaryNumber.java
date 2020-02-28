import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class BinaryNumber {
    public static void main(String[] args) {

        List<Integer> integers = Arrays.asList(1, 2, 3);
        Stream<Integer> integerStream = Stream.of(1, 2, 3);
        IntStream intStream = IntStream.of(1, 2, 3);


        Map<String, Integer> m = new HashMap();
        m.put("A", 1);
        m.put("B", 2);

        m.forEach((k, v) -> System.out.println(k + " , " + v));

        Set<Map.Entry<String, Integer>> entries = m.entrySet();

        entries.forEach(k -> {
            k.getKey();
            k.getValue();
        });


    }
}
