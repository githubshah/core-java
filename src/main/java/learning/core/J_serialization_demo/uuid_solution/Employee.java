package learning.core.J_serialization_demo.uuid_solution;

public class Employee {

    //private static final long serialVersionUID = 1L;

    private String name;
    private String email = "shaid@gmail.com";

    public String getName() {
        return name;
    }

    // uncomment below piece of code and re-read the already saved object from file.

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}