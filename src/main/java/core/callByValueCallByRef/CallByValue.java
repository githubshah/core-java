package core.callByValueCallByRef;

public class CallByValue {

    public static void main(String[] args) {
        //wrapper(); // do not get swap
        primitive(); // do not swap
    }

    private static void primitive() {
        int a = 30;
        int b = 45;
        System.out.println("Before swapping, a = " + a + " and b = " + b);
        // Invoke the swap method
        swapFunction(a, b);
        System.out.println("\n**Now, Before and After swapping values will be different here**:");
        System.out.println("After swapping, a = " + a + " and b is " + b);
    }

    private static void wrapper() {
        Integer a = 30;
        Integer b = 45;
        System.out.println("Before swapping, a = " + a + " and b = " + b);
        // Invoke the swap method
        swapFunction(a, b);
        System.out.println("\n**Now, Before and After swapping values will be different here**:");
        System.out.println("After swapping, a = " + a + " and b is " + b);
    }

    public static void swapFunction(Integer a, Integer b) {
        System.out.println("Before swapping(Inside), a = " + a + " b = " + b);
        // Swap n1 with n2
        Integer c = a;
        a = b;
        b = c;
        System.out.println("After swapping(Inside), a = " + a + " b = " + b);
    }
}
