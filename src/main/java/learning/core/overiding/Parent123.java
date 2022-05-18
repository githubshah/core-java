package learning.core.overiding;

public class Parent123 {

    synchronized void foo() {
    }
}

class Child123 extends Parent123 {

    @Override
    synchronized void foo() { // must use synchronized because parent syncronized will not overriden
        super.foo();
    }
}