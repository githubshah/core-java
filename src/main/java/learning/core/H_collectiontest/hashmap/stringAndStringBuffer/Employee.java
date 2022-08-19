package learning.core.H_collectiontest.hashmap.stringAndStringBuffer;

import java.util.Objects;

public class Employee {
    String string;

    public Employee(String string) {
        this.string = string;
    }

    public String getString() {
        return string;
    }

    public void setString(String string) {
        this.string = string;
    }

    @Override
    public String toString() {
        return "StringMap{" +
                "string='" + string + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Objects.equals(string, employee.string);
    }

    @Override
    public int hashCode() {
        return Objects.hash(string);
    }
}
