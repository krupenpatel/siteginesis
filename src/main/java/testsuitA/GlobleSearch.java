package testsuitA;

import org.openqa.selenium.Keys;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Basepackge.Baseinit;
import Utilitypackge.MyLibrary;

public class GlobleSearch extends Baseinit{
	
	@BeforeClass 
	public void setUP() throws Throwable
	{
		startUP();
	}

	@Test(dataProvider="getdata")
	public void testGlobleSearch(String key)
	{
		driver.get(storage.getProperty("url"));
		isElementPresent("tb_searchbox_xpath").sendKeys(key);
		isElementPresent("tb_searchbox_xpath").sendKeys(Keys.ENTER);
		logs.info("search keyword:-"+ key);
	}
	
	@DataProvider
	public Object[][] getdata()
	{
		return MyLibrary.getTestData(data, "search");
	}
}
