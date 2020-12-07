package core.collectiontest.hashmap.withHashCodeImpl;

import java.util.HashMap;
import java.util.Map;

public class WitHashCode {
    public static void main(String[] args) {

        //m1();
        m2();
    }

    private static void m1() {
        Emp abc = new Emp("abc", 123);

        Map<Emp, String> map = new HashMap<>();
        map.put(abc,"abc");
        map.put(abc,"xyz");

        System.out.println(map.size());
        System.out.println(map.get(abc));
    }

    private static void m2() {
        Emp abc1 = new Emp("abc", 123);
        Emp abc2 = new Emp("abc", 123);

        Map<Emp, String> map = new HashMap<>();
        map.put(abc1,"abc");
        map.put(abc2,"xyz");

        System.out.println(map.size());
    }
}

