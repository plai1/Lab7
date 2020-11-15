import java.util.*;

public class FindJudge
{
	//creates count list to tally amount of times the number is connected
	//creates connects list to tally amounts of connections each person has
	static int[] counts;
	static int[] connects;

	public static int findJudge(int num, int [][] trust)
	{
		int largeCount = 0; //set largest count to zero
		int position = 0; //set position to zero
		counts = new int[num+1]; //set counts size to N + 1
		connects = new int[num+1]; //set connects size to N+1

		//check whether the number of people in town is two and 
		//there is only one connection
		if (num == 2 && trust.length == 1){
			return trust[0][1];
		} 

		//goes through each table to tally the trusted number
		for(int i = 0; i < trust.length; i++){
				int pos1 = trust[i][0];
				int pos2 = trust[i][1];
				connects[pos1] += 1;
				counts[pos2] += 1;

				if(i == trust.length-1) //when loop reaches the end, loops through counts and connects list
				{
					for(int j = 0; j < trust.length; j++)
					{
						if(counts[j] > largeCount){ //searches for the largest number in counts list
							largeCount = counts[j]; //set the tally to largeCount if it is larger that current largeCount
							position = j; //set the variable to the number that belongs to largeCount
						}
					}
				}
		}

		if(trust.length < num)//if Number of people is less than the number of connections in the 2d list
		{	
			if (largeCount == num-1) //if largeCount is one less than the number of people
				return position;
			else
				return -1;
		} else {
			if(largeCount == num-1 && connects[position] == 0) //if largCount is one less that the number of people and the number does not have any connnections
				return position;
			else
				return -1;
		}
	};

	public static String printList(int[] counts){
		return (Arrays.toString(counts));
	}


	public static void main(String args[])
	{
		int[][] people = {{1, 3}, {1, 4}, {2, 3}, {2, 4}, {4, 3}};
		System.out.println(findJudge(4, people));
		System.out.println("Count list: " + printList(counts));
		System.out.println("Connection List: " + printList(connects));
	}
}