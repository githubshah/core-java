package overloading;

import java.io.IOException;

public class Child extends Parent{

    private int intPrimitive;
    private Integer intWrapper;

    private boolean boolPrimitive;
    private Boolean boolWrapper;

    private long longPrimitive;
    private Long longWrapper;

    static {
        System.out.println("Child static block called");
    }

    {
        System.out.println("Child init block called");
    }

    public Child(){
        System.out.println("Child Default constructor called");
    }

    public void overRiding(){
        System.out.println("child overriding");
    }

    public void overRidingArg(Integer sahid) {
        System.out.println("12child overide arg called");
    }
}

