package learning.core.B_constructorchaining;

public class StaticInitializationOnClassLoad {

    static {
        System.out.println("class loaded and static initialization called");
    }

    {
        System.out.println("initialization called only before constructor called");
    }

    public static void main(String[] args) {
        System.out.println("main method call");
    }
}
