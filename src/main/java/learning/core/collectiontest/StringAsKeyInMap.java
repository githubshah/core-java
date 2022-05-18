package learning.core.collectiontest;

import java.util.HashMap;
import java.util.Map;

public class StringAsKeyInMap {
    public static void main(String as[]) {
        Employee employee = new Employee("abc");
        Map<Employee, String> hashMap = new HashMap<>();
        hashMap.put(employee, "A1");
        //str1 = null;  // does not change value in existing key
        employee.setString("xyz");
        hashMap.forEach(
                (x, y) ->
                {
                    System.out.println("x:" + x + " , y:" + y);
                });

        System.out.println("----------String Buffer/builder  does not override equals method-----------------");

        {
            Map<StringBuffer, Integer> map2 = new HashMap<>();
            map2.put(new StringBuffer("firstSecond"), 1);
            map2.put(new StringBuffer("firstSecond"), 2);

            map2.forEach(
                    (x, y) ->
                    {
                        System.out.println("x:" + x + " , y:" + y);
                    });
        }

        System.out.println("-------------String-------------------");

        {
            Map<String, Integer> map2 = new HashMap<>();
            map2.put(new String("firstSecond"), 1);
            map2.put(new String("firstSecond"), 2);

            map2.forEach(
                    (x, y) ->
                    {
                        System.out.println("x:" + x + " , y:" + y);
                    });
        }
    }
}
