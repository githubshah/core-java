package learning.core.G_enum8;

//compile but will not work
enum EnumWithAccess {
    ;
    public static int a2;
    private static int a1;

    public static int getA1() {
        return a1;
    }

    public static int getA2() {
        return a2;
    }

    public static void setA2() {
        a2 = 1;
    }
}

class EnumWithAccessModifier {
    public static void main(String[] args) {
        EnumWithAccess.setA2();
        System.out.println(EnumWithAccess.getA2());
    }
}
