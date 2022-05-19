package learning;

import java.util.HashMap;
import java.util.Map;

public class WeekHashMapDemo {
    public static void main(String[] args) throws InterruptedException {
        String emp1 = new String("1");
        String emp2 = new String("2");
        String emp3 = new String("3");

        Map<String, String> map = new HashMap<>();
        //Map<String, String> map = new WeakHashMap<>();
        map.put(emp1, "v1");
        map.put(emp2, "v2");
        map.put(emp3, "v3");

        System.out.println("map size: " + map.size());
        map.forEach((k, v) -> {
            System.out.println("k: " + k.toString() + ", v: " + v);
        });

        emp1 = null;
        emp2 = null;
        System.gc();

        Thread.sleep(1000);

        System.out.println("\nmap size: " + map.size());
        map.forEach((k, v) -> {
            System.out.println("k: " + k.toString() + ", v: " + v);
        });

    }


}
