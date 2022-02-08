package learning.core.default_method.newDemo;

interface Test1 {
    // default method
    default void show() {
        System.out.println("Test1");
    }
}

interface Test2 extends Test1 {
    // default method
    default void show() {
        System.out.println("Test2");
    }
}

interface Test3 extends Test2, Test1 {
    default void show() {
        System.out.println("Test3");
    }
}

class Test implements Test2 {

}

class Tester implements Test3 {

}

public class HelloDefault {

    public static void main(String[] args) {
        new Test().show();
        new Tester().show();
    }
}