package learning.core.H_collectiontest.hashmap;

import java.util.HashMap;
import java.util.Map;

class Emp {
    private String id;
    private String email;

    public Emp(String id, String email) {
        this.id = id;
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {

//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        Emp emp = (Emp) o;
//        return Objects.equals(id, emp.id) && Objects.equals(email, emp.email);

        return true;
    }

    @Override
    public int hashCode() {
        //return Objects.hash(id, email);
        return 1;
    }

    @Override
    public String toString() {
        return "Emp{" +
                "id='" + id + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}

public class HashEqualsAndHashCodeWorstMethod {
    public static void main(String[] args) throws InterruptedException {
        Emp emp1 = new Emp("1", "1@gmail.com");
        Emp emp2 = new Emp("2", "2@gmail.com");
        Emp emp3 = new Emp("3", "3@gmail.com");

        Map<Emp, String> map = new HashMap<>();
        map.put(emp1, "v1");
        map.put(emp2, "v2");
        map.put(emp3, "v3");

        System.out.println("map size: " + map.size());
        map.forEach((k,v)->{System.out.println("k: " + k.toString()+", v: "+v);});

        // because emp1, emp2, emp3 pointed to single object in heap memory because of same hash code in Emp class.
        // but when you do map.get(emp2) then it picks it hashcode which is 1 and go to hash bucket and find 1 hashcode and return value
        System.out.println("map emp1: " + map.get(emp1));
        System.out.println("map emp2: " + map.get(emp2));
        System.out.println("map emp3: " + map.get(emp3));

    }


}
