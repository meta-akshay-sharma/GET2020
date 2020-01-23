import java.util.*;

/**
 * 
 * @author Akshay
 * class Marksheet has Functions to calculate Maximum,Minimum,Average Marks From All grades and Percentage of Students Passed.
 */

public class Marksheet {

	/*Function to calculate average marks of students
	 * @param g[] is array of marks obtained by students
	 * @param n is the no. of students
	 * @return average marks as average/n
	 * */
	public float average(float grade[],int n)
	{
		float average=0;
		for(int i=0;i<n;i++)
			average = average + grade[i];
		return average/n;
	}

	/*Function to calculate max. obtained marks
	 * @param g[] is array of marks obtained by students
	 * @param n is the no. of students
	 * @return max is use to return max. marks 
	 * */
	public float max(float grade[],int n)
	{
		float max=grade[0];
		for(int i=1;i<n;i++)
		{
			if(max<grade[i])

				max=grade[i];
		}	
		return max;
	}

	/*Function to calculate minimum obtained marks
	 * @param g[] is array of marks obtained by students
	 * @param n is the no. of students
	 * @return min is use to return minimum marks
	 * */
	public float min(float grade[],int n)
	{
		float min=grade[0];
		for(int i=1;i<n;i++)
		{
			if(min>grade[i])
			{
				min=grade[i];
			}
		}
		return min;
	}

	/*Function to percentage of students pass
	 * @param g[] is array of marks obtained by students
	 * @param n is the no. of students
	 * @return percentage is use to return percentage of student pass
	 * */
	public float perOfStudPass(float grade[],int n)
	{
		float percentage;
		int count=0;
		for(int i=0;i<n;i++)
		{
			if(grade[i]>=40)
			{
				count++;
			}
		}
		percentage = count*100/n;
		return percentage;
	}

	public static void main(String[] args) {
		Marksheet obj= new Marksheet();
		Scanner input = new Scanner(System.in);
		int flow=0,nos=0;
		do
		{
			try
			{
				System.out.println("\nEnter the no. of students:");
				nos=input.nextInt();
			}
			catch(Exception e)
			{
				System.out.println("\nYou Entered A invalid Input !!!\nIt is Final Exit Please Run Code Again !!!!!");
				System.exit(0);
			}
			float grade[]=new float[nos];
			boolean check = true;
			for(int i=0;i<nos;i++)
			{
				check = true;
				while(check)
				{
					System.out.println("Enter the grade of student no. "+(i+1)+":");
					grade[i]=input.nextFloat();
					if(grade[i]>=0 && grade[i]<=100)
					{
						check = false;
					}
					else
					{
						System.out.println("You Have Entered Invalid Entry.\nPlease Enter Valid Input !!!!!");
						check = true;
					}
				}
			}
			float averageMarks = obj.average(grade,nos);
			float maxMarks = obj.max(grade,nos);
			float minMarks = obj.min(grade,nos);
			float studentPass = obj.perOfStudPass(grade,nos);
			System.out.println("\nThe average marks of the students is "+String.format ("%,.2f",averageMarks));
			System.out.println("\nThe maximum marks is :"+String.format ("%,.2f",maxMarks));
			System.out.println("\nThe minimum marks is :"+String.format ("%,.2f",minMarks));
			System.out.println("\nThe percentage of student pass is :"+String.format ("%,.2f",studentPass));
			System.out.println("\nDo you want to Continue ===> (1 -> Continue)");
			flow = input.nextInt();
		}while(flow==1);
	}

}
