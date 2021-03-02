package learning.core.aaJava8.stream8;

import java.time.LocalDate;
import java.time.Month;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

//from  w w w . j  a  v a 2s . com
public class HighestSalaryInEachDept {
    public static void main(String[] args) {

        /**
         * {SALES=2, HR=2, IT=4}
         */
        //totalEmpCountInEachDepartment(); // groupBy -> counting

        /**
         * {IT=Munish, Shaid, Liza, viktor, SALES=Quentin, Jully, HR=Stef, Barbie}
         */
        //totalEmpNameInEachDepartment();  // groupBy -> maping -> and joining

        /**
         * {SALES={OCTOBER=Jully, MAY=Quentin}, HR={DECEMBER=Stef, JUNE=Barbie}, IT={JUNE=Liza, viktor, JANUARY=Munish, JULY=Shaid}}
         */
        //groupByDeptThenDOB(); // groupBy -> groupBy -> maping -> and joining

        /**
         * {IT=Optional[9876.0], SALES=Optional[6543.0], HR=Optional[3210.0]}
         */
        //secondHighestSalaryInEachDepartment();

        /**
         * {IT=Optional[9988.0], SALES=Optional[9753.0], HR=Optional[9999.0]}
         */
        //highestSalaryInEachDepartment1(); // groupBy -> collectionAndThen ->

        /**
         * {SALES=9753.0, HR=9999.0, IT=9988.0}
         */
        //highestSalaryInEachDepartment();  // toMap

        /**
         * {SALES=(3, Quentin,  SALES,  1989-05-29,  9753.00)
         * , HR=(5, Stef,  HR,  1987-12-13,  9999.00)
         * , IT=(6, viktor,  IT,  1990-06-09,  9988.00)
         * }
         */
        //highestSalaryObjectInEachDepartment(); // toMap

        //eachEmpNameInEachDepartment1();

        //sum();

        //convertObjectListToMap();

        mapVsMapping();
    }

    private static void mapVsMapping() {
        List<String> collect = Employee.persons().stream().collect(Collectors.mapping(Employee::getName, Collectors.toList()));
        collect.forEach(System.out::println);
    }

    private static void convertObjectListToMap() {
        Map<String, Employee> collect = Employee.persons().stream().collect(Collectors.toMap(Employee::getName, Function.identity()));
        collect.forEach((key, value) -> {
            System.out.println(key + " : " + value);
        });
    }

    private static void sum() {
        List<Integer> integers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        Integer reduce = integers.stream().reduce(0, Integer::sum);
        System.out.println(reduce);
    }

    private static void highestSalaryInEachDepartment1() {
        Map<Employee.Department, Optional<Double>> collect = Employee.persons()
            .stream()
            .collect(Collectors.groupingBy(Employee::getDepartment, Collectors.collectingAndThen(Collectors.toList(),
                x -> x.stream().map(Employee::getIncome).sorted(Comparator.reverseOrder()).distinct().limit(1).findFirst())));
        System.out.println(collect);
    }

    private static void secondHighestSalaryInEachDepartment() {
        Map<Employee.Department, Optional<Double>> collect = Employee.persons()
            .stream()
            .collect(Collectors.groupingBy(Employee::getDepartment, Collectors.collectingAndThen(Collectors.toList(),
                x -> x.stream().map(Employee::getIncome).sorted(Comparator.reverseOrder()).distinct().limit(2).skip(1).findFirst())));
        System.out.println(collect);
    }

    private static void groupByDeptThenDOB() {
        Map personsByDepartmentAndDobMonth
            = Employee.persons()
            .stream()
            .collect(Collectors.groupingBy(Employee::getDepartment,
                Collectors.groupingBy(getEven -> getEven.getDob().getMonth(),
                    Collectors.mapping(Employee::getName, Collectors.joining(", ")))));
        System.out.println(personsByDepartmentAndDobMonth);
    }

    private static void totalEmpNameInEachDepartment() {
        Map<Employee.Department, String> namesByGender = Employee.persons()
            .stream()
            .collect(Collectors.groupingBy(Employee::getDepartment,
                Collectors.mapping(Employee::getName, Collectors.joining(", "))));
        System.out.println(namesByGender);
    }

    private static void eachEmpNameInEachDepartment1() {
        Map<Employee.Department, List<Employee>> collect = Employee.persons()
            .stream()
            .collect(Collectors.groupingBy(Employee::getDepartment, Collectors.collectingAndThen(Collectors.toList(), Collections::unmodifiableList)));
        System.out.println(collect);
    }

    private static void totalEmpCountInEachDepartment() {
        Map<Employee.Department, Long> collect56 = Employee.persons()
            .stream()
            .collect(Collectors.groupingBy(Employee::getDepartment, Collectors.counting()));
        System.out.println(collect56);
    }

    private static void highestSalaryInEachDepartment() {
        Map<Employee.Department, Double> collect = Employee.persons()
            .stream()
            .collect(Collectors.toMap(Employee::getDepartment, Employee::getIncome, (old1, new1) -> new1 > old1 ? new1 : old1));
        System.out.println(collect);
    }

    private static void highestSalaryObjectInEachDepartment() {
        Map<Employee.Department, Employee> highestEarnerByGender = Employee.persons()
            .stream()
            .collect(Collectors.toMap(Employee::getDepartment, Function.identity(),
                (oldPerson, newPerson) -> newPerson.getIncome() > oldPerson.getIncome() ? newPerson : oldPerson));
        System.out.println(highestEarnerByGender);
    }
}


class Employee {
    enum Department {
        HR, SALES, IT
    }

    private long id;
    private String name;
    private Department department;


    private LocalDate dob;
    private double income;

    public Employee(long id, String name, Department department, LocalDate dob,
                    double income) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.dob = dob;
        this.income = income;
    }

    public boolean isHR() {
        return this.department.equals(Department.HR);
    }

    public LocalDate getDob() {
        return dob;
    }

    public String getName() {
        return name;
    }

    public Department getDepartment() {
        return department;
    }

    public double getIncome() {
        return income;
    }

    public static List<Employee> persons() {
        Employee p1 = new Employee(1, "Munish", Department.IT, LocalDate.of(1988, Month.JANUARY, 1), 9876.0);
        Employee p2 = new Employee(2, "Shaid", Department.IT, LocalDate.of(1993, Month.JULY, 21), 8765.0);
        Employee p3 = new Employee(3, "Quentin", Department.SALES, LocalDate.of(1989, Month.MAY, 29), 9753.0);
        Employee p4 = new Employee(4, "Jully", Department.SALES, LocalDate.of(1990, Month.OCTOBER, 16), 6543.0);
        Employee p5 = new Employee(5, "Stef", Department.HR, LocalDate.of(1987, Month.DECEMBER, 13), 9999.0);
        Employee p6 = new Employee(6, "Barbie", Department.HR, LocalDate.of(1994, Month.JUNE, 9), 3210.0);
        Employee p7 = new Employee(6, "Liza", Department.IT, LocalDate.of(1999, Month.JUNE, 9), 5432.0);
        Employee p8 = new Employee(6, "viktor", Department.IT, LocalDate.of(1990, Month.JUNE, 9), 9988.0);

        return Arrays.asList(p1, p2, p3, p4, p5, p6, p7, p8);
    }

    @Override
    public String toString() {
        return String.format("(%s, %s,  %s,  %s,  %.2f)\n", id, name, department, dob, income);
    }
}