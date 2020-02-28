package csv;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVPrinter;
import org.apache.commons.csv.CSVRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

enum Student {
    Name, Email, Salary, Dept;
}

public class ReadCsv {

    static Logger logger = LoggerFactory.getLogger(ReadCsv.class);

    public static void main(String[] args) throws IOException {

        String file = "/Users/daffolapmac-96/Desktop/csvFile/student.csv";

        Writer writer = Files.newBufferedWriter(Paths.get(file), StandardOpenOption.TRUNCATE_EXISTING);

        try (CSVPrinter csvPrinter = new CSVPrinter(writer, CSVFormat.DEFAULT.withHeader(Student.class))) {
            csvPrinter.printRecord("fe-sachin", "sachin@agmail.com", "1000", "IT", "FEMALE");
            csvPrinter.printRecord("munish", "munish@agmail.com", "2000", "IT", "MALE");
            csvPrinter.printRecord("fe-dhheraj", "dhheraj@agmail.com", "3000", "IT", "FEMALE");
            csvPrinter.printRecord("sager", "sager@agmail.com", "4000", "IT", "MALE");
            csvPrinter.printRecord("fe-vikram", "vikram@agmail.com", "5000", "HR", "FEMALE");
            csvPrinter.printRecord("lokesh", "lokesh@agmail.com", "6000", "HR", "MALE");
            csvPrinter.printRecord("fe-nowman", "nowman@agmail.com", "6000", "HR", "FEMALE");
            csvPrinter.printRecord("nowman", "nowman@agmail.com", "7000", "HR", "MALE");
            csvPrinter.flush();
        } catch (Exception ignored) {

        }

        Reader reader = Files.newBufferedReader(Paths.get(file));

        CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT.withHeader(Student.class).withFirstRecordAsHeader());

        List<Emp> empList = new ArrayList();
        for (CSVRecord record : csvParser) {
            empList.add(new Emp(
                record.get(Student.Name),
                record.get(Student.Email),
                Integer.parseInt(record.get(Student.Salary)),
                record.get(Student.Dept)));
        }
        System.out.println(empList);

        Optional<Integer> reduce = empList.stream()
            .map(Emp::getSalary)
            .reduce((x1, x2) -> x1 > x2 ? x1 : x2);

        System.out.println("highest salary in emp list: " + reduce.get());

        Integer reduce1 = empList.stream().map(Emp::getSalary).reduce(0, (x1, x2) -> x1 + x2);
        System.out.println("total salary: " + reduce1);

        List<String> collect = empList.stream().map(Emp::getDept).distinct().collect(Collectors.toList());
        System.out.println("distinct salary: " + collect);

        Map<String, Integer> collect1 = empList.stream()
            .collect(Collectors.toMap(Emp::getDept, Emp::getSalary, (x1, x2) -> x1 > x2 ? x1 : x2));

        System.out.println(collect1);

        logger.info("collect : ", collect1);
    }
}
