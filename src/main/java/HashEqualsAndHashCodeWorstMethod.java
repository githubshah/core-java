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
    public int hashCode() {
        return 1;
    }

    @Override
    public boolean equals(Object obj) {
        return true;
    }
}

public class HashEqualsAndHashCodeWorstMethod {
    public static void main(String[] args) {
        Emp emp1 = new Emp("1", "1@gmail.com");
        Emp emp2 = new Emp("2", "2@gmail.com");

        Map<Emp, String> map = new HashMap<>();
        map.put(emp1, "v1");
        map.put(emp2, "v2");

        System.out.println("map size: " + map.size());
        System.out.println("value of emp1: " + map.get(emp1));
        System.out.println("value of emp2: " + map.get(emp2));


    }


}
