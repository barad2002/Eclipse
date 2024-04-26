package seleniumproject;

import java.util.List;

//import org.apache.xmlbeans.impl.xb.xsdschema.ListDocument.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Practice {

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://jqueryui.com/datepicker/");
		driver.manage().window().maximize();
		
		driver.switchTo().frame(0);
		
		String year = "2025";
		String month = "February";
		String date = "8";
		
		driver.findElement(By.id("datepicker")).click();
		
		while(true)
		{
			String yr = driver.findElement(By.className("ui-datepicker-year")).getText();
			String mon = driver.findElement(By.className("ui-datepicker-month")).getText();
			if(yr.equalsIgnoreCase(year))
			{
				if(mon.equalsIgnoreCase(month))
				{
					break;
				}
			}
			driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-e']")).click();
		
		}
		List<WebElement> allDates=driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']//td"));
		
		for(WebElement dt : allDates)
		{
			if(dt.getText().equals(date))
			{
				dt.click();
				break;
			}
		}
//		driver.quit();

	}

}
