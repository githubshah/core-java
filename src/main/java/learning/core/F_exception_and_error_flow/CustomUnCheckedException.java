package learning.core.F_exception_and_error_flow;

class IncorrectFileExtensionException extends RuntimeException {
    public IncorrectFileExtensionException(String errorMessage, Throwable err) {
        super(errorMessage, err);
    }
}

public class CustomUnCheckedException {
    public static void main(String[] args) {
        throw new IncorrectFileExtensionException("hello", new Throwable());
    }
}

