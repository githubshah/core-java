package learning.core.D_overiding.access_specifier;


class Base {
    protected void fun() {
        System.out.println("base");

    }
}

class Child extends Base {

    @Override
    public void fun() {
        System.out.println("child");
    }
}

public class Test {

    public static void main(String[] args) {
        Base base = new Child();

        base.fun();
    }
}
