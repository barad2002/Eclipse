package seleniumproject;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.TakeScreenshot;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;

public class MyTest {
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.youtube.com/");
//		Thread.sleep(2000);
		
		driver.manage().window().maximize();
		
		
		driver.findElement(By.name("search_query")).click();
		
//		WebElement search = driver.findElement(By.id("search"));
//		search.sendKeys("katchi sera");
		
		driver.findElement(By.name("search_query")).sendKeys("kangal edho");
		
		
		driver.findElement(By.id("search-icon-legacy")).click();
		Thread.sleep(2000);
		
		driver.findElement(By.cssSelector("#video-title > yt-formatted-string")).click();
//		Thread.sleep(6000);
//		
//		driver.findElement(By.cssSelector("#skip-button\\:6 > span > button > span")).click();

		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"movie_player\"]/div[29]/div[2]/div[2]/button[9]")).click();
		
//		try {
//			TakesScreenshot ts = ((TakesScreenshot) driver);
//			File srcFile = ts.getScreenshotAs(OutputType.FILE);
//			File destFile = new File("C:\\Users\\2318452\\OneDrive - Cognizant\\Desktop\\ScreenShots\\screenshot.png");
//			FileUtils.copyFile(srcFile, destFile);
//			
//		}
//		catch(Exception e)
//		{
//			System.out.println(e);
//		}
//		driver.close();

	}

}
