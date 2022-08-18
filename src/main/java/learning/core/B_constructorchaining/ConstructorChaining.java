package learning.core.B_constructorchaining;

class GrandFather {

    static {
        System.out.println("static >> GrandFather method call");
    }

    {
        System.out.println("GrandFather init block call");
    }

    public GrandFather() {
        System.out.println("GrandFather constructor call");
    }
}

class Father extends GrandFather {

    static {
        System.out.println("static >> Father method call");
    }

    {
        System.out.println("Father init block call");
    }

    public Father() {
        System.out.println("Father constructor call");
    }
}

class Child extends Father {
    static {
        System.out.println("static >> Child method call");
    }

    {
        System.out.println("child init block call");
    }

    public Child() {
        System.out.println("child constructor call");
    }
}


public class ConstructorChaining {

    public static void main(String[] args) throws Exception {

        new Child();

    }
}