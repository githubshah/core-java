package learning.core.N_java8.default_method;

class Fruit1 implements  Apple, Mango {

    @Override
    public void show() {
        Apple.super.show();
    }
}

public class ImplementDiamondPattern {

    public static void main(String[] args) {
        new Test().show(); //apple
    }
}