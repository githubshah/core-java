package learning.core.N_java8.default_method;

/*

Default Methods and Multiple Inheritance
In case both the implemented interfaces contain default methods with same method signature,
the implementing class should explicitly specify which default method is to be used
or it should override the default method.

* */
interface TestInterface12 {
    // default method
    default void show() {
        System.out.println("Default TestInterface1");
    }
}

class children implements TestInterface12{
    // Default method
    public void show() {
        System.out.println("class own TestInterface2");
    }
}

// Implementation class code
class DefaultAndLocalHaveSameName {

    public static void main(String args[]) {
        TestInterface12 d = new children();
        d.show(); // class own TestInterface2
    }

}
