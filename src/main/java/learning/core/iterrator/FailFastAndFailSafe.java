package learning.core.iterrator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class FailFastAndFailSafe {

    public static void main(String[] args) {
        failfast();
        //iteratorRemove();
        //failSafe();
    }

    private static void failfast() {
        List<Integer> l = Arrays.asList(1, 2, 3, 4, 5);
        Iterator<Integer> iterator = l.iterator();
        while (iterator.hasNext()) {
            System.out.println(">> " + iterator.next());
            l.add(6); // fail fast exception
        }
    }

    private static void iteratorRemove() {
        List<String> loans = new ArrayList<>();
        loans.add("personal loan");
        loans.add("home loan");
        loans.add("auto loan");
        loans.add("credit line loan");
        loans.add("mortgage loan");
        loans.add("gold loan"); // printing ArrayList before removing any element
        System.out.println(loans); // removing element using ArrayList's remove method during iteration // This will throw ConcurrentModification
        Iterator<String> itr = loans.iterator();
        while (itr.hasNext()) {
            String loan = itr.next();
            if (loan.equals("personal loan")) {
                itr.remove();
            }
        } // printing ArrayList after removing an element
        System.out.println(loans);
    }

    static void failSafe() {
        List<Integer> l = new CopyOnWriteArrayList();
        l.add(1);
        l.add(2);
        Iterator<Integer> iterator = l.iterator();
        while (iterator.hasNext()) {
            System.out.println(">> " + iterator.next());
            l.add(3); // fail safe
        }

        System.out.println(l.size());  // 4  means [1,2,3,3]
    }
}
