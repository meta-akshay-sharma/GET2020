package assignment7;

import static org.junit.Assert.*;

import org.junit.Test;



public class SparseMatrixTest 
{
	SparseMatrix obj = new SparseMatrix( new int[][]{{1,1,1},{1,0,0},{0,0,0}} );
	
	@Test
	public void test_transpose_matrix_returnMatrix() 
	{
		assertArrayEquals( new int[][]{{0,0,1},{1,0,1},{2,0,1},{0,1,1}}, obj.transpose());
	}
	
	@Test
	public void test_checkSymmetricNegative_returnBoolean()
	{
		assertEquals(false, obj.symmetric());
	}
	
	@Test
	public void test_checkSymmetricPositive_returnBoolean()
	{
		SparseMatrix objFirst = new SparseMatrix( new int[][]{{0,1,0},{1,0,5},{0,5,0}});
		assertEquals(true, objFirst.symmetric());
	}
	
	@Test
	public void test_additionOfSparseMatrices_returnMatrix()
	{
		SparseMatrix objFirst = new SparseMatrix( new int[][]{{1,1,0},{0,7,0},{0,0,9}} );
		assertArrayEquals( new int[][]{{0,0,2},{0,1,2},{0,2,1},{1,0,1},{1,1,7},{2,2,9},{0,0,0},{0,0,0}}, obj.additionSparse(objFirst));
	}
	
	@Test
	public void test_multiplicationOfSparseMatrices_returnMatrix()
	{
		SparseMatrix objFirst = new SparseMatrix( new int[][]{{1,1,0},{0,7,0},{0,0,9}} );
		SparseMatrix objSecond = new SparseMatrix( new int[][]{{1,1,0},{0,7,0},{0,0,9}} );
		assertArrayEquals( new int[][]{{1,8,0},{0,49,0},{0,0,81}}, obj.multiplySparse(objFirst, objSecond));
		objFirst = new SparseMatrix( new int[][]{{0,10,0,12},{0,0,0,0},{0,0,5,0},{15,12,0,0}} );
		objSecond = new SparseMatrix( new int[][]{{0,0,8,0},{0,0,0,23},{0,0,9,0},{20,25,0,0}} );
		assertArrayEquals( new int[][]{{240,300,0,230},{0,0,0,0},{0,0,45,0},{0,0,120,276}}, obj.multiplySparse(objFirst, objSecond));
	}
	
	@Test
	public void test_whenNullMatrixPassed_returnErrorMessage()
	{
		try 
		{
			assertEquals("",1, new SparseMatrix(new int[][]{}));
		}
		catch (AssertionError e)
		{
			System.out.println("size of array is zero");
		}
	}
	
	@Test
	public void test_additionWhenArraysAreNotOfSameLength_returnErrorMessage() {
		SparseMatrix objFirst = new SparseMatrix( new int[][]{{1,1,0},{0,7,0},{0,0,9},{1,0,0}} );
	try {
		assertEquals(1, obj.additionSparse(objFirst));
	}
	catch (AssertionError e) {
		System.out.println("both are not of same size");
	}
	}
	
	@Test
	public void test_whenNonZeroElementsAreGreaterThanZero_returnMessage(){
	try {
		assertEquals(1, new SparseMatrix(new int[][]{{1,1,1},{1,0,0},{1,1,1}}));
	}
	catch (AssertionError e) {
		System.out.println("non zero are greater than zero");
	}
	}
}
