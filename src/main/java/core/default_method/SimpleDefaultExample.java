package core.default_method;

interface DefaultMethodInterface {
    default public String defaultMethod() {
        return "---DefaultMethodInterface";
    }
}

interface DefaultMethodInterface2 {
    default public String defaultMethod() {
        return "---DefaultMethodInterface2";
    }
}

// you can not implement interfaces have same name default methods
public class SimpleDefaultExample implements DefaultMethodInterface {
    //public class DefaultExample implements DefaultMethodInterface {
    public static void main(String[] args) {
        System.out.println(new SimpleDefaultExample().defaultMethod());
    }
}
