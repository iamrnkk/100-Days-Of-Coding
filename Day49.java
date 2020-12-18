
public class Day49 
{
	public static boolean hasSubsetSum(int numbers[], int targetSum)
	{
		boolean hasSum[][]= new boolean [targetSum+1][numbers.length+1];
		
		for (int i = 0; i <= hasSum[0].length; i++)
            hasSum[0][i] = false;
		
		for (int i = 0; i <= hasSum.length; i++)
            hasSum[i][0] = true;
		
		for(int i=0; i<hasSum.length;i++)
		{
			for(int j=0; j< hasSum[0].length;j++)
			{
//				if(j==0) hasSum[i][j]= false;
//				if(i==0) hasSum[i][j]= true;
				
				if(i< numbers[j-1])
					hasSum[i][j]= hasSum [i-1][j];
				
				if(i>= numbers[j-1])
				{
					boolean NumIncluded= hasSum[i- numbers[j-1]][j-1];
					boolean NumNotIncluded= hasSum[i-1][j];
					
					hasSum[i][j]= NumIncluded || NumNotIncluded;
				}
			}
		}
		
		return hasSum[targetSum][numbers.length];
	}
	
	public static boolean canBePartitioned(int numbers[])
	{
		int sum=0;
		
		for(int i= 0; i<numbers.length; i++)
			sum= sum+ numbers[i];
		
		if(sum%2==1) return false;
		if(sum==0) return true;
		
		return hasSubsetSum(numbers, sum/2);
	}
	
	public static void main(String args[])
	{
		int numbers[] = {15, 5, 20, 10, 35, 15, 10};
		
		System.out.println(canBePartitioned(numbers));
	}
}
