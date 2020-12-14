package core.multiThreading;// Java program to illustrate

// join must be followed by start method.
// means first call start and then join
public class ThreadJoin extends Thread {
	public ThreadJoin(String name) {
		super(name);
	}

	public void run()
	{
		System.out.println("geeks ");
		try {
			Thread.sleep(3000);
		}
		catch (InterruptedException ie) {
		}
		System.out.println("completed "+Thread.currentThread().getName());
	}
	public static void main(String[] args)
	{
		ThreadJoin c1 = new ThreadJoin("one");
		ThreadJoin c2 = new ThreadJoin("two");

		c1.start();
		try {
			c1.join(); // Waiting for c1 to finish
		}
		catch (InterruptedException ie) {
		}

		c2.start();
		try {
			c2.join(); // Waiting for c2 to finish
			c2.join(); // no exception
		}
		catch (InterruptedException ie) {
			System.out.println(ie);
		}

		System.out.println("Main thread over");
	}
} 
