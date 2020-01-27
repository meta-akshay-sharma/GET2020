
import static org.junit.Assert.*;
import org.junit.Test;

public class SearchTest {
	Search searchObj = new Search();

	@Test
	public void test_BinarySearchWithPositiveCase_returnPosition() {
		int[] inputArray = {1, 2, 3, 4, 5, 6};
		int element = 4, startIndex = 0, endIndex = inputArray.length - 1;
		int result = searchObj.binarySearch(inputArray, element, startIndex, endIndex);
		assertEquals(3, result);
	}

	@Test
	public void test_BinarySearchWithNegativeCase_returnPosition() {
		int[] inputArray = {1, 2, 3, 4, 5, 6,7};
		int element = 0, startIndex = 0, endIndex = inputArray.length - 1;
		int result = searchObj.binarySearch(inputArray, element, startIndex, endIndex);
		assertEquals(-1, result);
	}

	

	@Test
	public void test_LinearSearchWithPositiveCase_returnPosition() {
		int[] inputArray = {6, 8, 5, 0, 9, 7};
		int element = 4, startIndex = 0;
		int result = searchObj.linearSearch(inputArray, element, startIndex);
		assertEquals(-1, result);
	}

	@Test
	public void test_LinearSearchWithNegativeCase_returnPosition() {
		int[] inputArray = {6, 8, 5, 0, 9, 7};
		int element = 10, startIndex = 0;
		int result = searchObj.linearSearch(inputArray, element, startIndex);
		assertEquals(-1, result);
	}
}
