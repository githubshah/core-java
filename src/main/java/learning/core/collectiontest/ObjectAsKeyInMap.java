package learning.core.collectiontest;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

// referesnced change never make impact alrady puted object
// setter change make impact already puted object


class Student {
    int id;
    String name;

    public Student(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student{" + "id=" + id + ", name='" + name + '\'' + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return id == student.id &&
                Objects.equals(name, student.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}

public class ObjectAsKeyInMap {
    public static void main(String[] args) {

        Map<Student, String> map = new HashMap<>();
        map.put(new Student(1, "Apple"), "student1");
        Student student2 = new Student(2, "Mango");
        map.put(student2, "student2");

        student2.setName("Banana");

        System.out.println("--------------update key after object put in map-----------------");

        map.forEach(
                (x, y) -> {
                    System.out.println("x:" + x + " , y:" + y + " >> hashCode: " + "x:" + x.hashCode());
                });

        System.out.println("\n--------------common after object put in map-----------------");

        student2.setId(1);
        student2.setName("Apple");

        map.forEach(
                (x, y) -> {
                    System.out.println("x:" + x + " , y:" + y + " >> hashCode: " + "x:" + x.hashCode());
                });

        System.out.println("-------------------------------");

        String a1 = new String("abc");
        Map<String, String> map1 = new HashMap<>();
        map1.put(a1, "A1");
        a1 = null;  // does not change value in existing key
        map1.forEach(
                (x, y) -> {
                    System.out.println("x:" + x + " , y:" + y);
                });
    }
}
