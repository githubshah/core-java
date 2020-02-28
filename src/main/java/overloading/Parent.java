package overloading;

import java.io.IOException;

public abstract class Parent {
    private int intPrimitive;
    private Integer intWrapper;

    private boolean boolPrimitive;
    private Boolean boolWrapper;

    private long longPrimitive;
    private Long longWrapper;

    static {
        System.out.println("Parent static block called");
    }

    {
        System.out.println("Parent init block called");
    }

    public Parent(){
        System.out.println("Parent Default constructor called");
    }

    public Parent(int i) {
        System.out.println("int: " + i);
    }

    public Parent(Integer i) {
        System.out.println("Integer: " + i);
    }

    public Parent(long l) {
        System.out.println("long: " + l);
    }

    public Parent(Long l) {
        System.out.println("Long: " + l);
    }

    public Parent(int i, long l) {
        System.out.println("int, long: " + i + ", " + l);
    }

    public Parent(Object o) {
        System.out.println("Object called: " + o);
    }

    public Parent(String o) {
        System.out.println("String called: " + o);
    }

    public Parent(String s, Object o) {
        System.out.println("String object called: " + o);
    }

    public Parent(Object o, String s) {
        System.out.println("Object String called: " + o);
    }

    public Parent(Object o1, Object o2) {
        System.out.println("Object Object called: ");
    }

    public Parent(String s1, String s2) {
        System.out.println("String String called: ");
    }

    public void overRiding() {
        System.out.println("parent overriding");
    }

    public void overRidingArg(Number sahid) {
        System.out.println("23parent overide arg called");
    }
}

