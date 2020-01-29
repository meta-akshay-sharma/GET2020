package assignment_6;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class IntSetTest {
	IntSet intset1; 
	IntSet intset2;
	IntSet intset3;
	IntSet intset4;
	@Before
	public void beforeTest()
	{
		intset1 = new IntSet(new int []{1,2,3,4,5,6,7,8,9,10,11});
		intset2 = new IntSet(new int[]{1,2,3,4});
		intset3 = new IntSet(new int[]{3,4,5,6});

	}
	@Test
	public void test_IsMemberSet_returnBoolean()
	{
		boolean result = intset1.isMember(11);
		assertEquals(true,result);
		result = intset1.isMember(100);
		assertEquals(false,result);

	}

	@Test
	public void test_sizeSet_returnBoolean()
	{
		int result = intset1.size();
		assertEquals(11,result);
		result = intset2.size();
		assertEquals(4,result);

	}
	
	@Test
	public void test_subSet_returnSet()
	{
		boolean result = intset1.isSubSet(intset2);
		assertEquals(true, result);
		result = intset2.isSubSet(intset3);
		assertEquals(false, result);
		result = intset1.isSubSet(intset3);
		assertEquals(true, result);
		
	}
	@Test
	public void test_getCompliment_returnSet()
	{
		int result[] = intset1.getCompliment();
		int expected[] = new int[989];
		int index = 0;
		for(int i=12;i<=1000;i++)
		{
			expected[index] = i; 
			index++;
		}
		assertArrayEquals(expected,result);
		
	}
	
	@Test 
	public void test_getUnion_returnSet()
	{
		IntSet union = IntSet.getUnion(intset2, intset3);
		assertArrayEquals(new int[]{1,2,3,4,5,6}, union.getSet());
	}

}
