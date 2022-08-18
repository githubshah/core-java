package learning.core.D_overiding;// Java program to illustrate the fact that
// runtime polymorphism cannot be achieved
// by data members

// class A
class A {
    int x = 10;

    void print() {
        System.out.println("parent " + x);
    }
}

// class B
class B extends A {
    int x = 20;

    @Override
    void print() {
        System.out.println("child " + x);
    }
}

// Driver class
public class Override_Variable {
    public static void main(String[] args) {
        A a = new B(); // object of type B

        // Data member of class A will be accessed
        System.out.println(a.x);
        a.print();
    }
}
