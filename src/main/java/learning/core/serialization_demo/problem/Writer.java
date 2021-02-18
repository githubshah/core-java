package learning.core.serialization_demo.problem;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class Writer {
    public static void main(String[] args) throws IOException {
        Employee employee = new Employee();
        employee.setName("shaid hussain");

        FileOutputStream fout = new
            FileOutputStream("employee.obj");
        ObjectOutputStream oos = new ObjectOutputStream(fout);
        oos.writeObject(employee);
        oos.close();
        System.out.println("Process complete");
    }
}