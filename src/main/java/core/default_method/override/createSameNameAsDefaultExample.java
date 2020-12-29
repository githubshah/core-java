package core.default_method.override;

/*

Default Methods and Multiple Inheritance
In case both the implemented interfaces contain default methods with same method signature,
the implementing class should explicitly specify which default method is to be used
or it should override the default method.

* */
interface TestInterface {
    // default method
    default void show() {
        System.out.println("Default TestInterface/...");
    }
}

// Implementation class code
class TestClass1 implements TestInterface{

    public void show(){
        System.out.println("jijij");
    }

    public static void main(String args[]) {
        TestClass1 d = new TestClass1();
        d.show();
    }
}
