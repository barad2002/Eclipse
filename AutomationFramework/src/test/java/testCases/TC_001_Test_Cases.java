package testCases;

import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import pageObjects.Scroll_To_Element;
import pageObjects.first_Page;
import pageObjects.second_Page;
import utilities.Excel_Utility;
import utilities.Screen_Shots;

public class TC_001_Test_Cases {
	
	static public WebDriver driver;
	static public String path;
	
	Scroll_To_Element ste;
	public first_Page fp;
	public second_Page sp;
	List<WebElement> news = new ArrayList<WebElement>();
	List<String> first_Page_News=new ArrayList<String>();

	List<String> secondNews=new ArrayList<String>();
	JavascriptExecutor js;

	List<String> NEWS = new ArrayList<String>();
	
	@BeforeClass
	@Parameters({"browser"})
	public void setDriver(String br) {
		if(br.equalsIgnoreCase("chrome")) {
		driver = new ChromeDriver();
		
		}
		else if(br.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		}
	
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.manage().window().maximize();
	}
	@Test(priority=0)
	@Parameters({"url"})
	public void navigatePage(String url) {
		//String url = "https://cognizantonline.sharepoint.com/sites/Be.Cognizant/SitePages/Home.aspx";
		driver.get(url);
		//Assert.assertTrue(true);
	}
	@Test(priority=1)
	public void validateUser() throws InterruptedException, IOException {
		Thread.sleep(5000);
		fp = new first_Page(driver);
		fp.ClickUser();
		Thread.sleep(3000);
		fp.ClickUser();
		//get the name
		Thread.sleep(3000);
		String name = fp.getUsername();
		System.out.println(name);
		path = Screen_Shots.takeScreenshot(driver, "UserInfo");
		
		//Validating name
		Assert.assertEquals(name, "E, Baradwaj (Contractor)");
		
		
		Thread.sleep(3000);
		
		//get the email
		
		String email = fp.getUserEmail();
		System.out.println(email);
		
		//Validating email
		Assert.assertEquals(email, "2318452@cognizant.com");
		
	}
	@Test(priority=2)
	public void validationOfAroundCognizant() throws IOException {
		ste = new Scroll_To_Element(driver);

		ste.Scroll(fp.aroundCog);

		System.out.println("Scrolled to Around Cognizant");

		String aroundCognizant =fp.VerifyAroundCog();

		path = Screen_Shots.takeScreenshot(driver, "Around_Cognizant");

		Assert.assertEquals(aroundCognizant,"Around Cognizant");
	}
	@Test(priority=3)
	public void newsAroundCognizantFirstPage() throws IOException, InterruptedException {
		
		WebElement firstPageNews = driver.findElement(By.xpath("//*[@id='5d7d4eec-cbe0-4c55-ae2e-f38d926d82a0']/div/div/div/p/span/strong"));
		
		ste.Scroll(firstPageNews);
		Thread.sleep(5000);
		path = Screen_Shots.takeScreenshot(driver, "First_Page");
		
		WebElement loc = driver.findElement(By.xpath("//*[@id='6a300658-3c93-45bc-8746-5964a4379bbf']"));
		
		news = loc.findElements(By.xpath("//div[@id='vpc_WebPart.NewsWebPart.internal.6a300658-3c93-45bc-8746-5964a4379bbf']//a[@id='news_text_title']"));
		first_Page_News = new ArrayList<String>();
		
		for(WebElement e:news) {
			String header = e.getText();
			String toolTip = e.getAttribute("title");
			System.out.println("The News Header is: "+header+" \nThe ToolTip is: "+toolTip);
			if(header.equals(toolTip)) {
				System.out.println("The news header and its tooltip are same...");
				Assert.assertEquals(header, toolTip);
			}
			else {
				System.out.println("The news header and its tooltip are not same...");
				
			}
			first_Page_News.add(header);
			System.out.println();
		}
		System.out.println(first_Page_News.size());
		for(String s:first_Page_News) {
			System.out.println(s);
		}
		

		
	}
	@Test(priority = 4)

	public void clickSeeAll() throws IOException, InterruptedException {

		ste.Scroll(fp.SeeAll);

		fp.ClickSeeAll();
		
		Thread.sleep(5000);

		path = Screen_Shots.takeScreenshot(driver, "See_All");

	}
	@Test(priority = 5)
	public void SecondPage() throws InterruptedException, IOException

	{

		Thread.sleep(5000);

		sp = new second_Page(driver);

		List<WebElement> SecondNews = sp.SecondNews();

		path = Screen_Shots.takeScreenshot(driver, "Second_Page");

		 System.out.println("First 5 News Headers of Second Page are : ");

	     for(int k=0;k<5;k++) {

	    	 String SecondPageNews =SecondNews.get(k).getText();

	    	 secondNews.add(SecondPageNews);

	    	 System.out.println(k+1+":"+SecondPageNews);

	     }

}
	@Test(priority=6)
	public void top5News() throws InterruptedException, IOException {
				
		for (int i=1;i<6;i++) {
			js = (JavascriptExecutor)driver;
			WebElement SecondNews = driver.findElement(By.xpath("(//a[@data-automation-id='newsItemTitle'][1])["+i+"]"));
			ste.Scroll(SecondNews);
			Thread.sleep(1000);

			String href = SecondNews.getAttribute("href");
			
			// Open a new tab
			js.executeScript("window.open()");

			// Switch to new tab
			ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
			driver.switchTo().window(tabs.get(1));

			// Navigate to new URL
			driver.get(href);

			Thread.sleep(10000);

			String News = driver.findElement(By.xpath("//*[@data-automation-id='textBox']")).getText();

			System.out.println(News);

			NEWS.add(News);

			driver.close();
			
			driver.switchTo().window(tabs.get(0));
			

			Thread.sleep(10000);

			}
		Excel_Utility.saveDataToExcel(NEWS,first_Page_News,secondNews);

		Excel_Utility.closeExcel();

	}
	@AfterClass
	public void closeBrowser() {
		driver.quit();
		
	}
}
