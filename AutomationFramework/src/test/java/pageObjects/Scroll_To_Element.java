package pageObjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Scroll_To_Element {
	JavascriptExecutor js;

	WebDriver driver;

	public Scroll_To_Element(WebDriver driver)

	{

		this.driver=driver;

	}

	public void Scroll(WebElement element)

	{

		js = (JavascriptExecutor)driver;

		js.executeScript("arguments[0].scrollIntoView();",element);

	}
}
