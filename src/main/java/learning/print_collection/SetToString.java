package learning.print_collection;

import java.util.HashSet;
import java.util.Set;

public class SetToString {

    public static void main(String[] args) {

        Set<String> set = new HashSet<>();
        set.add("1");
        set.add("2");
        set.add("3");

        System.out.println(set);
    }
}
