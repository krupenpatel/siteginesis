package testsuitA;


import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Basepackge.Baseinit;
import Utilitypackge.MyLibrary;

public class Validateuser extends Baseinit{
	
	@BeforeClass
	public void setUP() throws Throwable
	{
		startUP();
	}
	
	@Test(dataProvider="getdata")
	public void testValidateuser(String username,String password) throws Throwable
	{
		driver.get(storage.getProperty("url"));
		
		MyLibrary.signIN(username, password);
		isElementPresent("user_icon_xpath").click();
		
		try {
			
			if(isElementPresent("lnk_logout_xpath").isDisplayed())
			{
				
				logs.info("user login successfully.");
				MyLibrary.loggOF();
			}
			
		} catch (Exception e) {
			logs.info("username and password is wrong!!");
		}
		MyLibrary.getScreenShot("login", driver);
		
		
	}
	
	@DataProvider
	public Object[][] getdata()
	{
		return MyLibrary.getTestData(data, "validate_user");
	}

}
