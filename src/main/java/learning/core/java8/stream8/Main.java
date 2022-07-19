package learning.core.java8.stream8;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    class Employee {
        int id;
        String subjectName;
        int marks;

        public Employee(int id, String subjectName, int marks) {
            this.id = id;
            this.subjectName = subjectName;
            this.marks = marks;
        }

        public int getId() {
            return id;
        }

        public String getSubjectName() {
            return subjectName;
        }

        public int getMarks() {
            return marks;
        }

        @Override
        public String toString() {
            return "Employee{" +
                    "id=" + id +
                    ", subjectName='" + subjectName + '\'' +
                    ", marks=" + marks +
                    '}';
        }
    }

    public static void main(String[] args) {

        String[] arr = {"1-english:20", "2-english:30", "3-english:10", "1-hindi:40", "1-math:30", "2-hindi:5", "2-math:15", "1-java:10"};
        // average marks for each subject.
        // second topper for each subject.

        Main main = new Main();
        List<Employee> empList = main.populateInObject(arr);
        System.out.println("data of all employees: " + empList);

        // average marks for each subject.
        Map<String, Double> averageMarks = main.getAverageMarks(empList);
        System.out.println("average marks for each subject: " + averageMarks);

        // second topper for each subject.
        Map<String, Integer> secondTopperForEachSubject = main.getSecondTopperForEachSubject(empList);
        System.out.println("second topper for each subject.: " + secondTopperForEachSubject);
    }

    private Map<String, Integer> getSecondTopperForEachSubject(List<Employee> empList) {
        return empList.stream()
                .collect(Collectors.groupingBy(Employee::getSubjectName,
                        Collectors.collectingAndThen(Collectors.toList(),
                                x -> getReverseAndDistinctData(x)
                                        .limit(2).skip(1).findFirst().map(Employee::getMarks)
                                        .orElse(getReverseAndDistinctData(x)
                                                .limit(1).findFirst().map(Employee::getMarks).orElse(0)))));


    }

    private Stream<Employee> getReverseAndDistinctData(List<Employee> x) {
        return x.stream().sorted(Comparator.comparing(Employee::getMarks).reversed()).distinct();
    }

    private Map<String, Double> getAverageMarks(List<Employee> empList) {
        return empList.stream()
                .collect(Collectors.groupingBy(Employee::getSubjectName, Collectors.averagingInt(Employee::getMarks)));
    }

    private List<Employee> populateInObject(String[] arr) {
        List<Employee> objects = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            String[] split = arr[i].split(":");
            String[] split1 = split[0].split("-");

            int rollNumber = Integer.valueOf(split1[0]);
            String subjectName = split1[1];
            int marks = Integer.valueOf(split[1]);

            objects.add(new Employee(rollNumber, subjectName, marks));
        }
        return objects;
    }

}
