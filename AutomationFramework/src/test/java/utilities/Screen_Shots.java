package utilities;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class Screen_Shots {


    public static String takeScreenshot(WebDriver driver, String Name) throws IOException{

    	File fileobj = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
    	File trg =  new File("C:\\Users\\2318459\\eclipse-workspace\\CAS_Project\\Screen_Shots\\"+Name+".png");

    	FileUtils.copyFile(fileobj, trg);
    	return trg.getAbsolutePath();

}

}
