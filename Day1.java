// This problem was recently asked by Google.
// Given a list of numbers and a number k, return whether any two numbers from the list add up to k.
// For example, given [10, 15, 3, 7] and k of 17, return true since 10 + 7 is 17.

import java.io.*;
class Day1
{
  // function to check if there is a pair that sums upto k in an array
  static boolean check(int a[],int k)
  {
    // i loop takes a no. from array one by one
    for (int i=0; i < a.length; i++)
    {
      // j loop takes next no.'s from array so that it can be matched
      for (int j=i+1; j < a.length; j++)
      {
        // now if the pair adds upto k
        if (a[i]+a[j]==k)
          return true;
      }
    }

  // if iterations are over and nothing is returned yet,
  // that means there is no such pair that adds upto k in an array
  return false;
}

// driver code
public static void main(String[] args)throws IOException
{
  BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

  System.out.println("Enter no. of elements");
  int arrl= Integer.parseInt(br.readLine());

  System.out.println("Enter value of k");
  int k= Integer.parseInt(br.readLine());

  int a[] = new Int[arrl];
  System.out.println("Enter array");
  for (int i=0; i < arrl; i++)
    a[i] = Integer.parseInt(br.readLine());

  System.out.println(check(a,k));
}
}