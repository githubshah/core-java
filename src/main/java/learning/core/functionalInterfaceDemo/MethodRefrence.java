package learning.core.functionalInterfaceDemo;

@FunctionalInterface
interface Calculator {
    long calculate(long num1, long num2);
}

class Utility {
    public static long add(long num1, long num2) {
        return num1 + num2;
    }

    public static long multiply(long num1, long num2) {
        return num1 * num2;
    }
}

public class MethodRefrence {
    public static void main(String args[]) {
        Calculator calculator1 = Utility::add;
        System.out.println(calculator1.calculate(1, 2));

        Calculator calculator2 = Utility::multiply;
        System.out.println(calculator2.calculate(1, 2));
    }
}