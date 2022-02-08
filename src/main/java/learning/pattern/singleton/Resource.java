package learning.pattern.singleton;

// Java code for Bill Pugh Singleton Implementaion
public class Resource {
    private Resource() {
        // private constructor
    }

    // Inner class to provide instance of class
    private static class Holder {
        private static final Resource INSTANCE = new Resource();
    }

    public static Resource getInstance() {
        return Holder.INSTANCE;
    }
} 
