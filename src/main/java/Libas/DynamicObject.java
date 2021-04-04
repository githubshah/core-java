package Libas;

import java.util.function.Function;

interface Person {
    public String getEmail();

    public String getName();
}

public class DynamicObject {

    public <T> T getProperty(String one, Function<Person, T> claimsResolver) {
        Person person = new Person() {

            @Override
            public String getEmail() {
                return one.substring(0, one.indexOf(":"));
            }

            @Override
            public String getName() {
                return one.substring(one.indexOf(":") + 1);
            }
        };

        return claimsResolver.apply(person);
    }

    public static void main(String... s) {
        DynamicObject dynamicObject = new DynamicObject();
        String s1 = dynamicObject.getProperty("shaid@gmail.com:sahid", Person::getEmail);
        String s2 = dynamicObject.getProperty("shaid@gmail.com:sahid", Person::getName);
        System.out.println(s1 + " . " + s2);
    }
}
