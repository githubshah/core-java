package learning.core.iterrator;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

class Employee {
    String name;
    int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Employee(String a, int i) {
        name = a;
        age = i;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public static List<Employee> getTotalEmployee() {
        return Arrays.asList(new Employee("c", 2), new Employee("a", 1), new Employee("b", 1),new Employee("b", 2));
    }
}

public class MultiComparator {

    public static void main(String[] args) throws Exception {

        List<Employee> totalEmployee = Employee.getTotalEmployee();
        Comparator<Employee> employeeComparator = Comparator.comparing(Employee::getName).thenComparing(Employee::getAge, Comparator.reverseOrder());

        List<Employee> collect = totalEmployee.stream().sorted(employeeComparator).collect(Collectors.toList());
        collect.forEach(System.out::println);
    }
}

