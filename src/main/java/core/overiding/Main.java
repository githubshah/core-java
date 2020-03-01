package core.overiding;

public class Main {

    static {
        System.out.println("main static block callled");
    }

    public static void main(String[] args) {

        Parent parent = new Child();
        // if using parent ref to call over riding method then it
        // check declaration from parent but called child method

        // if parent and child have co variant type then overriding not happened.

        Child child1 = new Child();
        // if using parent ref to call over riding method then it
        // check declaration from parent but called child method

        // if parent and child have co variant type then overriding not happened.

        System.out.println("-------------------------");
        parent.overRiding();  //  need declaration as parent but used definition as child.

        parent.overRidingArg(new Integer(1));

    }
}
