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
	
	public Orders()
	{
		ordersMap = new HashMap<>();
	}
	
	public void record(String orderId)
	{
		ordersMap.put(++lastIndex,orderId);
	}
	
	public String getLast(int i)
	{
		return ordersMap.get(lastIndex-i);
	}
}

//Driver Code
public class Day70 
{
	public static void main(String args[])
	{
		Orders o= new Orders();
		
		o.record("4576");
		o.record("45124");
		o.record("4532");
		o.record("13476");
		o.record("45236");
		
		System.out.println(o.getLast(2));
	}
}