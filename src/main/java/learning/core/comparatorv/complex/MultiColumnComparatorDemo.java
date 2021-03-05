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


class MultiColumnComparator implements Comparator<Product> {
    @Override
    public int compare(Product o1, Product o2) {
        int i = o1.getType().ordinal() - o2.getType().ordinal();
        if (i == 0) {

            int firstName = o1.getFirstName().compareTo(o2.getFirstName());
            if (firstName == 0) {
                int name = o1.getName().compareTo(o2.getName());
                if (name == 0) {
                    int email = o1.getEmail().compareTo(o2.getEmail());
                    if (email == 0) {
                        return o1.getOrganization().compareTo(o2.getOrganization());
                    }
                    return email;
                }
                return name;
            }
            return firstName;
        }
        return i;
    }
}

public class MultiColumnComparatorDemo {
    public static void main(String[] args) {
        List<Product> pl = new ArrayList<>();
        pl.add(new Product(Type.user, "firstName2", "name3", "email5@gmail.com", "org4"));
        pl.add(new Product(Type.user, "firstName2", "", "email4@gmail.com", "org3"));
        pl.add(new Product(Type.user, "firstName1", "name8", "email3@gmail.com", "org2"));
        pl.add(new Product(Type.user, "", "name9", "email2@gmail.com", "org1"));
        pl.add(new Product(Type.user, "firstName1", "name9", "email1@gmail.com", "org3"));
        pl.add(new Product(Type.user, "firstName3", "name3", "email6@gmail.com", "org5"));
        pl.add(new Product(Type.contact, "apple_fruit", "fruit", "apple.fruit@gmail.com", "org1"));
        pl.add(new Product(Type.contact, "apple_fruit", "fruit", "apple.fruit@gmail.com", "org1"));
        pl.add(new Product(Type.group, "apple2_fruit", "fruit", "apple2.fruit@gmail.com", "org1"));
        pl.add(new Product(Type.contact, "apple33_fruit", "fruit", "apple33.fruit@gmail.com", "org1"));
        pl.add(new Product(Type.group, "apple5_fruit", "fruit", "apple5.fruit@gmail.com", "org1"));
        pl.add(new Product(Type.contact, "apple6_fruit", "fruit", "apple6.fruit@gmail.com", "org1"));

        pl.sort(new MultiColumnComparator());
        pl.forEach(System.out::println);
    }
}
