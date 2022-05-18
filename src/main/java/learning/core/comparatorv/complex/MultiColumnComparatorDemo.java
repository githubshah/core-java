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
            int firstName = findFirst(o1).compareTo(findFirst(o2));
            if (firstName == 0) {
                int name = findFirst(o1).compareTo(findFirst(o2));
                if (name == 0) {
                    int email = findFirst(o1).compareTo(findFirst(o2));
                    if (email == 0) {
                        return findFirst(o1).compareTo(findFirst(o2));
                    }
                    return email;
                }
                return name;
            }
            return firstName;
        }
        return i;
    }

    private String findFirst(Product product) {
        if (!product.getFirstName().isEmpty()) {
            return product.getFirstName();
        } else if (!product.getName().isEmpty()) {
            return product.getName();
        } else if (!product.getEmail().isEmpty()) {
            return product.getEmail();
        } else {
            return product.getOrganization();
        }
    }
}

public class MultiColumnComparatorDemo {
    public static void main(String[] args) {
        List<Product> pl = new ArrayList<>();

        pl.add(new Product(Type.user, "email_name@gmail4.com", "name2", "email_name@gmail4.com", "org_name4"));
        pl.add(new Product(Type.user, "", "i_name2", "email_name2@gmail.com", "org_name4"));
        pl.add(new Product(Type.user, "zmail_name@gmail3.com", "first", "zmail_name@gmail3.com", "org_name4"));
        pl.add(new Product(Type.user, "shaid", "", "email_name4@gmail.com", "org_name4"));


        pl.sort(new MultiColumnComparator());
        pl.forEach(System.out::println);
    }
}
