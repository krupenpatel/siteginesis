package Basepackge;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;



import Utilitypackge.ExcelFileReader;

public class Baseinit {

	public static WebDriver driver;
	public static Properties storage;
	public static Logger logs;
	public static ExcelFileReader data;

	public void startUP() throws Exception
	{
		if(driver == null)
		{
			
			logs=Logger.getLogger("devpinoyLogger");
			storage=new Properties();
			FileInputStream fi=new FileInputStream("./src/main/resources/propertiesData/objectrepo.properties");
			storage.load(fi);
			
			logs.info("properties file loded successfully");
			
			String browserVal=storage.getProperty("browser");
			
			if(browserVal.equalsIgnoreCase("chrome"))
			{
				System.setProperty("webdriver.chrome.driver", storage.getProperty("chromedriver"));
				driver=new ChromeDriver();
				logs.info("chrome browser lunched");
			}
			else if (browserVal.equalsIgnoreCase("ff")) {
				System.setProperty("webdriver.giko.driver", "C:\\Users\\hp\\Desktop\\seleniam\\chromedriver_win32\\giko.exe");
				driver=new FirefoxDriver();
				logs.info("ff browser lunched");
			}
			else if (browserVal.equalsIgnoreCase("ie")) {
				System.setProperty("webdriver.ee.driver", "C:\\Users\\hp\\Desktop\\seleniam\\chromedriver_win32\\ie.exe");
				driver=new InternetExplorerDriver();
				logs.info("ie browser lunched");
			}
			else {
				logs.info("driver not defined");
			}
			
			driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			logs.info("screen meximize and delete cookies");
			data=new ExcelFileReader("./src/main/resources/testData/sitegenisis.xlsx");
			logs.info("Excel files are loded");
			
		}
	}
	
	public static WebElement isElementPresent(String propKey) {

		try {

			if (propKey.contains("xpath")) {

				return driver.findElement(By.xpath(storage.getProperty(propKey)));

			} else if (propKey.contains("name")) {

				return driver.findElement(By.name(storage.getProperty(propKey)));

			} else if (propKey.contains("id")) {

				return driver.findElement(By.id(storage.getProperty(propKey)));

			} else if (propKey.contains("linkText")) {

				return driver.findElement(By.linkText(storage.getProperty(propKey)));

			} else {

				logs.info("Key not found in the properties file");
			}

		} catch (Exception e) {

		}
		return null;

	}
	
}
