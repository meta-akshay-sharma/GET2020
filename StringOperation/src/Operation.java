import java.util.*;
/**
 * 
 * @author Akshay
 *class Operation is used to implement the String Functions without using system pre-defined library.
 */
public class Operation {

	Scanner input = new Scanner(System.in);
	
	/**
	 * Function compare compare two string and return 1 if equal otherwise 0.
	 * @return
	 */
	
	int compare()
	{
		String first,second;
		int flag=1,i;
		System.out.print("\nEnter First String :");
		input.nextLine();
		first = input.nextLine();
		System.out.print("\nEnter Second String :");
		second = input.nextLine();
		if(first.length()==second.length())
		{
			for(i=0;i<first.length();i++)
			{
				if(first.charAt(i)!=second.charAt(i))
				{
					flag = 0;
					break;
				}
			}
		}
		else
		{
			flag=0;
		}
		return flag;
	}
	
	
	/**
	 * reverse function return the reverse of the input string.
	 * @param str
	 * @return
	 */
	
	String reverse(String str)
	{
		int i,j;
		char[] ch=new char[str.length()];
		char swap;
		for(i=0;i<str.length();i++)
		{
			ch[i]=str.charAt(i);
		}
		for(i=0,j=str.length()-1;i<(str.length())/2;i++,j--)
		{
			swap = ch[i];
			ch[i]=ch[j];
			ch[j]=swap;
		}
		str = String.valueOf(ch);
		return str;
	}
	
	/**
	 * changeCase Function changes the upper case to lower case  and lower case alphabet to upper case.
	 * @param str
	 * @return
	 */
	
	String changeCase(String str)
	{
		String str1 = "";
		int i,ascii;
		for(i=0;i<str.length();i++)
		{
			ascii = (int)str.charAt(i); 
			if(ascii >= 97 && ascii <=122)
			{
				str1+= (char)((int)str.charAt(i)-32);
			}
			else if(ascii >= 65 && ascii <=90)
			{
				str1 += (char)((int)str.charAt(i)+32);
			}
			else
			{
				str1+=str.charAt(i);
			}
		}
		return str1;
	}
	
	/**
	 * findLargestWord function returns the largest word in the String. 
	 * @param str
	 * @return
	 */
	
	String findLargestWord(String str)
	{
		str += " ";
		int i,count = 0,j=0,max=0,ans=0,size[];
		String[] word;
		for(i=0;i<str.length();i++)
		{
			if(str.charAt(i) == ' ')
			{
				count++;
			}
		}
		word = new String[count];
		size = new int[count];
		System.out.println("Number of the Words in the String is ===>> "+count);
		for(i=0;i<count;i++)
		{
			word[i]="";
			while(str.charAt(j)!=' ')
			{
				word[i]+=str.charAt(j);
				j++;
			}
			size[i]=word[i].length();
			if(size[i]>=max)
			{
				max = size[i];
				ans = i;
			}
			j++;
		}

		return word[ans];
	}
	public static void main(String[] args) {


		int choice=0,flow=1;
		String string;
		Operation obj = new Operation();
		do{
			System.out.println("1.Compare two Strings");
			System.out.println("2.Return Reverse of String");
			System.out.println("3.Convert String From Lower to Upper Case");
			System.out.println("4.Find Largest Word From String");
			try{
				System.out.print("\nEnter Your choice:");
				choice = obj.input.nextInt();
			}
			catch(Exception e)
			{
				System.out.println("Invalid Input !!!!!");
			}
			obj.input.nextLine();
			switch(choice)
			{
			case 1: System.out.println("Output ===>> "+ obj.compare());
			break;
			case 2: 
			{
				System.out.println("\nEnter the String : ");
				string = obj.input.nextLine();
				System.out.println("The Reverse Of [ "+ string +" ] is [ " + obj.reverse(string)+" ]");
			}
			break;
			case 3: 
			{
				System.out.println("\nEnter the String : ");
				string = obj.input.nextLine();
				System.out.println("The Reverse Of [ "+ string +" ] is [ " + obj.changeCase(string)+" ]");
			}	
			break;
			case 4:
			{
				System.out.println("\nEnter the String : ");
				string = obj.input.nextLine();
				System.out.println("The Reverse Of [ "+ string +" ] is [ " + obj.findLargestWord(string)+" ]");
			}					
			break;
			/*
			case 5: cart.generate_bill();
			break;
			case 6: cart.removeItem();
			break;
			 */
			default:System.out.println("Invalid Choice");
			}
			//obj.input.nextLine();
			try{
				System.out.print("\nDo you Want To continue(1 ->Continue / 0-> quit ):");
				flow = obj.input.nextInt();
			}
			catch(InputMismatchException e)
			{
				System.out.println("\nYou Entered Invalid Input !!!!!");
			}
		}while(flow==1);


	}

}

