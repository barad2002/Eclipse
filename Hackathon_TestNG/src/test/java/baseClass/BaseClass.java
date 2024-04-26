package baseClass;

import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;
import org.testng.annotations.Parameters;


public class BaseClass 
{
	
	static Logger logger;
    static JavascriptExecutor js;
	public static WebDriver driver;
	public static TakesScreenshot ts;
	static Properties p;
	
	@BeforeTest
	@Parameters({"browser","url"})
	public void setDriver(String br,String url) {
		if(br.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.get(url);
		}
		else if(br.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
			driver.manage().window().maximize();
			driver.get(url);
		}
		else {
			System.out.println("No browser found!!!");
		}
		
		ts = (TakesScreenshot)driver;
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
		
	}
	
	public static Logger getLogger() 
	{		 
		logger=LogManager.getLogger(); //Log4j
		return logger;
	}
	public static void explicitWait(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	public static WebDriver getDriver() {
		return driver;
	}
	
	public static void scrolling(WebElement element) {
		js = (JavascriptExecutor)BaseClass.getDriver();
		js.executeScript("arguments[0].scrollIntoView()", element);
	}
	
	public static Properties getProperties() throws IOException
	{		 
        FileReader file=new FileReader(System.getProperty("user.dir")+"\\src\\test\\resources\\wanted.properties");
       		
        p=new Properties();
		p.load(file);
		return p;
	}
	
//	public static String captureScreen(String name) {
//
//		
//
//			String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
//
//			File src=ts.getScreenshotAs(OutputType.FILE);
//
//			String targetPath="C:\\Users\\2318452\\Downloads\\CAS_NewsAroundCognizant\\CAS_Project\\screenshots\\"+name+"_"+timeStamp+".png";
//
//
//			File target=new File(targetPath);
//
//			src.renameTo(target);
//
//			return targetPath;
//
//		}
//	
	@AfterTest
	public void closeBrowser() {
		driver.quit();
	}

}
