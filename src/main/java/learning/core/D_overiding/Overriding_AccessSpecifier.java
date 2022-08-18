package learning.core.D_overiding;

class A1 {

    private void childCanCNotItOverride() {
    }

    void childCanChangeItToFromDefaultTo_ProtectedOr_Public() {
    }

    protected void childCanChangeItTo_Public() {
    }

    public void childCanNotChangeItsAccessMode() {
    }
}

class B1 extends A1 {
    @Override
    public void childCanNotChangeItsAccessMode() {

    }

    @Override
    public void childCanChangeItTo_Public() {

    }

    @Override
    //protected void childCanNotChangeFromDefaultToPrivateOrProtectedOrPublic() {
    public void childCanChangeItToFromDefaultTo_ProtectedOr_Public() {

    }
}

public class Overriding_AccessSpecifier {
    public static void main(String[] args) {
        A1 a1 = new B1();
    }

}
