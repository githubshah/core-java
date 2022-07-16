package learning.core.java8.optional8;

import java.util.Optional;

public class OrElseVsOrElseGet {

    public static void main(String[] args) {

        OrElseVsOrElseGet orElseVsOrElseGet = new OrElseVsOrElseGet();

        System.out.println("OrElse statement");
        System.out.println(Optional.of(10).orElse(orElseVsOrElseGet.called())); // consumer inside orElse will run even if the else condition will not true.

        System.out.println("\nOrElseGet statement");
        System.out.println(Optional.of(10).orElseGet(orElseVsOrElseGet::called));

        System.out.println("\nOrElse statement null");
        System.out.println(Optional.ofNullable(null).orElse(orElseVsOrElseGet.called())); // call orElse part will execute before checking conditions.

        System.out.println("\nOrElseGet statement null");
        System.out.println(Optional.ofNullable(null).orElseGet(orElseVsOrElseGet::called));


    }

    public int called() {
        System.out.println("called");
        return -1;
    }
}
