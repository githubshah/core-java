package learning.core.F_exception_and_error_flow;

class IncorrectFileNameException extends Exception {
    public IncorrectFileNameException(String errorMessage) {
        super(errorMessage);
    }
}

public class CustomCheckedException {
    public static void main(String[] args) throws IncorrectFileNameException {
        throw new IncorrectFileNameException("hello");
    }
}

