package collectiontest.hashmap.withHashCodeImpl;

import java.util.Objects;

public class Emp {
    String name;
    int rollNumber;

    public Emp(String name, int rollNumber) {
        this.name = name;
        this.rollNumber = rollNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Emp emp = (Emp) o;
        return rollNumber == emp.rollNumber &&
            name.equals(emp.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, rollNumber);
    }
}
