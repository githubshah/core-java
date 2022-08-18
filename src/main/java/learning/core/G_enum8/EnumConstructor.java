package learning.core.G_enum8;

enum MaleSize {
    SMALL("The size is small.");

    private final String size;

    MaleSize(String x) {
        this.size = x;
    }

    public String getSize() {
        return size;
    }
}

enum FemaleSize {

    // enum constants calling the enum constructors
    SMALL("The size is small."),
    MEDIUM("The size is medium."),
    LARGE("The size is large."),
    EXTRALARGE("The size is extra large.");

    private final String size;

    // private enum constructor
    private FemaleSize(String pizzaSize) {
        this.size = pizzaSize;
    }

    public String getSize() {
        return size;
    }
}

public class EnumConstructor {

    public static void main(String[] args) {

        FemaleSize female = FemaleSize.SMALL;
        System.out.println(female.getSize());

        FemaleSize femaleSize = null;

        System.out.println(femaleSize.equals(female)); // null pointer exception
        System.out.println(femaleSize == female);

        MaleSize male = MaleSize.SMALL;
        System.out.println(male.getSize());

        System.out.println(female.equals(male));
        //System.out.println(female == male); // compile time type compatible error

    }

}
