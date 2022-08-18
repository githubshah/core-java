package learning.core.constructorchaining;

public class StaticBlockVsStaticVar {
    static int field = 10;

    static {
        System.out.println("static-block-1 field set to: " + StaticBlockVsStaticVar.field);
    }

    static {
        System.out.println("static-block-2 field set to: " + StaticBlockVsStaticVar.field);
    }

    {
        StaticBlockVsStaticVar.field = 30;
        System.out.println("init-block-1 field set to: " + StaticBlockVsStaticVar.field);
    }

    {
        StaticBlockVsStaticVar.field = 40;
        System.out.println("init-block-2 field set to: " + StaticBlockVsStaticVar.field);
    }

    public StaticBlockVsStaticVar(int field) {
        StaticBlockVsStaticVar.field = field;
        System.out.println("constructor field set to: " + StaticBlockVsStaticVar.field);
    }

    public static void main(String[] args) {
        new StaticBlockVsStaticVar(100);
    }

}
