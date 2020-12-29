package learning.core.overiding;

import java.io.IOException;

class Fruit {
    public void fun(long a) {
        System.out.println("parent called: " + a);
    }
}

class Mango extends Fruit {
//    public void fun(Integer a) {
//        System.out.println("child called: " + a);
//    }

    @Override
    public void fun(long a) {
        System.out.println("child123 called: " + a);
    }
}

public class Overriding {
    public static void main(String str[]) {
        Fruit f = new Mango();
        f.fun(1);

        Mango m = new Mango();
        m.fun(1);
    }
}


class Person {
    void fun(Integer a) throws Exception {
    }
}

class Emp extends Person {
    @Override
    void fun(Integer a) throws IOException{
    }
}









