package learning.core.N_java8.optional8;

import java.util.Optional;

public class OptionalMethods {

    public static void main(String[] args) {
        Optional<Integer> integer = Optional.ofNullable(1);

        String a = null;

        Optional optional1 = Optional.of(a); // reuored non null
        Optional optional2 = Optional.ofNullable(a);

    }
}
