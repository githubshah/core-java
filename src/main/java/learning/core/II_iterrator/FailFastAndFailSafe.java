package learning.core.II_iterrator;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

public class FailFastAndFailSafe {

    public static void main(String[] args) {
        //failfastArrayList();
        //failfastVector();
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
            loans.remove(0); //ConcurrentModificationException
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
            loans.remove(0); //ConcurrentModificationException
        }
        System.out.println(loans);
    }

    static void failSafe() {
        //List<Integer> loans = new ArrayList<>();
        CopyOnWriteArrayList<Integer> loans = new CopyOnWriteArrayList();
        loans.add(11);
        loans.add(22);
        loans.add(33);
        System.out.println(loans); // removing element using ArrayList's remove method during iteration // This will throw ConcurrentModification
        Iterator<Integer> itr = loans.iterator();
        while (itr.hasNext()) {
            itr.next();
            //itr.remove(); // UnsupportedOperationException (method not supportes by CopyOnWriteArrayList)
            loans.remove(0);
            loans.add(1);
        }
        System.out.println(loans);
    }
}
