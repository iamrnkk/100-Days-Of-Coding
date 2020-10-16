// This problem was asked by Spotify.
// There are N couples sitting in a row of length 2 * N. They are currently ordered randomly,
// but would like to rearrange themselves so that each couple's partners can sit side by side.
// What is the minimum number of swaps necessary for this to happen?


public class Day4 {

	//function to link couples together
	//i.e if refArr = [1 8 5 4 6 9 14 13 12 10 2 11 18 17 16 15]
	//then pair =     [8 1 4 5 9 6 13 14 10 12 11 2 17 18 15 16]
	//now refArr[i]'s pair is pair[i] and we can access them using same index
    static void linkPeople(int pair[],int refArr[])
    {
        for(int i=0; i< refArr.length; i++)
        {
            if(i%2 == 0)
                pair[i]= refArr[i+1];
            else
                pair[i]= refArr[i-1];

            }
        }

    //function that matches couples together
    static void sortPair(int arrToSort[],int pair[],int refArr[],int m)
    {
        //counts the number of swaps
    	int swaps= 0;

    	//i loop is for accessing 1 person from each pair from arrToSort
        for(int i=0; i< m; i=i+2)
        {

        	//j loop is for accessing each person from refArr
        	//and search for the pair by looking into pairs
        	for(int j=0;j< m; j++)
            {
                //when you get the same person from arrToSort in refArr
        		if(arrToSort[i]==refArr[j])
                {
                    //get the person's pair from pair by using same index j as in refArr
        			int currentPair = pair[j];

        			//now find the pair in arrToSort and match them
                    for(int k=i+1; k<m;k++)
                    {
                        //when you find the position of pair , swap it next to person
                    	if(arrToSort[k]==currentPair && arrToSort[i+1]!=currentPair)
                        {
                            int t= arrToSort[i+1];
                            arrToSort[i+1]= arrToSort[k];
                            arrToSort[k]= t;
                            //yes, now they are happy couple.xD
                            swaps++;
                        }
                    }
                }
            }
        }
        System.out.println("Swaps= "+swaps);
    }

    //Driver code
    public static void main(String[] args) {

        int refArr []= {1,8,4,5,9,6,2,11,10,12,13,14,15,16,17,18};
        int arrToSort []= {1,4,5,6,8,9,14,12,13,11,2,10,18,16,17,15};
        int m = refArr.length;
        int pair []= new int[m];

        System.out.println("Before Sorting: ");
        for(int j=0;j< m; j++)
            System.out.print(arrToSort[j]+" ");
        System.out.println();
        linkPeople(pair,refArr);
        sortPair(arrToSort,pair,refArr,m);
        System.out.println("After Sorting:");
        for(int j=0;j< m; j++)
            System.out.print(arrToSort[j]+" ");
        }

    }
