package learning.core.serialization_demo.solution;

import java.io.Serializable;

public class Employee implements Serializable {

    private static final long serialVersionUID = 1L;

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // uncomment below piece of code and re-read the already saved object from file.

    private String email = "shaid@gmail.com";

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}