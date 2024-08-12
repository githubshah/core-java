package learning.pattern.singleton.nested;// Java Program to demonstrate Thread-Safety
// in NestedInitialization

class Singleton {

	static {
		System.out.println("outer static class load");
	}

	{
		System.out.println("singleton class constructor is going to call...");
	}

	private Singleton()
	{
		System.out.println("Singleton constructor call, Object created");
	}

	// This method returns Object, does not create it
	// Object is created on initialization of Nested class
	// which happens only once.
	public static Singleton getInstance()
	{
		return Nested.Instance;
	}

	private static class Nested {
		static {
			System.out.println("inner static class load");
		}

		static Singleton Instance = new Singleton();
	}

}

public class SingletonDemo {
	public static void main(String[] args)
	{

		// Thread 1 will call getInstance
		Thread t1 = new Thread(() -> {
			Singleton a = Singleton.getInstance();
			System.out.println(a);
		});

		// Thread 2 will also call getInstance
		Thread t2 = new Thread(() -> {
			Singleton b = Singleton.getInstance();
			System.out.println(b);
		});

		// Start both the Threads
		t1.start();
		t2.start();


	}
}
