package Utilitypackge;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

import Basepackge.Baseinit;

public class MyLibrary extends Baseinit {

	public static void signUP(String email,String pwd)
	{
		isElementPresent("lnk_logyourselfin_xpath").click();
		isElementPresent("ip_email_xpath").sendKeys(email);
		isElementPresent("ip_password_xpath").sendKeys(pwd);
		isElementPresent("btn_signin_xpath").click();
		logs.info("longin successfully");
	}
	
	public static void loggOF()
	{
		isElementPresent("lnk_loggoff_xpath").click();
		isElementPresent("lnk_continue_xpath").click();
		logs.info("logout successfully");
		
	}
	
	
	public static String getScreenShot(String imageName, WebDriver driver) {

		TakesScreenshot ts = (TakesScreenshot) driver; // ts will point where driver is pointing

		File scrFile = ts.getScreenshotAs(OutputType.FILE); // screenshot will be captured and stored in scrFile

		String path = System.getProperty("user.dir") + "src\\main\\resources\\screenShorts" + imageName
				+ System.currentTimeMillis() + ".png";

		// System.out.println(path);
		File destination = new File(path);

		try {

			FileHandler.copy(scrFile, destination);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return path;
	}
	
	public static Object[][] getTestData(ExcelFileReader data, String sheetName) {

		int cols = data.totalColumn(sheetName);
		int rows = data.totalRow(sheetName);

		Object myData[][] = new Object[rows - 1][cols];

		for (int row = 1; row < rows; row++) {

			for (int col = 0; col < cols; col++) {

				myData[row - 1][col] = data.getData(sheetName, row, col);
			}

		}

		return myData;

	}
	
}
