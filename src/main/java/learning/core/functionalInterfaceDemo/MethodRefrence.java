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
        Calculator calculate = Utility::add;
        System.out.println(calculate.calculate(1, 2));
    }
}