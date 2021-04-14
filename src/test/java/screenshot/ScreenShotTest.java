package screenshot;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ScreenShotTest {
	WebDriver driver;
	@BeforeMethod
	public void setup()
	{
        System.setProperty("webdriver.chrome.driver","C:\\Users\\user\\Downloads\\browserdriver\\chromedriver.exe");
		
	    driver=new ChromeDriver();
		driver.get("https://www.google.com/");
		
	}
	@Test
	public void testcase1()
	{
		driver.findElement(By.name("q")).sendKeys("ScreenShot demo");
		TakesScreenshot screenshot=(TakesScreenshot)driver;
		File source=screenshot.getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(source,new File("C:\\Users\\user\\eclipse-workspace\\screenshot\\ScreenShot\\ScreenShot.png" ));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.getMessage();
		}
	}
	@AfterMethod
	public void TearDown()
	{
		driver.close();
	}

}
