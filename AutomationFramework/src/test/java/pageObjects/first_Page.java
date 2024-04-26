package pageObjects;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;

import org.openqa.selenium.support.PageFactory;
 
public class first_Page {

	public WebDriver driver;

	   //constructor

	   public first_Page(WebDriver driver){

		   this.driver=driver;

		   PageFactory.initElements(driver, this);

	   }

	   @FindBy(id="O365_MainLink_Me")

	   WebElement User;

	   public void ClickUser() {

		   User.click();

	   }

	   @FindBy(id="mectrl_currentAccount_primary")

	   WebElement Name;

	   public String getUsername() {

		   return Name.getText();

	   }

	   @FindBy(id="mectrl_currentAccount_secondary")

	   WebElement Email;

	   public String getUserEmail() {

		   return Email.getText();

	   }

	   @FindBy(xpath="//*[@id='5d7d4eec-cbe0-4c55-ae2e-f38d926d82a0']/div/div/div/p/span/strong")

	   public WebElement aroundCog;

	   public String VerifyAroundCog()

	   {
		   return aroundCog.getText();

	   }
	  

	   @FindBy(xpath="//div[@id='c24ff0ed-b166-42e5-b7d5-57c9a9e573cb']//p/a[@href]")

	   public WebElement SeeAll;

	   public void ClickSeeAll() {

		   SeeAll.click();

	   }
	   
	   

}