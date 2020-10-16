// Given a string with repeated characters, rearrange the string so that no two adjacent characters are the same.
// If this is not possible, return None.
// For example, given "aaabbc", you could return "ababac". Given "aaab", return None.

import java.util.Comparator;
import java.util.PriorityQueue;

class KeyComparator implements Comparator<Key> {

      // Overriding method to set priority according to frequency
      public int compare(Key k1, Key k2)
      {
             if (k1.freq < k2.freq)
                 return 1;
             else if (k1.freq > k2.freq)
                 return -1;
             return 0;
      }
}

//This class defines the structure of each element inside priority queue
class Key {

	  int freq;
      char c;

      Key(int freq, char c)
      {
          this.freq = freq;
          this.c = c;
      }
}

public class Day5 {

      // Function to re-arrange String
      // so that no same character is adjacent
      static String changeString(String str)
      {
             int n = str.length();

             // Storing frequencies of all characters in string in array count
             int count[] = new int[26];
             for (int i = 0; i < n; i++)
                  count[str.charAt(i) - 'a']++;

              // Now everything is set, let's insert
              // all characters with their frequencies
              // into PriorityQueue pq
              PriorityQueue<Key> pq = new PriorityQueue<>(new KeyComparator());
              for (char c = 'a'; c <= 'z'; c++) {
                   int val = c - 'a';
                   if (count[val] > 0)
                       pq.add(new Key(count[val], c));
              }

              // resetting str to empty string
              // so that we can insert element from pq
              str = "" ;

              // works as the previously used element
              // initially there's no previous element so,
              //  ( char is '#' and it's frequency is '-1' )
              Key prevCharUsed = new Key(-1, '#');

              // traverse queue
              while (pq.size() != 0) {

                     // pop top element (head) from queue and
                     // add it to string.
                     Key charInUse = pq.poll();;
                     str = str + charInUse.c;

                     // If frequency of previously used character is not less
                     // than zero , then only add the character again with it's
                     //updated frequency
                     if (prevCharUsed.freq > 0)
                         pq.add(prevCharUsed);

                     // make currently used character as the previously used char
                     // and decrease its frequency by 1
                     (charInUse.freq)--;
                      prevCharUsed = charInUse;
              }

              // If length of the resultant string and original
              // string is not same then string is not valid
              if (n != str.length())
                  return "none";
              else
                  return str;
      }

      // Driver code
      public static void main(String args[])
      {
             String str = "aaabbbcdddf" ;
             System.out.println(changeString(str));
      }
}
