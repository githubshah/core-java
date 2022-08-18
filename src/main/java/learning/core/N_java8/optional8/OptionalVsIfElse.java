package learning.core.N_java8.optional8;

import java.util.Optional;

public class OptionalVsIfElse {

    public static void main(String[] args) {
        Integer a = 10;
        Integer b = 20;
        Integer c = 30;

//        System.out.println("optional= " + checkOptional(a, b, c) + " ,if-else= " + checkIf(a, b, c));
//        System.out.println("optional= " + checkOptional(null, b, c) + " ,if-else= " + checkIf(null, b, c));
        //      System.out.println("optional= " + checkOptional(a, null, c) + " ,if-else= " + checkIf(a, null, c));
        System.out.println("optional= " + checkOptional(null, b, null) + " ,if-else= " + checkIf(null, b, null));

    }

    private static Integer checkOptional(Integer a, Integer b, Integer c) {
        return Optional.ofNullable(a)
                .map(value -> {
                    System.out.println(value + " non null 1st");
                    return Optional.of(value);
                })
                .orElse(Optional.ofNullable(b))
                .map(value1 -> {
                    System.out.println(value1 + " non null 2nd");
                    return Optional.of(value1);
                }).orElse(Optional.ofNullable(c))
                .orElse(100);
    }

    private static Integer checkIf(Integer a, Integer b, Integer c) {
        if (a != null) { //1
            return a;
        } else if (b != null) {  //2
            return b;
        } else if (c != null) {  //3
            return c;
        } else {                //6
            return 100;
        }
    }
}
