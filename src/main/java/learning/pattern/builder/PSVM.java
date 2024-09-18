package learning.pattern.builder;

class Person1 {

    static {
        System.out.println("Person class loaded");
    }

    {
        System.out.println("Person class constructor going to called: init method");
    }

    private String name;
    private int age;

    public Person1(Builder builder) {
        this.name = builder.name;
        this.age = builder.age;
    }

    public static Builder builder(String name) {
        return new Builder(name);
    }

    public String getName() {
        return this.name;
    }

    static class Builder {

        static {
            System.out.println("Person Builder class loaded");
        }

        {
            System.out.println("Person Builder class constructor going to called: init method");
        }

        String name;
        int age;

        public Builder(String name) {
            this.name = name;
        }

        public Builder setAge(int age) {
            this.age = age;
            return this;
        }

        public Person1 build() {
            return new Person1(this);
        }
    }
}

public class PSVM {

    public static void main(String[] args) {
        Person1 person = Person1.builder("John")
                .setAge(30)  // Optional parameter
                .build();
        System.out.println(person.getName());

        Person1 person1 = Person1.builder("cena")
                .setAge(30)  // Optional parameter
                .build();
        System.out.println(person1.getName());
    }
}
