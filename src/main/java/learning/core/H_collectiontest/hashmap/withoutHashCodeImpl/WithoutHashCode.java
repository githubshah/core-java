package learning.core.H_collectiontest.hashmap.withoutHashCodeImpl;

import learning.core.H_collectiontest.hashmap.multiplekeyswithsameHashcode.Emp;

import java.util.HashMap;
import java.util.Map;

public class WithoutHashCode {
    public static void main(String[] args) {

        //m1();
        m2();
    }

    private static void m1() {
        learning.core.H_collectiontest.hashmap.multiplekeyswithsameHashcode.Emp abc = new learning.core.H_collectiontest.hashmap.multiplekeyswithsameHashcode.Emp("abc", 123);

        Map<learning.core.H_collectiontest.hashmap.multiplekeyswithsameHashcode.Emp, String> map = new HashMap<>();
        map.put(abc, "abc");
        map.put(abc, "xyz");

        System.out.println(map.size());
        System.out.println(map.get(abc));
    }

    private static void m2() {
        learning.core.H_collectiontest.hashmap.multiplekeyswithsameHashcode.Emp abc1 = new learning.core.H_collectiontest.hashmap.multiplekeyswithsameHashcode.Emp("abc", 123);
        learning.core.H_collectiontest.hashmap.multiplekeyswithsameHashcode.Emp abc2 = new learning.core.H_collectiontest.hashmap.multiplekeyswithsameHashcode.Emp("abc", 123);

        Map<Emp, String> map = new HashMap<>();
        map.put(abc1, "abc");
        map.put(abc2, "xyz");

        System.out.println(map.size());
    }
}
