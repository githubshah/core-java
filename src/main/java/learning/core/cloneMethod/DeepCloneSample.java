package learning.core.cloneMethod;

class Department1 implements Cloneable {
    int deptId;
    String deptName;

    public Department1(int deptId, String deptName) {
        this.deptId = deptId;
        this.deptName = deptName;
    }

    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public String toString() {
        return "Department{" +
                "deptId=" + deptId +
                ", deptName='" + deptName + '\'' +
                '}';
    }
}

class Employee1 implements Cloneable {
    int empId;
    String empname;

    Department1 dep;

    public Employee1(int empId, String empName, Department1 department) {
        this.empId = empId;
        this.empname = empName;
        this.dep = department;
    }

    //Default version of clone() method
    protected Object clone() throws CloneNotSupportedException {
        Employee1 clone = (Employee1) super.clone();
        this.dep = (Department1) dep.clone();
        return clone;
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

public class DeepCloneSample {
    public static void main(String[] args) {
        Department1 department = new Department1(1, "IT");

        Employee1 emp = new Employee1(2, "Shaid", department);

        Employee1 emp2 = null;

        try {
            emp2 = (Employee1) emp.clone();
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