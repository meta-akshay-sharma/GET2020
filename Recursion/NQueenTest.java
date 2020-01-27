
import static org.junit.Assert.*;

import org.junit.Test;

public class NQueenTest {
	NQueensProblem obj = new NQueensProblem();

	@Test
	public void test_NQueenWithPositiveCase_returnBooleanResult() {
		int n = 6;
		int [][] board = new int[n][n];
		boolean res = obj.nQProblem(board , 0, n);
		assertEquals(true , res);
	}

	@Test
	public void test_NQueenWithNegativeCasereturnBooleanResult() {
		int n = 2;
		int [][] board = new int[n][n];
		boolean res = obj.nQProblem(board , 0, n);
		assertEquals(false , res);
	}
}
