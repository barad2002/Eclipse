package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class second_Page {
	public WebDriver driver;

	   //constructor

	   public second_Page(WebDriver driver){

		   this.driver=driver;

		   PageFactory.initElements(driver, this);

	   }

	   By second_Page_News = By.xpath("//*[@data-automation-id='newsItemTitle']");

	   public List<WebElement> SecondNews(){

		   return driver.findElements(second_Page_News);

	   }
}
