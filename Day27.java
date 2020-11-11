// Given a 32-bit integer, return the number with its bits reversed.
// For example, given the binary number 1111 0000 1111 0000 1111 0000 1111 0000,
// return 0000 1111 0000 1111 0000 1111 0000 1111.

import java.text.DecimalFormat;

public class Day27 
{
	public static int swapBits(int num)
	{
		int swappedNum=0, n= num;
		
		for(int i=0; i<2; i++)
		{
			// extracting 8 bit(last 2 digits) at once 
			int r= n %100;
			
			// shifting 4 bits at once and then ORing it.
			int temp =((r & 0xF0 )>>4) | ((r & 0x0F )<<4);
			swappedNum= swappedNum+ (temp * (int)Math.pow(100, i));
			
			// updating
			n= n/100;
		}
		
		return swappedNum;
	}
	
	public static void main(String args[])
	{
		int num = 15;
		int swappedNum =swapBits(num);
		
		// coverting to binary
		int binNum = Integer.parseInt(Integer.toUnsignedString(num,2));
		int binSwappedNum = Integer.parseInt(Integer.toUnsignedString(swappedNum,2));
		
		// for printing all 32 bits
		DecimalFormat df = new DecimalFormat("0000000000000000");
		
		System.out.println(df.format(binNum));
		System.out.println(df.format(binSwappedNum));
	}
}