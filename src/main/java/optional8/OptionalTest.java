package optional8;

import java.util.Optional;

public class OptionalTest {
    public static void main(String ui[]) {

        System.out.println("Simple call");

        if (fName() != null) {
            doSomething(fName());
        } else if (mName() != null) {
            doSomething(fName());
        } else if (lName() != null) {
            doSomething(lName());
        }

        System.out.println("imparative call 0");
        Optional.ofNullable(fName()).map(Optional::of)
            .orElseGet(() -> Optional.ofNullable(mName())).map(Optional::of)
            .orElseGet(() -> Optional.ofNullable(lName()))
            .ifPresent(OptionalTest::doSomething);

        System.out.println("imparative call 1");
        Optional.ofNullable(fName()).map(Optional::of)
            .orElseGet(() -> Optional.ofNullable(mName())).map(Optional::of)
            .orElseGet(() -> Optional.ofNullable(lName()))
            .ifPresent(OptionalTest::doSomething);


    }

    private static Optional<Car> get3() {
        return null;
    }

    private static Optional<Car> get2() {
        return null;
    }

    private static Optional<Car> get1() {
        return Optional.of(new Car());
    }

    private static String fName() {
        return null;
    }

    private static String mName() {
        return "middle name";
    }

    private static String lName() {
        return null;
    }

    private static void doSomething(String name) {
        System.out.println("Name: " + name);
    }

    private static Optional<Car> getCar() {
        Optional<Car> car = get1();
        if (car.isPresent()) {
            return car;
        }
        car = get2();
        if (car.isPresent()) {
            return car;
        }
        car = get3();
        if (car.isPresent()) {
            return car;
        }

        Optional.empty();

        get1().map(Optional::of)
            .orElseGet(() -> get2()).map(Optional::of)
            .orElseGet(() -> get3()).map(Optional::of);
        return car;
    }

}
