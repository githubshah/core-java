package optional8;

import java.util.Optional;

public class SimpleOptional {

    public static void main(String[] args) {
        Integer a = 10;
        Integer b = 20;
        Integer c = 30;
        Integer d = 40;
        Integer e = 50;

        System.out.println("optional= " + checkOptional(a, b, c, d, e) + " ,if-else= " + checkIf(a, b, c, d, e));
        a = null;
        System.out.println("optional= " + checkOptional(a, b, c, d, e) + " ,if-else= " + checkIf(a, b, c, d, e));
        a = null;
        b = null;
        System.out.println("optional= " + checkOptional(a, b, c, d, e) + " ,if-else= " + checkIf(a, b, c, d, e));
        a = null;
        b = null;
        c = null;
        System.out.println("optional= " + checkOptional(a, b, c, d, e) + " ,if-else= " + checkIf(a, b, c, d, e));
        a = null;
        b = null;
        c = null;
        d = null;
        System.out.println("optional= " + checkOptional(a, b, c, d, e) + " ,if-else= " + checkIf(a, b, c, d, e));
        a = null;
        b = null;
        c = null;
        d = null;
        e = null;
        System.out.println("optional= " + checkOptional(a, b, c, d, e) + " ,if-else= " + checkIf(a, b, c, d, e));
    }

    private static Integer checkOptional(Integer a, Integer b, Integer c, Integer d, Integer e) {
        Optional<Integer> valueOpt1 = Optional.ofNullable(a);
        Optional<Integer> valueOpt2 = Optional.ofNullable(b);
        Optional<Integer> valueOpt3 = Optional.ofNullable(c);
        Optional<Integer> valueOpt4 = Optional.ofNullable(d);
        Optional<Integer> valueOpt5 = Optional.ofNullable(e);

        return valueOpt1.map(Optional::of) // 1
            .orElseGet(() -> valueOpt2).map(Optional::of) //2
            .orElseGet(() -> valueOpt3).map(Optional::of) //3
            .orElseGet(() -> valueOpt4).map(Optional::of) //4
            .orElse(valueOpt5) //4
            .orElse(100); // 5
    }

    private static Integer checkIf(Integer a, Integer b, Integer c, Integer d, Integer e) {
        if (a != null) { //1
            return a;
        } else if (b != null) {  //2
            return b;
        } else if (c != null) {  //3
            return c;
        } else if (d != null) { //4
            return d;
        } else if (e != null) { //5
            return e;
        } else {                //6
            return 100;
        }
    }
}
