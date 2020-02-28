package collectiontest;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

class Student {
  int id;

  public void setName(String name) {
    this.name = name;
  }

  String name;

  public Student(int id, String name) {
    this.id = id;
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

public class MapTest {
  public static void main(String[] args) {

    String A = "A";
    Student a = new Student(1, "Apple");

    Map<Student, String> map = new HashMap<>();
    map.put(a, "A1");
    map.put(new Student(2, "Mango"), "A3");

    a.setName("ValueSettoshaid");

    map.forEach(
        (x, y) -> {
          System.out.println("x:" + x + " , y:" + y);
        });

    System.out.println("-------------------------------");

    String a1 = new String("abc");
    Map<String, String> map1 = new HashMap<>();
    map1.put(a1, "A1");

    a1 = new String("xyz");

    map1.forEach(
        (x, y) -> {
          System.out.println("x:" + x + " , y:" + y);
        });
  }
}
