package learning.csv;

public class Emp {
    String name;
    String email;
    Integer salary;
    String dept;

    public Emp(String name, String email, Integer salary, String dept) {
        this.name = name;
        this.email = email;
        this.salary = salary;
        this.dept = dept;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public Integer getSalary() {
        return salary;
    }

    public String getDept() {
        return dept;
    }

    @Override
    public String toString() {
        return "Emp{" +
            "name='" + name + '\'' +
            ", email='" + email + '\'' +
            ", salary='" + salary + '\'' +
            ", dept='" + dept + '\'' +
            '}';
    }
}
