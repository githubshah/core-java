package learning.core.N_java8.default_method;

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

interface TestInterface2 extends TestInterface1{
    // Default method
    default void show() {
        System.out.println("Default TestInterface2");
    }
}

// Implementation class code
class MultilevelInheritance implements TestInterface2 {
    public static void main(String args[]) {
        MultilevelInheritance d = new MultilevelInheritance();
        d.show();
    }

}
