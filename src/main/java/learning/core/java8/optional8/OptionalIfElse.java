package learning.core.java8.optional8;

import java.util.Optional;

public class OptionalIfElse {

    public static void main(String[] args) {
        System.out.println(checkOptional(13));
    }

    private static Integer checkOptional(Integer a) {
        Optional<Integer> valueOpt1 = Optional.ofNullable(a);

        return valueOpt1.map(Optional::of) // 1  {if = map}
                .orElse(Optional.of(12)).get(); //6  {orElse = else}
    }
}
