package core.collectiontest.hashmap.withHashCodeImpl;

import java.util.HashMap;
import java.util.Map;

public class WitHashCode {
    public static void main(String[] args) {

  //      m1();
//        m2();
        m3();
    }

    private static void m1() {
        Emp abc = new Emp("abc", 123);

        Map<Emp, String> map = new HashMap<>();
        map.put(abc, "abc");
        map.put(abc, "xyz");

        System.out.println(map.size());
        System.out.println(map.get(abc));
    }

    private static void m2() {
        Emp abc1 = new Emp("abc", 123);
        Emp abc2 = new Emp("abc", 123);

        Map<Emp, String> map = new HashMap<>();
        map.put(abc1, "abc");
        map.put(abc2, "xyz");

        System.out.println(map.size());
    }

    private static void m3() {
        Emp abc1 = new Emp("abc", 10);
        Emp abc2 = new Emp("def", 10);

        Map<Emp, String> map = new HashMap<>();
        map.put(abc1, "value of abc1");
        map.put(abc2, "value of abc2");

        System.out.println("size of map: " + map.size());
        iterateMap(map);

        System.out.println("make same hash code");
        abc2.setName("abc");
        iterateMap(map);

        System.out.println("Get value on same hash key abc1:>>> "+map.get(abc1));
        System.out.println("Get value on same hash key abc2:>>> "+map.get(abc2));
        System.out.println("Finally size of the map is : "+map.size());
        HashMap<Emp, String> empStringHashMap = new HashMap<>(map);
        System.out.println("Finally size of the map is : "+empStringHashMap.size());

        System.exit(0);
    }

    private static void iterateMap(Map<Emp, String> map) {
        map.forEach((key, value) -> {
            System.out.println("hascode: " + key.hashCode() + " ,key: {" + key.getName()+":"+key.rollNumber + "} ,value: " + value);
        });
    }
}

