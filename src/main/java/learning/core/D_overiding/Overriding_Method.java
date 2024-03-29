package learning.core.D_overiding;

class Parent {

    public long overRiding() {
        System.out.println("parent overriding");
        return 0;
    }

    public void overRiding(float sahid) {
        System.out.println("parent overide arg called");
    }
}

class Child extends Parent {

    @Override
    public long overRiding() {
        System.out.println("child overriding...");
        return 0;
    }

    public void overRiding(Integer sahid) {
        System.out.println("child overide arg called");
    }

}

public class Overriding_Method {
    public static void main(String[] args) {

        Parent parent = new Child();
        // if using parent ref to call over riding method then it
        // check declaration from parent but called child method

        // if parent and child have co variant type then overriding not happened.

        System.out.println("-------------------------");
        parent.overRiding();  //  need declaration as parent but used definition as child.
        parent.overRiding(1);  //  need declaration as parent but used definition as child.


        Child child1 = new Child();
        // if parent and child have co variant type then overriding not happened.


        child1.overRiding(1); // overloaded 1 is a int type can be promoted into float
        child1.overRiding(new Integer(1));  // overloaded

    }
}
