package assignment_6;

/**
 * Class Polynomial is used to represent the polynomials ( single variable only)
 * class has function  for :-
 * to find equivalent decimal of a polynomial  
 * to add 2 polynomials 
 * to multiply 2 polynomials 
 * 
 * @author Akshay
 *
 */
final public class Polynomial
{
	private final double[] cofficient; // variables are declared as final as they should be immutable and private so that they can not be accessed outside the class 
	private final double[] exponent;

	public double[] getCofficient()
	{
		return cofficient;
	}
	public double[] getexponent()
	{
		return exponent;
	}
	/**
	 * this is constructor to initialize the coefficient and exponents of polynomial
	 * @param cofficient takes coefficient in polynomial
	 * @param exponent takes all exponent in polynomial
	 */
	public Polynomial(double[] cofficient,double[] exponent)
	{
		this.cofficient = cofficient;
		this.exponent   = exponent;
	}

	/**
	 * this function solves the polynomial for given value of variable
	 * @param takes value of variable
	 * @return  value computed value for a given polynomial
	 */
	public float solveFor(float value)
	{
		float result = 0;
		for(int i=0;i<cofficient.length;i++)
		{
			result += cofficient[i]*Math.pow(value,exponent[i]);

		}
		return result;

	}
	/**
	 * this function is used to find the degree of polynomial
	 * @return the max power i.e degree of polynomial
	 */

	public double getDegree()
	{
		double max=exponent[0];
		for(double i:exponent)
		{
			if(i>max)
				max=i;
		}
		return max;
	}

	/**
	 * add function is used to add two polynomials.
	 * @param p1
	 * @param p2
	 * @return the sum polynomial.
	 */
	public static  Polynomial add(Polynomial p1,Polynomial p2)
	{	
		int l1 = p1.getCofficient().length;
		int l2 = p2.getexponent().length,k=0,common = 0;
		for(int i=0;i<p1.exponent.length;i++)
		{
			for(int j=0;j<p2.exponent.length;j++)
			{
				if(p1.exponent[i]==p2.exponent[j])
				{
					common++;
				}
			}
	
		}
		double coffi[] = new double[l1+l2-common];
		double expo[] = new double[l1+l2-common];

		Polynomial add = new Polynomial(coffi,expo);
		
		for(int i=0;i<p1.exponent.length;i++)
		{
			for(int j=0;j<p2.exponent.length;j++)
			{
				if(p1.exponent[i]==p2.exponent[j])
				{
					add.cofficient[k]=p1.cofficient[i]+p2.cofficient[j];
					add.exponent[k]=p1.exponent[i];
					p1.cofficient[i] = -1;
					p2.cofficient[j] = -1;
					p1.exponent[i] = -1;
					p2.exponent[j]=-1;
					k++;
					break;
				}
			}
		}
		
		
		for ( int i = 0; i < p1.exponent.length; i++)
		{
			if(p1.cofficient[i] != -1)
			{
				add.cofficient[k] = p1.cofficient[i];
				add.exponent[k] = p1.exponent[i];
				k++;
			}
		}
		for ( int i = 0; i < p2.exponent.length; i++)
		{
			if(p2.cofficient[i] != -1)
			{
				add.cofficient[k] = p2.cofficient[i];
				add.exponent[k] = p2.exponent[i];
				k++;
			}
		}
		for(int i=k-1;i>=0;i--)
		{
			System.out.print(" "+add.cofficient[i]+" ");
		}
		System.out.println();
		for(int i=k-1;i>=0;i--)
		{
			System.out.print(" "+add.exponent[i]+" ");
		}
		System.out.println();
		return add;

	}

	
	/**
	 * multiply function returns the multiply of two polynomials.
	 * @param p1
	 * @param p2
	 * @return the multiply polynomial. 
	 */
	public static Polynomial multiply(Polynomial p1,Polynomial p2)
	{	
		int l1 = p1.getCofficient().length;
		int l2 = p2.getexponent().length;
		double coffi[] = new double[l1*l2];
		double expo[] = new double[l1*l2];

		Polynomial multiply = new Polynomial(coffi,expo);
		for(int i=0;i<p1.cofficient.length;i++)
		{
			for (int j=0;j<p2.cofficient.length;j++)
			{
				multiply.cofficient[i] = p1.cofficient[i]*p2.cofficient[j];
				multiply.exponent[i] = p1.exponent[i]*p2.exponent[j];

			}


		}

		return  multiply;
	}




}