package core.enum8;

//compile but will not work
enum EnumWithAccess {;
    private int a1;
    public int a2;

    EnumWithAccess(int a1, int a2) {
        this.a1 = a1;
        this.a2 = a2;
    }
}

class EnumWithAccessModifier{
    public static void main(String[] args) {
    }
}
