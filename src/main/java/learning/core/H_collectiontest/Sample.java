package learning.core.H_collectiontest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Sample {

    public static void main(String args[]) {

        String cplus = "C++";

        List outer = new ArrayList();
        outer.add(cplus);
        cplus = "my job";   // do not make any impact on update.
        outer.add("C");
        outer.add("Python");


        List inner = new ArrayList();
        inner.add("Java");

        outer.add(inner); // adding List to outer List

        // read only list
        // List unmodifiable1 = Collections.unmodifiableList(null); // null pointer
        List unmodifiable = Collections.unmodifiableList(outer);

        System.out.println("List before modification : " + unmodifiable);

        List myInner = (List) unmodifiable.get(3);
        myInner.add("JEE");
        myInner.add("Java ME");

        //unmodifiable.add("as"); // can not modify

        System.out.println("List after modification : " + unmodifiable);

    }
}
