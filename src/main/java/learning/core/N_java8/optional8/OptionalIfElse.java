package learning.core.N_java8.optional8;

import java.util.Optional;

class Address {
    String street;

    public Address(String street) {
        this.street = street;
    }

    public String getStreet() {
        return street;
    }
}

class User {
    String name;
    Address address;

    public User(String name, String street) {
        this.name = name;
        this.address = new Address(street);
    }

    public User(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Address getAddress() {
        return address;
    }
}

public class OptionalIfElse {

    public static void main(String[] args) {
        System.out.println(check(new User("shaid", "shah market")));
        System.out.println(check(new User("shaid")));

        System.out.println();

        System.out.println(checkOptional(new User("shaid", "shah market")));
        System.out.println(checkOptional(new User("shaid")));
    }

    private static String check(User user) {
        if (user != null) {
            Address address = user.getAddress();
            if (address != null) {
                String street = address.getStreet();
                if (street != null) {
                    return street;
                }
            }
        }
        return "not specified";
    }

    private static String checkOptional(User user) {
        return Optional.ofNullable(user)
                .map(User::getAddress)
                .map(Address::getStreet)
                .orElse("not specified");
    }
}
