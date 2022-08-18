package learning.core.D_overiding;


import java.io.IOException;

class P1 {
    void childNotForceToThrowException_and_childNotToThrowHigherExceptionThanItsParent() throws IOException {

    }

    void childOnlyThrowRuntimeExceptionIfThereIsNoExceptionThrowByItsParent(){

    }
}

class p2 extends P1 {
    @Override
    void childNotForceToThrowException_and_childNotToThrowHigherExceptionThanItsParent() {

    }

    @Override
    void childOnlyThrowRuntimeExceptionIfThereIsNoExceptionThrowByItsParent() throws RuntimeException{

    }

}

public class Overriding_Exceptions {
    public static void main(String[] args) {

    }
}
