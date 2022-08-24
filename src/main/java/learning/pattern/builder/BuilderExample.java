package learning.pattern.builder;

final class Employee {
    final private String email; // mandatory
    final private String gender; // optional


    public Employee(Builder builder) {
        this.email = builder.getEmail();
        this.gender = builder.getGender();
    }

    @Override
    public String toString() {
        return "Employee{" +
                "email='" + email + '\'' +
                ", gender='" + gender + '\'' +
                '}';
    }

    public static class Builder {
        private String email; // mandatory
        private String gender;

        public Builder(String email) {
            this.email = email;
        }

        public Builder setGender(String gender) {
            this.gender = gender;
            return this;
        }

        public Employee build() {
            return new Employee(this);
        }

        public String getEmail() {
            return email;
        }

        public String getGender() {
            return gender;
        }
    }
}


public class BuilderExample {

    public static void main(String[] args) {
        Employee employee = new Employee.Builder("shaid@gmail.com")
                .setGender("male")
                .build();
        System.out.println("Apple " + employee);
    }

}
