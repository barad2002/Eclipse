package testCases;

import java.io.IOException;

import org.testng.annotations.Test;

import baseClass.BaseClass;
import pageObject.GiftCardsPage;

public class TC_GiftCards extends BaseClass{
	
	GiftCardsPage gp;
	String repName,repEmail,repMobile,yName,yEmail,yMobile,enAddress,pincode;
	
	
	@Test(priority=0)
//	@Parameters({"url"})
	public void go_to_the_gift_cards_page() {
		gp = new GiftCardsPage(driver);
		   
		   //driver.switchTo().frame(gp.getHead());
		   gp.clickGiftcards();
		   BaseClass.getLogger().info("Going to Gift Cards Page...");
		   
	}
	
	@Test(priority=1)
	public void click_the_birthday_or_anniversary_card() throws InterruptedException {
		gp = new GiftCardsPage(driver);
//		BaseClass.getLogger().info("Scrolling to the BirthDay/Anniversary card...");
		BaseClass.scrolling(gp.ReachBirthday);
		
//		BaseClass.getLogger().info("Clicking the BirthDay/Anniversary card...");
		gp.clickBirthday(driver);
		BaseClass.getLogger().info("validating...");
		
	}
	
	@Test(priority=2)
	public void fill_customize_your_gift_card_with_valid_price_date_and_click_next_button() throws IOException {
		gp = new GiftCardsPage(driver);
		BaseClass.getLogger().info("Entering price...");
		
		gp.Enteramount(BaseClass.getProperties().getProperty("amount"));
		BaseClass.getLogger().info("Selecting month...");
		gp.Entermonth();;
		BaseClass.getLogger().info("Selecting day...");
		gp.Enterday();
		BaseClass.getLogger().info("Clicking the nextButton...");
		gp.Clicknext();;
		BaseClass.getLogger().info("Opening of the lucky person page...");
		
	}


}
