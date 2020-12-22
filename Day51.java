// This problem was asked by Facebook.

// Given a function f, and N return a debounced f of N milliseconds.

// That is, as long as the debounced f continues to be invoked, f itself will not be called for N milliseconds.

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

// runnable interface is used to execute code 
// of concurrent threads (tasks happening at same time) 
class Task implements Runnable
{
	long N;
	Day51 ob;
	public Task(Day51 ob,long N)
	{
		this.N= N;
		this.ob=ob;
	}
	
	// run() is like main() for threads
	public void run()
	{	
		try {
			
			// calling debounce method
			Day51.debounce(ob,N);
		} catch (InterruptedException e) {
			
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

public class Day51 
{
	// used for running pool of threads at same time (here 5 threads will run at a time)
	// if a code  of certain thread gets executed fully, new thread will replace it.
	static ExecutorService service = Executors.newFixedThreadPool(5);
	long lastCallingTime=0;
	
	// function that is to be debounced
	public void f()
	{
		System.out.println("You are AWESOME! ^-^");
		// resetting 
		lastCallingTime=0;
	}
	
	// 
	public static void debounce(Day51 callback, long N) throws InterruptedException
	{
		// if the function is not called before or it has been a while since the function was called last time
		if(callback.lastCallingTime==0 || callback.lastCallingTime + N < System.currentTimeMillis())
		{
			// get current time in milliseconds
			callback.lastCallingTime= System.currentTimeMillis();
			
			// delay for N milliseconds
			Thread.sleep(N);
			
			// Now call the function 
			callback.f();
		}
		
		// if function has already been called in less than N seconds
		else
		{
			System.out.println((System.currentTimeMillis()-callback.lastCallingTime)*1000+" "+ N );
			System.out.println("pass");
			return;
		}
	}
	
	// Driver Code
	public static void main(String args[])
	{
		Day51 ob =new Day51();
		
		// creating 10 threads 
		// 5 threads will run at the same time at most
		for(int i=0; i<10; i++)
		{
			service.execute(new Task(ob,3000));
		}
		
		service.shutdown();
	}
}