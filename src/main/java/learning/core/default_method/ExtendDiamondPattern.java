package learning.core.default_method;

interface Apple {
    // default method
    default void show() {
        System.out.println("apple");
    }
}

interface Mango {
    // default method
    default void show() {
        System.out.println("mango");
    }
}

interface Fruit extends Apple, Mango {

    @Override
    default void show() {
        Apple.super.show();
    }
}

class Test implements Fruit{

}

public class ExtendDiamondPattern {

    public static void main(String[] args) {
        new Test().show(); //apple
    }
}