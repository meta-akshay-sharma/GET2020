package assignment_6;


import static org.junit.Assert.*;


import org.junit.Before;
import org.junit.Test;



public class PolyTest {
	Polynomial p1;
	Polynomial p2;
	Polynomial p3;
	Polynomial p4,p5,p6;
	@Before
	public void beforeTest()
	{
		p1 = new Polynomial(new double[]{4,2.5,1.3}, new double[]{3,2,1});
		p2 = new Polynomial(new double[]{4,2.5,1.3}, new double[]{3,2,1});
		p3 = new Polynomial(new double[]{2,1}, new double[]{2,1});
		p4 = new Polynomial(new double[]{1,1}, new double[]{2,1});
		p5 = new Polynomial(new double[]{6,10,5}, new double[]{3,2,0});
		p6 = new Polynomial(new double[]{4,2,1}, new double[]{2,1,0});
	}
	@Test
	public void test_ForSolve_returnCalculatedValue()
	{
		float result=p1.solveFor(4);
		assertEquals(301.2, result,5);
		
		result=p1.solveFor(5);
		assertEquals(569, result,5);


	}
	@Test
	public void test_ForDegree_returnDegreeValue()
	{
		double result ;
		result =  p1.getDegree();
		
		assertEquals(3,result,5);
		
	}
	
	@Test
	public void test_forAddition_returnPolynomial()
	{
		Polynomial result;
	
		result = Polynomial.add(p1, p2);
		//System.out.println(result.getCofficient()[]);
		assertArrayEquals(new double[]{8,5,2.6},result.getCofficient(),5);
		assertArrayEquals(new double[]{3,2,1},result.getexponent(),5);
		result = Polynomial.add(p5, p6);
		assertArrayEquals(new double[]{14,6,6,2},result.getCofficient(),5);
		assertArrayEquals(new double[]{2,0,3,1},result.getexponent(),5);
	}
	@Test
	public void test_forMultiply_returnPolynomial()
	{
		Polynomial result;
	
		result = Polynomial.multiply(p3, p4)	;
		assertArrayEquals(new double[]{2,2,1,1},result.getCofficient(),5);
		assertArrayEquals(new double[]{4,3,3,2},result.getexponent(),5);
		
	}


}
