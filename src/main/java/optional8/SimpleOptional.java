package optional8;

import java.util.Optional;

public class SimpleOptional {

    public static void main(String[] args) {
        Integer a = 10;
        Integer b = 20;
        Integer c = 30;
        Integer d = 40;

        System.out.println("v= " + check(a, b, c, d));
        a = null;
        System.out.println("v= " + check(a, b, c, d));
        a = null;
        b = null;
        System.out.println("v= " + check(a, b, c, d));
        a = null;
        b = null;
        c = null;
        System.out.println("v= " + check(a, b, c, d));
        a = null;
        b = null;
        c = null;
        d = null;
        System.out.println("v= " + check(a, b, c, d));

    }

    private static Integer check(Integer a, Integer b, Integer c, Integer d) {
        Optional<Integer> valueOpt1 = Optional.ofNullable(a);
        Optional<Integer> valueOpt2 = Optional.ofNullable(b);
        Optional<Integer> valueOpt3 = Optional.ofNullable(c);
        Optional<Integer> valueOpt4 = Optional.ofNullable(d);

        return valueOpt1.map(Optional::of)
            .orElseGet(() -> valueOpt2).map(Optional::of)
            .orElseGet(() -> valueOpt3).map(Optional::of).orElse(valueOpt4)
            .orElse(100);
    }
}
