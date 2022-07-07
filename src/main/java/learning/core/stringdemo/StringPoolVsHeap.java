package learning.core.stringdemo;

public class StringPoolVsHeap {

    public static void main(String[] args) {


        String a = "my";
        String b = "my";
        System.out.println((a == b) + " : " + a.equals(b));


        String c = new String(b);
        System.out.println((b == c) + " : " + b.equals(c));

        String d = new String("my");

        System.out.println((c == d) + " : " + c.equals(d));
    }
}
