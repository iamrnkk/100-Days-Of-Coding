// Implement the singleton pattern with a twist.
// First, instead of storing one instance, store two instances. And in every even call of getInstance(), 
// return the first instance and in every odd call of getInstance(), return the second instance.

class Singleton
{
	private Singleton() {}
	
	private static Singleton first= null;
	private static Singleton second= null;
	
	static int count= 0;
	
	public static Singleton getInstance()
	{
		if (count==0)
			first= new Singleton();
		else if (count==1)
			second= new Singleton();
		
		count++;
		
		return (count%2==0)?first:second;
	}
	
}

public class Day35 
{
	public static void main(String args[])
	{
	Singleton ob1= Singleton.getInstance();
	Singleton ob2= Singleton.getInstance();
	}
}
