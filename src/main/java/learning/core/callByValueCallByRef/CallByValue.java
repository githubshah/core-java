package learning.core.callByValueCallByRef;

public class CallByValue {

    public static void main(String[] args) {
        //wrapper(); // do not get swap
        //primitive(); // do not swap
        //wrapper2();
        wrapper3();
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

    private static void wrapper2() {
        Integer a = 30;
        System.out.println("Before swapping, a = " + a);
        // Invoke the swap method
        modify(a);
        System.out.println("\n**Now, Before and After swapping values will be different here**:");
        System.out.println("After swapping, a = " + a);
    }

    private static void wrapper3() {
        String a = "abc";
        System.out.println("Before swapping, a = " + a);
        // Invoke the swap method
        modify(a);
        System.out.println("\n**Now, Before and After swapping values will be different here**:");
        System.out.println("After swapping, a = " + a);
    }

    public static void modify(Object a) {
        a = null;
    }
}
