import java.util.*;

/**
 * 
 * @author Akshay
 * Class Hexaritmetic declares the variables used to take two hexadecimal numbers and showing the result
 *
 */


public class Hexarithmetic {
	String hexNum1,hexNum2,result;
	int decimalNum1,decimalNum2;
	
	/**
	 * toDecimal function returns the decimal of a hexadecimal number.
	 * @param num1
	 * @return
	 */
	
	int hextoDecimal(String num1)
	{
		num1 = num1.toUpperCase();
		int length = num1.length();
		int decimalVal = 0,i,base=1;
		for(i=length-1;i>=0;i--)
		{
			if(num1.charAt(i)>='0' && num1.charAt(i)<='9')
			{
				decimalVal += (num1.charAt(i)-48)*base;
				base = base*16;
			}
			else if(num1.charAt(i)>='A' && num1.charAt(i)<='F')
			{
				decimalVal += (num1.charAt(i)-55)*base;
				base = base*16;
			}
		}
		System.out.println("The decimal is ===>> " + decimalVal);
		return decimalVal;
	}
	
	/**
	 * toHexadecimal function returns the Hexadecimal of a decimal number.
	 * @param num1
	 * @param check
	 */
	
	void decimaltoHexadecimal(int num1,int check)
	{
		char[] result = new char[100];
		int i=0;
		if(num1==0)
		{
			System.out.print("\nThe Answer is ===>>"+num1);
		}
		else
		{
			while(num1!=0)
			{
				int temp = 0;
				temp = num1 % 16;
				if(temp<=9)
				{
					result[i] = (char) (temp+48);
					i++;
				}
				else
				{
					result[i] = (char)(temp+55);
					i++;
				}
				num1 = num1 / 16;
			}
			System.out.print("\nThe Answer is ===>>   ");
			if(check==-1)
			{
				System.out.print(" - ");
			}
			for(int j=i-1;j>=0;j--)
			{
				System.out.print(result[j]);
			}
		}
	}
	
	/**
	 * add function adds the two hexadecimal number
	 * @param num1
	 * @param num2
	 */
	void add(String num1,String num2)
	{
		int decimalNum1,decimalNum2;
		decimalNum1 = hextoDecimal(num1);
		decimalNum2 = hextoDecimal(num2);
		int result = decimalNum1 + decimalNum2;
		System.out.println("The result in decimal is ===>>"+result);
		decimaltoHexadecimal(result,0);
	}
	
	/**
	 * subtract function subtract the two hexadecimal number
	 * @param num1
	 * @param num2
	 */
	
	void subtract(String num1,String num2)
	{
		int decimalNum1,decimalNum2,check,result=0;
		decimalNum1 = hextoDecimal(num1);
		decimalNum2 = hextoDecimal(num2);
		check = compare(num1,num2);
		if(check==1)
		{
			result = decimalNum1 - decimalNum2;
		}
		else if(check==-1)
		{
			result = decimalNum2 - decimalNum1;
		}
		else
		{
			result = decimalNum1 - decimalNum2;
		}
		decimaltoHexadecimal(result,check);
	}
	
	/**
	 * multiply function multiply the two hexadecimal number
	 * @param num1
	 * @param num2
	 */
	void multiply(String num1,String num2)
	{
		int decimalNum1,decimalNum2;
		decimalNum1 = hextoDecimal(num1);
		decimalNum2 = hextoDecimal(num2);
		int result = decimalNum1 * decimalNum2;
		decimaltoHexadecimal(result,0);
	}
	
	/**
	 * divide function divide the two hexadecimal number
	 * @param num1
	 * @param num2
	 */
	
	void divide(String num1,String num2)
	{
		int decimalNum1,decimalNum2,result;
		decimalNum1 = hextoDecimal(num1);
		decimalNum2 = hextoDecimal(num2);
		int check = compare(num1,num2);
		if(check==1)
		{
			result = decimalNum1 / decimalNum2;
		}
		else if(check==-1)
		{
			result = 0;
		}
		else
		{
			result = 1;
		}
		//result = decimalNum1 / decimalNum2;
		decimaltoHexadecimal(result,0);
	}
	
