package thread_frame.thread_safty;

class WithSynchronized {
	synchronized void sum(int n) 
	{ 

		// Creating a thread instance 
		Thread t = Thread.currentThread(); 
		for (int i = 1; i <= 5; i++) { 
			System.out.println( 
				t.getName() + " : " + (n + i)); 
		} 
	} 
} 

// Class B extending thread class 
class B extends Thread { 

	// Creating an object of class A 
	WithSynchronized withSynchronized = new WithSynchronized();
	public void run() 
	{ 

		// Calling sum() method 
		withSynchronized.sum(10);
	} 
} 
class Test { 
	public static void main(String[] args) 
	{ 

		// Creating an object of class B 
		B b = new B(); 

		// Initializing instance t1 of Thread 
		// class with object of class B 
		Thread t1 = new Thread(b); 

		// Initializing instance t2 of Thread 
		// class with object of class B 
		Thread t2 = new Thread(b); 

		// Intializing thread t1 with name 
		//'Thread A' 
		t1.setName("Thread A"); 

		// Initializing thread t2 with name 
		//'Thread B' 
		t2.setName("Thread B"); 

		// Starting thread instance t1 and t2 
		t1.start(); 
		t2.start(); 
	} 
}
