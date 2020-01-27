
import static org.junit.Assert.*;

import org.junit.Test;

public class LCMHCFTest
{
	LCMHCF lcmObj = new LCMHCF();
	LCMHCF hcfObj = new LCMHCF();

	@Test
	public void test_LCMHCFWithPositiveInput_returnLcm()
	{
		int inputX = 150, inputY = 105;
		int result = lcmObj.lcm(inputX, inputY);
		assertEquals(1050, result);
	}


	@Test
	public void test_LCMHCFWithPositiveInputZero_returnLcm()
	{
		int inputX = 150, inputY = 0;
		assertEquals(0, lcmObj.lcm(inputX, inputY));
	}



	@Test
	public void test_LCMHCFWithPositiveInput_returnHcf()
	{
		int inputX = 150, inputY = 105;
		int result = hcfObj.hcf(inputX, inputY);
		assertEquals(15, result);
	}



	@Test
	public void test_LCMHCFWithPositiveInputZero_returnHcf() 
	{
		int inputX = 150, inputY = 0;
		int result = hcfObj.hcf(inputX, inputY);
		assertEquals(150, result);
	}
}
