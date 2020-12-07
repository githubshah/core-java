package core.collectiontest.hashmap.withoutHashCodeImpl;

import core.collectiontest.hashmap.withHashCodeImpl.Emp;

import java.util.HashMap;
import java.util.Map;

public class WithoutHashCode {
    public static void main(String[] args) {

        //m1();
        m2();
    }

    private static void m1() {
        core.collectiontest.hashmap.withHashCodeImpl.Emp abc = new core.collectiontest.hashmap.withHashCodeImpl.Emp("abc", 123);

        Map<core.collectiontest.hashmap.withHashCodeImpl.Emp, String> map = new HashMap<>();
        map.put(abc,"abc");
        map.put(abc,"xyz");

        System.out.println(map.size());
        System.out.println(map.get(abc));
    }

    private static void m2() {
        core.collectiontest.hashmap.withHashCodeImpl.Emp abc1 = new core.collectiontest.hashmap.withHashCodeImpl.Emp("abc", 123);
        core.collectiontest.hashmap.withHashCodeImpl.Emp abc2 = new core.collectiontest.hashmap.withHashCodeImpl.Emp("abc", 123);

        Map<Emp, String> map = new HashMap<>();
        map.put(abc1,"abc");
        map.put(abc2,"xyz");

        System.out.println(map.size());
    }
}
