package core.multiThreading;// Java program to Use exceptions with thread

/* Note: Dont confuse main method with Main_ColorAbstractMethod class*/

// Importing Classes/Files

// Child Class(Thread) is inherited 
// from parent Class(GFG) 
class CatchChildThreadException extends Thread {
    public void run() {
        System.out.println("Throwing in MyThread");
        throw new RuntimeException("WTF");
    }
}

// Main_ColorAbstractMethod driver method
public class UncaughtExceptionHandlerTest {

    //Thread.UncaughtExceptionHandler h = (th, ex) -> System.out.println("Uncaught exception: " + ex);

    public static void main(String[] args) {
        // try block to deal with exception
        CatchChildThreadException t = new CatchChildThreadException();
        t.setUncaughtExceptionHandler((th, ex) ->
            System.out.println("Uncaught exception: " + ex));
        t.start();

        try {
            Thread.sleep(2000);
        }
        // catch block to handle the exception
        catch (Exception x) {
            // Print command when exception encountered
            System.out.println(">>Exception" + x);
        }

        // Print command just to show program
        // run successfully
        System.out.println("Completed");
    }
}
