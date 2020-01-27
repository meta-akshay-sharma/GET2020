public class LCMHCF {

	/**
	 * find the hcf of a numbers
	 * @param number1 as a first number of int type
	 * @param number2 as a second number of int type
	 * @return hcf of a numbers
	 */
	public int hcf(int firstNum, int secondNum){
		if ( firstNum == 0 )
			return secondNum;
		return hcf(secondNum % firstNum , firstNum);
	}
	
	/**
	 * find the lcm of a numbers
	 * @param number1 as a first number of int type
	 * @param number2 as a second number of int type
	 * @return lcm of a numbers
	 */
	public int lcm(int firstNum, int secondNum){
		return ((firstNum*secondNum)/hcf(firstNum, secondNum));
	}
}
