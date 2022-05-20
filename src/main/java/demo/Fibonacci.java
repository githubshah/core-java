package demo;

public class Fibonacci {

    public static void main(String[] args) {
        System.out.println(new Fibonacci().fibonacci(5));
    }//1,2,3,5,8

    private int fibonacci(int number) {
        if (number == 0 || number == 1) return 1;
        return fibonacci(number - 1) + fibonacci(number - 2);
    }
}
