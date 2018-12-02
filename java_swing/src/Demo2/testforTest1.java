package Demo2;

import static org.junit.jupiter.api.Assertions.*;

//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.Assumptions;
//import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.*;;

class testforTest1 {

	@Test
	void test() {
		//fail("Not yet implemented");
		test1 lll = new test1();
		//System.out.print(lll.name);
		Assertions.assertNotEquals(3,13);
		Assertions.assertEquals(3,6-3);
	}
	 @Test
	    void testOnDev()
	    {
	        System.setProperty("ENV", "DEV");
	        Assumptions.assumeTrue("DEV".equals(System.getProperty("ENV")), testforTest1::message);
	    }
	    @Test
	    void testOnProd()
	    {
	        System.setProperty("ENV", "PROD");
	        Assumptions.assumeFalse("DEV".equals(System.getProperty("ENV")));
	    }
	    private static String message () {
	        return "TEST Execution Failed :: ";
	    }
}
