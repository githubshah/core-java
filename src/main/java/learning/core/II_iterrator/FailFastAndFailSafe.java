package learning.core.II_iterrator;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

public class FailFastAndFailSafe {

    public static void main(String[] args) {
        //failfastArrayList();
        //failfastVector();
        //failSafeVector(); // infinity loop
        failSafe();
    }

    private static void failfastArrayList() {
        List<Integer> loans = new ArrayList<>();
        loans.add(11);
        loans.add(22);
        loans.add(33);
        System.out.println(loans); // removing element using ArrayList's remove method during iteration // This will throw ConcurrentModification
        Iterator<Integer> itr = loans.iterator();
        while (itr.hasNext()) {
            itr.next();
            itr.remove();
            //itr.remove(); not allowed
        }
        System.out.println(loans);
    }

    private static void failfastVector() {
        Vector<Integer> loans = new Vector<>();
        loans.add(11);
        loans.add(22);
        loans.add(33);
        System.out.println(loans); // removing element using ArrayList's remove method during iteration // This will throw ConcurrentModification
        Iterator<Integer> itr = loans.iterator();
        while (itr.hasNext()) {
            itr.next();
            itr.remove();
            //itr.remove(); not allowed
        }
        System.out.println(loans);
    }

    private static void failSafeVector() {
        Vector<Integer> v = new Vector<>();
        // Adding elements to the end
        v.add(11);
        v.add(22);
        v.add(33);
        // Creating an object of enum
        Enumeration<Integer> en = v.elements();

        while (en.hasMoreElements()) {
            Integer loan = en.nextElement();
            v.remove(0);
            v.remove(0);
            v.remove(0);
        }
        System.out.println(v);
    }

    static void failSafe() {
        CopyOnWriteArrayList<Integer> loans = new CopyOnWriteArrayList();
        loans.add(11);
        loans.add(22);
        loans.add(33);
        System.out.println(loans); // removing element using ArrayList's remove method during iteration // This will throw ConcurrentModification
        Iterator<Integer> itr = loans.iterator();
        while (itr.hasNext()) {
            Integer loan = itr.next();
            //itr.remove(); //throw err fail fast
            loans.add(1);

        } // printing ArrayList after removing an element
        System.out.println(loans);
    }
}
