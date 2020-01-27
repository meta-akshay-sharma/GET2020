public class Search 
{


	/**
	 * Linearly search the element
	 * @param inputArray
	 * @param element is the number we want to search
	 * @param index is the start index of array
	 * @return index of found number if not found return -1
	 */

	static int linearSearch(int[] inputArray, int element, int index)
	{
		if(inputArray[index] == element)
		{
			return index;
		} 
		else if(index < inputArray.length - 1)
		{
			return linearSearch(inputArray, element, index + 1);
		} 
		else
		{
			return -1;
		}
	}

	/**
	 * To implement Binary Search Algorithm
	 * @param inputArray
	 * @param element  is the element we want to search
	 * @param startIndex starting index of array
	 * @param endIndex end index of the array
	 * @return index of element found if not return -1
	 */

	static int binarySearch(int[] inputArray, int element, int startIndex, int endIndex) 
	{
		if( (element >= inputArray[startIndex]) && (element <= inputArray[endIndex]) ) 
		{
			int mid = (startIndex + endIndex) / 2;
			if(inputArray[mid] == element) 
			{
				return mid;
			}
			else if(inputArray[mid] < element) 
			{
				startIndex = mid+1;
				return binarySearch(inputArray, element, startIndex, endIndex); 
			}
			else
			{
				endIndex = mid-1;
				return binarySearch(inputArray, element, startIndex, endIndex);
			}
		} 
		else
		{
			return -1;
		}
	}

}
