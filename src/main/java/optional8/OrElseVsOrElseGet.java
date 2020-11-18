package optional8;

import java.util.Optional;

public class OrElseVsOrElseGet {

    public int called() {
        System.out.println("called");
        return -1;
    }

    public static void main(String[] args) {

        OrElseVsOrElseGet orElseVsOrElseGet = new OrElseVsOrElseGet();

        System.out.println("OrElse statement");
        System.out.println(Optional.of(10).orElse(orElseVsOrElseGet.called()));

        System.out.println("\nOrElseGet statement");
        System.out.println(Optional.of(10).orElseGet(orElseVsOrElseGet::called));

    }
}
