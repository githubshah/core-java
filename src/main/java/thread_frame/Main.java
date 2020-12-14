package thread_frame;// Java program to Use exceptions with thread 

/* Note: Dont confuse main method with Main class*/

// Importing Classes/Files

// Child Class(Thread) is inherited 
// from parent Class(GFG) 
class CatchChildThreadException extends Thread {
	public void run() 
	{ 
		System.out.println("Throwing in "
						+ "MyThread"); 
		throw new RuntimeException(); 
	} 
} 

// Main driver method 
public class Main { 
	public static void main(String[] args) 
	{ 
		CatchChildThreadException t = new CatchChildThreadException();
		t.start(); 

		// try block to deal with exception 
		try { 
			Thread.sleep(2000); 
		} 

		// catch block to handle the exception 
		catch (Exception x) { 
			// Print command when exception encountered 
			System.out.println("Exception" + x); 
		} 

		// Print command just to show program 
		// run successfully 
		System.out.println("Completed"); 
	} 
}