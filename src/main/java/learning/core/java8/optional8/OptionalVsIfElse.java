package learning.core.java8.optional8;

import java.util.Optional;

public class OptionalVsIfElse {

    public static void main(String[] args) {
        Integer a = 10;
        Integer b = 20;
        Integer c = 30;

        System.out.println("optional= " + checkOptional(a, b, c) + " ,if-else= " + checkIf(a, b, c));
        System.out.println("optional= " + checkOptional(null, b, c) + " ,if-else= " + checkIf(null, b, c));
        System.out.println("optional= " + checkOptional(null, null, c) + " ,if-else= " + checkIf(null, null, c));
        System.out.println("optional= " + checkOptional(null, null, null) + " ,if-else= " + checkIf(null, null, null));

    }

    private static Integer checkOptional(Integer a, Integer b, Integer c) {
        Optional<Integer> valueOpt1 = Optional.ofNullable(a);
        Optional<Integer> valueOpt2 = Optional.ofNullable(b);
        Optional<Integer> valueOpt3 = Optional.ofNullable(c);

        return valueOpt1.map(value -> Optional.of(value)) // 1  {if = map}
                .orElse(valueOpt2).map(value1 -> Optional.of(value1)) //2  {else-if = orElseGet+map}
                .orElse(valueOpt3) //4   {last else-if = orElse}
                .orElse(100); //6  {orElse = else}
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
