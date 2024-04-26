package seleniumproject;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Test1 {

    WebDriver driver;
    WebDriverWait myWait;

    public Test1() {
        driver = new ChromeDriver();
        myWait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void navigateToSite(String url) {
        driver.get(url);
        driver.manage().window().maximize();
    }

    public void signIn() {
        driver.findElement(By.xpath("//a[normalize-space()='Sign in']")).click();
        driver.findElement(By.xpath("//input[@title='Sign in']")).click();
    }

    public void checkAlert(String expectedAlertText) {
        Alert alertWindow = myWait.until(ExpectedConditions.alertIsPresent());
        String actualAlertText = alertWindow.getText();
        if (actualAlertText.equals(expectedAlertText)) {
            System.out.println("Alert message is : " + alertWindow.getText());
            System.out.println("Alert displayed is correct");
            alertWindow.accept();
        } else {
            System.out.println("Test Failed");
        }
    }

    public void forgotPassword() {
        driver.findElement(By.linkText("Forgot Password?")).click();
        driver.findElement(By.name("next")).click();
    }

    public void navigateBack() {
        driver.navigate().back();
    }

    public void privacyPolicy() {
        driver.findElement(By.xpath("//a[normalize-space()='Privacy Policy']")).click();
    }

    public void checkNewTab() {
        Set<String> values = driver.getWindowHandles();
        if (values.size() > 1) {
            System.out.println("Page is displayed in new tab");
        }
        if (values.size() == 1) {
            System.out.println("Page is not displayed in new tab");
        }
    }

    public void closeBrowser() {
        driver.close();
        driver.quit();
    }

    public static void main(String[] args) {
        Test1 miniProject = new Test1();
        miniProject.navigateToSite("https://rediff.com");
        miniProject.signIn();
        miniProject.checkAlert("Please enter a valid user name");
        miniProject.forgotPassword();
        miniProject.checkAlert("Please enter your email ID");
        miniProject.navigateBack();
        miniProject.privacyPolicy();
        miniProject.checkNewTab();
        miniProject.closeBrowser();
    }
}

