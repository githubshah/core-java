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

    public void fun(Boolean Boolean1) {
        System.out.println("Boolean " + Boolean1);
    }

    public void fun(Integer Integer1) {
        System.out.println("Integer " + Integer1);
    }

    public void fun(Long Long1) {
        System.out.println("Long " + Long1);
    }

    public void fun(Float Float1) {
        System.out.println("Float " + Float1);
    }

    public void fun(Double Double1) {
        System.out.println("Double " + Double1);
    }

    public void fun(Number number1) {
        System.out.println("Number " + number1);
    }

    public void fun(Object Object1) {
        System.out.println("Object " + Object1);
    }

    public static void main(String[] args) {
        Overloading overloading = new Overloading();
        overloading.fun(true);
    }
}
