package cc;

public record Person(String name, Integer age) {

    public Person {
        System.out.println("no arg constructor called");
        if (age == null) {
            throw new RuntimeException("error");
        }
    }

    public Person(String name) {
        this(name, 30);
        System.out.println("name arg");
    }

    public Person(int age) {
        this("Unknown", age);
        System.out.println("age arg");
    }

    public static void main(String[] args) {
        Person sahdi = new Person("sahdi");
    }
}