	/**
	 * compare function Compares two hexadecimal numbers for greater, smaller or equal
	 * @param num1
	 * @param num2
	 * @return
	 */
	int compare(String num1,String num2)
	{
		int len1,len2,i=0;
		len1 = num1.length();
		len2 = num2.length();
		if(len1 > len2)
		{
			return 1;
		}
		else if(len2 > len1)
		{
			return -1;
		}
		else if(len1==len2)
		{
			for(i=0;i<len1;i++)
			{
				if(num1.charAt(i) > num2.charAt(i))
				{
					return 1;
				}
				else if(num1.charAt(i) < num2.charAt(i))
				{
					return -1;
				}
				else
				{
					i++;
				}
			}
		}
		return 0;
	}
	
	/**
	 * verifyInput function checks the input Provided by the User.
	 * @param num
	 * @return
	 */
	
	boolean verifyInput(String num) {
		int flag=0;
		for(int i = 0; i < num.length(); i++)
		{
			if(( (num.charAt(i) >= 'A') && (num.charAt(i)<='F') )|| ( (num.charAt(i)>='0') && (num.charAt(i)<='9') ) || ( (num.charAt(i)>='a') && (num.charAt(i)<='f') ) )
			{
				continue;
			}
			else
			{
				flag = 1;
				break;
			}
		}
		if(flag==1)
		{
			System.out.println("\nPlease Enter Valid Input In Hexadecimal :- ");
			return true;
		}
		return false;
	}
	
	/**
	 * compareShow Function Shows the Status of equal, greater and smaller.
	 * @param num1
	 * @param num2
	 */
	
	void compareShow(String num1,String num2)
	{
		int check = compare(num1,num2);
		if(check == 1)
		{
			System.out.println("\nThe First Number is Greater Than Second !!!!!");
		}
		else if(check == -1)
		{
			System.out.println("\nThe Second Number is Greater Than First !!!!!");
		}
		else
		{
			System.out.println("\nBoth The numbers Are Equal !!!!!");
		}
	}
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		Hexarithmetic hex1 = new Hexarithmetic();
		int choice=0,flow=1;
		do{
			boolean inputCheck = true;
			System.out.println("\t\t\t\t\tCalculator");
			System.out.println("\t\t\t\t\t__________");
			System.out.println("1.Add");
			System.out.println("2.Substrat");
			System.out.println("3.Multiply");
			System.out.println("4.Divide");
			System.out.println("5.Compare");
			input.nextLine();
			while(inputCheck)
			{
				System.out.println("\nEnter First Number:");
				hex1.hexNum1 = input.nextLine();
				inputCheck = hex1.verifyInput(hex1.hexNum1);
			}
			inputCheck = true;
			while(inputCheck)
			{
				System.out.println("\nEnter the Second Number:");
				hex1.hexNum2 = input.nextLine();
				inputCheck = hex1.verifyInput(hex1.hexNum2);
			}
			//input.nextLine();
			try{
				System.out.print("\nEnter Your choice:");
				choice = input.nextInt();
			}
			catch(Exception e)
			{
				System.out.println("Invalid Input !!!!!");
			}
			switch(choice)
			{
			case 1: hex1.add(hex1.hexNum1,hex1.hexNum2);
			break;
			case 2: hex1.subtract(hex1.hexNum1,hex1.hexNum2);
			break;
			case 3: hex1.multiply(hex1.hexNum1,hex1.hexNum2);
			break;
			case 4: hex1.divide(hex1.hexNum1,hex1.hexNum2);
			break;
			case 5: hex1.compareShow(hex1.hexNum1,hex1.hexNum2);
			break;
			default:System.out.println("Invalid Choice");
			}
			input.nextLine();
			try{
				System.out.print("\nDo you Want To continue(1 ->Continue / 0-> quit ):");
				flow = input.nextInt();
			}
			catch(InputMismatchException e)
			{
				System.out.println("\nYou Entered Invalid Input !!!!!");
			}
		}while(flow==1);
		System.out.println("\nThank You \nVisit Again !!!!!");
	}

}
