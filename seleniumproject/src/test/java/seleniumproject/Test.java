package seleniumproject;

import java.time.Duration;
import org.openqa.selenium.By;
//import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test {
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://demoqa.com/automation-practice-form");
		driver.manage().window().maximize();
		
//		driver.switchTo().frame(0);
//		driver.switchTo().frame(2);
		
//		driver.findElement(By.xpath("//*[@id='stateCity-wrapper']")).click();
		WebElement drpState = driver.findElement(By.xpath("demo_basic-dropdown"));
		Select drp = new Select(drpState);
		drp.selectByVisibleText("Haryana");
				
		

	
				
	}

}













//For Radio Button:

//JavascriptExecutor executor = (JavascriptExecutor)driver;
//executor.executeScript("document.getElementById('gender-radio-1').click()");
//Boolean bool = driver.findElement(By.id("gender-radio-1")).isSelected();
//if(bool)
//{
//	System.out.println("Radio Button is Selected");
//}
//else
//{
//	System.out.println("Radio Button not Selected");
//}

////For Window switch
//driver.findElement(By.id("windowButton")).click();
//String mainWindow = driver.getWindowHandle();
//System.out.println(mainWindow);
//
//Set<String> childWindow = driver.getWindowHandles();
//driver.findElement(By.id("windowButton")).click();
//
//Iterator<String> it = childWindow.iterator();
//while(it.hasNext())
//{
//String window = it.next();
//driver.switchTo().window(window);
//System.out.println(window);
//}

////Alert Window
//driver.get("https://demoqa.com/alerts");
//driver.manage().window().maximize();
//
//driver.findElement(By.id("alertButton")).click();
//Alert alertWindow = driver.switchTo().alert();
//String sampleText = alertWindow.getText();
//System.out.println(sampleText);
//alertWindow.accept();