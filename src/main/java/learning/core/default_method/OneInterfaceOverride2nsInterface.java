package learning.core.default_method;

interface DefaultMethodInterface {
    default public String defaultMethod() {
        return "---DefaultMethodInterface";
    }
}

interface DefaultMethodInterface2 extends DefaultMethodInterface {
    default public String defaultMethod() {
        return "---DefaultMethodInterface2";
    }
}

// you can not implement interfaces have same name default methods
public class OneInterfaceOverride2nsInterface implements DefaultMethodInterface2 {
    //public class DefaultExample implements DefaultMethodInterface {
    public static void main(String[] args) {
        System.out.println(new OneInterfaceOverride2nsInterface().defaultMethod());
    }
}
