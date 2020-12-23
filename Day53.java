// This problem was asked by Amazon.

// Given a N by M matrix of numbers, print out the matrix in a clockwise spiral.

// For example, given the following matrix:

// [[1,  2,  3,  4,  5],
//  [6,  7,  8,  9,  10],
//  [11, 12, 13, 14, 15],
//  [16, 17, 18, 19, 20]]

// You should print out the following:

// 1
// 2
// 3
// 4
// 5
// 10
// 15
// 20
// 19
// 18
// 17
// 16
// 11
// 6
// 7
// 8
// 9
// 14
// 13
// 12


public class Day53 
{
	public static void printSpiral(int[][] matrix, int startRow, int endRow, int startCol, int endCol)
	{
		// base case
		if (endRow<=startRow || endCol <= startCol)
			return;
		
		// printing current first row (left to right)
		for(int i=startRow; i<=endCol; i++)
			System.out.println(matrix[startRow][i]);
		
		// printing current last column (up to down)
		for(int j= startRow+1; j <=endRow; j++)
			System.out.println(matrix[j][endCol]);
		
		if(startRow != endRow)
		{
			// printing current last row (right to left)
			for(int i= endRow; i>= startCol; i--)
				System.out.println(matrix[endRow][i]);
		}
		
		if(startCol != endCol)
		{
			// printing current first column (down to up)
			for(int j= endRow-1; j > startRow; j--)
				System.out.println(matrix[j][startCol]);
		}
		
		printSpiral(matrix, startRow+1, endRow-1, startCol+1, endCol-1);
	}
	
	// Driver code
	public static void main(String args[])
	{
		int matrix[][]= {{1,  2,  3,  4,  5},
		                 {6,  7,  8,  9,  10},
		                 {11, 12, 13, 14, 15},
		                 {16, 17, 18, 19, 20}};
		
		printSpiral(matrix,0,matrix.length-1,0, matrix[0].length-1);
	}
}