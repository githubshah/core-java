package core.overloading;

public class Overloading {
    public void fun(boolean boolean1) {
        System.out.println("boolean " + boolean1);
    }

    public void fun(char char1) {
        System.out.println("char " + char1);
    }

    public void fun(byte byte1) {
        System.out.println("byte " + byte1);
    }

    public void fun(short short1) {
        System.out.println("short " + short1);
    }

    public void fun(int int1) {
        System.out.println("int " + int1);
    }

    public void fun(long long1) {
        System.out.println("long " + long1);
    }

    public void fun(float float1) {
        System.out.println("float " + float1);
    }

    public void fun(double double1) {
        System.out.println("double " + double1);
    }

    public void fun(Boolean Boolean) {
        System.out.println("Boolean " + Boolean);
    }

    public void fun(Integer Integer) {
        System.out.println("Integer " + Integer);
    }

    public void fun(Long Long) {
        System.out.println("Long " + Long);
    }

    public void fun(Float Float) {
        System.out.println("Float " + Float);
    }

    public void fun(Double Double) {
        System.out.println("Double " + Double);
    }

    public void fun(Number Number) {
        System.out.println("Number " + Number);
    }

    public void fun(Object Object) {
        System.out.println("Object " + Object);
    }

    public void fun(String String) {
        System.out.println("String " + String);
    }

    public void fun(String String, Object Object) {
        System.out.println("StringObject " + String);
    }

    public void fun(Object Object, String String) {
        System.out.println("ObjectString " + String);
    }

    public void fun(int i, int l) {
        System.out.println("intint " + i);
    }

    public void fun(int i, long l) {
        System.out.println("intlong " + i);
    }

    public void fun(long i, int l) {
        System.out.println("longint " + i);
    }

    public void fun(long i, long l) {
        System.out.println("longlong " + i);
    }

    public void fun(Number i, Number l) {
        System.out.println("numbernumber " + i);
    }

    public void fun(Number i, Object l) {
        System.out.println("numbernumber " + i);
    }

    public void fun(Object i, Number l) {
        System.out.println("numbernumber " + i);
    }

    public void fun(Object i, Object l) {
        System.out.println("objobj " + i);
    }

    public static void main(String[] args) {
        Overloading overloading = new Overloading();
        overloading.fun(1, 2);
    }
}
