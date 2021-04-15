package learning.core.functionalInterfaceDemo;

@FunctionalInterface
interface CalculatorTest {
    void calculate(int num1);

    default void show(){
        System.out.println("default");
    }

    static void meaoo(){
        System.out.println("static");
    }
}

class MyJob {
    public MyJob(int num1) {
        System.out.println(num1);
    }
}

public class ConstructorRefrence {
    public static void main(String args[]) {
        CalculatorTest calculate = MyJob::new;
        calculate.calculate(1);
    }
}
