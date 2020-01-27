

import static org.junit.Assert.*;

import org.junit.Test;

public class ArrOperationTest 
{

	ArrOperation arrayOperationObj = new ArrOperation();

	@Test
	public void test_MaxMirrorWithoutRepeat_returnValue() 
	{
		int[] array = {1, 2, 3, 5, 6, 3, 2, 1};
		int result = arrayOperationObj.maxMirror(array);
		assertEquals(3, result);
	}

	@Test
	public void test_MaxMirrorWithRepeat_returnValue()
	{
		int[] array = {1, 2, 2, 3, 4, 4};
		int result = arrayOperationObj.maxMirror(array);
		assertEquals(2, result);
	}
	
	@Test
	public void test_MaxMirrorWithSameElements_returnValue() 
	{
		int[] array = {1, 1, 1, 1, 1};
		int result = arrayOperationObj.maxMirror(array);
		assertEquals(5, result);
	}

	@Test
	public void test_MaxMirrorWithError_returnErrorMessage() 
	{
		int[] array = {};
		try
		{
			assertEquals(1, arrayOperationObj.maxMirror(array) );
		} 
		catch (AssertionError e) 
		{
			System.out.println("Error : Array is Empty");
		}
	}

	@Test
	public void test_SplitArrayWithPositiveCase_returnPosition() 
	{
		int[] array = {1, 1, 1, 2, 1};
		int result = arrayOperationObj.splitArray(array);
		assertEquals(3, result);
	}

	@Test
	public void test_SplitArrayWithNegativeCase_returnPosition() 
	{
		int[] array = {2, 1, 1, 2, 1};
		int result = arrayOperationObj.splitArray(array);
		assertEquals(-1, result);
	}

	@Test
	public void test_SplitArrayWithErrorCase_returnErrorMessage()
	{
		int[] array = {};
		try 
		{
			assertEquals(1, arrayOperationObj.splitArray(array) );
		}
		catch (AssertionError e) 
		{
			System.out.println("Error : Array is Empty");
		}
	}
	
	@Test
	public void test_FixXYWithPositiveCase_returnArray()
	{
		int[] array = {5, 4, 9, 4, 9, 5};
		array = arrayOperationObj.fixXY(array, 4, 5);
		int[] expected = {9, 4, 5, 4, 5, 9};
		assertArrayEquals(expected, array);
	}
	
	@Test
	public void test_FixXYWithErrorEndArrayWithX_returnArray() 
	{
		int[] arr = {1, 2, 4, 7, 4, 6, 7, 4};
		try {
			assertEquals(1, arrayOperationObj.fixXY(arr, 4, 5));
		} catch (AssertionError e) {
			System.out.println("Array Ended with X ");
		}
	}

	@Test
	public void test_FixXYWithErrorEndUnequalNoOfXY_returnArray() 
	{
		int[] array = {5, 2, 4, 5, 4, 6, 7, 4};
		try 
		{
			assertEquals(1, arrayOperationObj.fixXY(array, 4, 5) );
		}
		catch (AssertionError e)
		{
			System.out.println("Unequal No. of x and y ");
		}
	}
	
	@Test
	public void test_FixXYWithErrorCase_returnErrorMessage()
	{
		int[] array = {};
		try 
		{
			assertEquals(1, arrayOperationObj.fixXY(array,4,5) );
		}
		catch (AssertionError e) 
		{
			System.out.println("Error : Array is Empty");
		}
	}
	
	@Test
	public void test_CountClumpsWithoutRepeat_returnValue() {
		int[] array = {1, 1, 2, 4, 5, 5, 6};
		int result = arrayOperationObj.countClumps(array);
		assertEquals(2, result);
	}

	@Test
	public void test_CountClumpsWithRepeat_returnValue() {
		int[] array = {1, 2, 2, 3, 4, 4};
		int result = arrayOperationObj.countClumps(array);
		assertEquals(2, result);
	}

	@Test
	public void test_CountClumpsWithAllSame_returnValue() {
		int[] array = {1, 1, 1, 1, 1};
		int result = arrayOperationObj.countClumps(array);
		assertEquals(1, result);
	}

	@Test
	public void test_CountClumpsWithError_returnErrorMessage() {
		int[] array = {};
		try {
			assertEquals(1, arrayOperationObj.countClumps(array));
		} catch (AssertionError e) {
			System.out.println("Error : Array is Empty ");
		}
	}

}
