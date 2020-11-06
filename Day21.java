// Given an unsigned 8-bit integer, swap its even and odd bits. The 1st and 2nd bit should be swapped, the 3rd and 4th bit should be swapped, and so on.
// For example, 10101010 should be 01010101. 11100010 should be 11010001.
// Bonus: Can you do this in one line?

import java.text.DecimalFormat; 
public class Day21 {
	
	public static byte swapBits(byte num)
	{
		// using bitwise operators for shifting even and odd bits
		// right and left respectively,
		// then ORing the shifted bits to get swapped bits
		return (byte)((num & 0xAA) >> 1 | (num & 0x55) << 1);
	}
	
	// Driver code
	public static void main(String args[])
	{
		byte num = 44;
		byte swappedNum =swapBits(num);
		
		// coverting to binary
		int binNum = Integer.parseInt(Integer.toUnsignedString(num,2));
		int binSwappedNum = Integer.parseInt(Integer.toUnsignedString(swappedNum,2));
		
		// for printing all 8 digits(bits)
		DecimalFormat df = new DecimalFormat("00000000");
		
		System.out.println(df.format(binNum));
		System.out.println(df.format(binSwappedNum));
	}
}