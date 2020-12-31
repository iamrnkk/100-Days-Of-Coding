// This problem was asked by Twitter.

// You run an e-commerce website and want to record the last N order ids in a log. Implement a data structure to accomplish this, with the following API:

//     record(order_id): adds the order_id to the log
//     get_last(i): gets the ith last element from the log. i is guaranteed to be smaller than or equal to N.

// You should be as efficient with time and space as possible.

import java.util.HashMap;

class Orders
{
	HashMap<Integer,String> ordersMap;
	int lastIndex=-1;
	int firstIndex=-1;
	int window;
	
	public Orders(int N)
	{
		window=N;
		ordersMap = new HashMap<>(window);
	}
	
	public void record(String orderId)
	{
		ordersMap.put(++lastIndex,orderId);
		
		if(firstIndex==-1) firstIndex=0;
		
		if(lastIndex-firstIndex >= window)
			ordersMap.remove(firstIndex++);
	}
	
	public String getLast(int i)
	{
		return ordersMap.get(lastIndex-i);
	}
}

public class Day70 
{
	public static void main(String args[])
	{
		Orders o= new Orders(3);
		
		o.record("4576");
		o.record("45124");
		o.record("4532");
		o.record("13476");
		o.record("45236");
		System.out.println(o.ordersMap);
		System.out.println(o.getLast(2));
	}
}