package learning.core.default_method.override;

/*

Default Methods and Multiple Inheritance
In case both the implemented interfaces contain default methods with same method signature,
the implementing class should explicitly specify which default method is to be used
or it should override the default method.

* */
interface TestInterface1 {
    // default method
    default void show() {
        System.out.println("Default TestInterface1");
    }
}

interface TestInterface2 {
    // Default method
    default void show() {
        System.out.println("Default TestInterface2");
    }
}

// Implementation class code
class TestClass implements TestInterface1, TestInterface2 {
    // Overriding default show method
    public void show() {
        // use super keyword to call the show
        // method of TestInterface1 interface
        TestInterface1.super.show();

        // use super keyword to call the show
        // method of TestInterface2 interface
        TestInterface2.super.show();
    }

    public static void main(String args[]) {
        TestClass d = new TestClass();
        d.show();
    }
}
