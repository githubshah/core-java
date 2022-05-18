package learning.core.constructorchaining;

public class StaticBlockVsStaticVar {
    static int field = 10;

    static {
        System.out.println("static field set to: " + StaticBlockVsStaticVar.field);
    }

    {
        StaticBlockVsStaticVar.field = 30;
        System.out.println("init field set to: " + StaticBlockVsStaticVar.field);
    }

    public StaticBlockVsStaticVar(int field) {
        StaticBlockVsStaticVar.field = field;
        System.out.println("cons field set to: " + StaticBlockVsStaticVar.field);
    }

    public static void main(String[] args) {
        new StaticBlockVsStaticVar(100);
    }

}
