import java.util.*;

/**
 * 
 * @author Akshay
 * class Schedule has A 2-d array of arrival time and burst time.
 * And it will return the waiting time, turn around time, completion time, Average waiting time and maximum waiting time 
 * for first come first serve(FCFS) Scheduling.  
 */
public class Schedule {
	
	
	
	public static void main(String[] args) {
		int[][] arr = new int[20][2];
		int i,j,n;
		float totalWaitingTime=0;
		int[] completionTime = new int[100];
		int[] turnAroundTime = new int[100];
		int[] waitingTime = new int[100];
		Scanner input = new Scanner(System.in);
		System.out.print("\nEnter the Total no. of procecess :- ");
		n = input.nextInt();
		System.out.print("\nEnter the Array of Arrival time with Burst Time :- ");
		for(i=0;i<n;i++)
		{
			for(j=0;j<2;j++)
			{
				arr[i][j] = input.nextInt();
			}
		}
		int max = waitingTime[0];
		System.out.println("\nProcess\t\t\tArrival Time\t\t\tBurst Time\t\t\tCompletion Time\t\t\tTurn Around Time\t\tWaiting Time");
		for(i=0;i<n;i++)
		{
			if(i==0)
			{
				completionTime[i] = arr[i][1];
				turnAroundTime[i] = completionTime[i] - arr[i][0];
				waitingTime[i]    = 0; 
			}
			else
			{
				if(arr[i][0] < completionTime[i-1])
				{
					completionTime[i] = completionTime[i-1] + arr[i][1];
					turnAroundTime[i] = completionTime[i] - arr[i][0];
					waitingTime[i]    = turnAroundTime[i] - arr[i][1];
				}
				else
				{
					completionTime[i] = arr[i][0] + arr[i][1];
					turnAroundTime[i] = completionTime[i] - arr[i][0];
					waitingTime[i]    = turnAroundTime[i] - arr[i][1]; 			
				}
			}
			totalWaitingTime += waitingTime[i];
			if(waitingTime[i]>max)
			{
				max = waitingTime[i];
			}
			System.out.println(i+"\t\t\t\t"+arr[i][0]+"\t\t\t"+arr[i][1]+"\t\t\t\t"+completionTime[i]+"\t\t\t\t"+turnAroundTime[i]+"\t\t\t\t"+waitingTime[i]);
		}
		float avgWaitingTime = (float)(totalWaitingTime/n);
		System.out.println("\nThe Average Waiting Time ===>> "+avgWaitingTime);
		System.out.println("\nThe Maximum Waiting Time ===>> "+max);	
	}
}
