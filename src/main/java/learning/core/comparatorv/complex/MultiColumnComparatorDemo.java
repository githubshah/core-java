package learning.core.comparatorv.complex;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

enum Type {
    user, group, contact;
}

class Product {
    Type type;
    String firstName;
    String name;
    String email;
    String organization;

    public Product(Type type, String firstName, String name, String email, String organization) {
        this.type = type;
        this.firstName = firstName;
        this.name = name;
        this.email = email;
        this.organization = organization;
    }

    public Type getType() {
        return type;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getOrganization() {
        return organization;
    }

    @Override
    public String toString() {
        return "Product{" +
            "type=" + type +
            ", firstName='" + firstName + '\'' +
            ", name='" + name + '\'' +
            ", email='" + email + '\'' +
            ", organization='" + organization + '\'' +
            '}';
    }
}

public class MultiColumnComparatorDemo {
    public static void main(String[] args) {
        List<Product> pl = new ArrayList<>();
        pl.add(new Product(Type.user, "firstName2", "name3", "email5@gmail.com", "org4"));
        pl.add(new Product(Type.user, "firstName2", "", "email4@gmail.com", "org3"));
        pl.add(new Product(Type.user, "firstName1", "name6", "email3@gmail.com", "org2"));
        pl.add(new Product(Type.user, "", "firstName1", "email2@gmail.com", "org1"));
        pl.add(new Product(Type.user, "", "firstName8", "email1@gmail.com", "org3"));
        pl.add(new Product(Type.user, "firstName1", "name5", "email3@gmail.com", "org2"));
        pl.add(new Product(Type.user, "firstName3", "name3", "email6@gmail.com", "org5"));
        pl.add(new Product(Type.contact, "apple_fruit", "fruit", "apple.fruit@gmail.com", "org1"));
        pl.add(new Product(Type.contact, "apple_fruit", "fruit", "apple.fruit@gmail.com", "org1"));
        pl.add(new Product(Type.group, "apple2_fruit", "fruit", "apple2.fruit@gmail.com", "org1"));
        pl.add(new Product(Type.contact, "apple33_fruit", "fruit", "apple33.fruit@gmail.com", "org1"));
        pl.add(new Product(Type.group, "apple5_fruit", "fruit", "apple5.fruit@gmail.com", "org1"));
        pl.add(new Product(Type.contact, "apple6_fruit", "fruit", "apple6.fruit@gmail.com", "org1"));

        Comparator<Product> compareByName = Comparator
            .comparing(Product::getType)
            .thenComparing(Product::getOrganization)
            .thenComparing(Product::getEmail)
            .thenComparing(Product::getName)
            .thenComparing(Product::getFirstName);

        pl.sort(compareByName);
        pl.forEach(System.out::println);
    }
}
