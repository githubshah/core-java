package learning.core.cloneMethod;

import java.rmi.StubNotFoundException;

class Department {
    int deptId;
    String deptName;

    public Department(int deptId, String deptName) {
        this.deptId = deptId;
        this.deptName = deptName;
    }

    @Override
    public String toString() {
        return "Department{" +
                "deptId=" + deptId +
                ", deptName='" + deptName + '\'' +
                '}';
    }
}

class Employee implements Cloneable {
    int empId;
    String empname;

    Department dep;

    public Employee(int empId, String empName, Department department) {
        this.empId = empId;
        this.empname = empName;
        this.dep = department;
    }

    //Default version of clone() method
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public String toString() {
        return "Employee{" +
                "empId=" + empId +
                ", empname='" + empname + '\'' +
                ", dep=" + dep +
                '}';
    }
}

public class ShallowCloneSample {
    public static void main(String[] args) {
        Department department = new Department(1, "IT");

        Employee emp = new Employee(2, "Shaid", department);

        Employee emp2 = null;

        try {
            emp2 = (Employee) emp.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

        System.out.println(emp);
        System.out.println(emp2);

        emp.dep.deptName = "HR";

        System.out.println(emp);
        System.out.println(emp2);

    }
}