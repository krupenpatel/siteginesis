package testsuitA;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import Basepackge.Baseinit;
import Utilitypackge.MyLibrary;

public class Validateuser extends Baseinit{
	
	@BeforeClass
	public void setUP() throws Throwable
	{
		startUP();
	}
	
	@Test
	public void testValidateuser() throws Throwable
	{
		driver.get(storage.getProperty("url"));
		
		MyLibrary.signIN();
	}

}
