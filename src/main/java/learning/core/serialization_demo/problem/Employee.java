package learning.core.serialization_demo.problem;

import java.io.Serializable;

public class Employee implements Serializable {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // you can not manipulate the class once serialize its object into DB/FILE.
    // else you will get INVALID class exception


    // uncomment below piece of code and re-read the already saved object from file.

    /*private String email = "shaid@gmail.com";

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }*/
}