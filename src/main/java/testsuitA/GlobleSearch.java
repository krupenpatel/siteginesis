package testsuitA;



import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
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

	@Test
	public void testGlobleSearch() throws Throwable
	{
		driver.get(storage.getProperty("url"));
		isElementPresent("tb_searchbox_xpath").sendKeys("shir");
		Thread.sleep(3000);
		List<WebElement> options=driver.findElements(By.xpath(storage.getProperty("div_phrase_xpath")));
		
		for(WebElement option: options)
		{
			logs.info("text======"+option.getText());
			if(option.getText().equalsIgnoreCase("Checkout"))
			{
				Thread.sleep(3000);
				logs.info("in if condition");
				option.click();
				break;
			}
		}
		
	}
	
	/*@DataProvider
	public Object[][] getdata()
	{
		return MyLibrary.getTestData(data, "search");
	}*/
}
