package utilites;

import demoblazeApplicationTest.DemoblazeTest;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

public class UtilClass extends DemoblazeTest {
    public UtilClass(){
        PageFactory.initElements(driver,this);
    }


    public static void takeScreenshot(String name) {
        try {
            // Get current date and time
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd_HHmmss");
            String dateTime = dateFormat.format(new Date());
            TakesScreenshot screenshot = (TakesScreenshot) driver;
            File src = screenshot.getScreenshotAs(OutputType.FILE);
            File des = new File("src/test/ScreenShot/" + name +dateTime+ ".png");
            FileHandler.copy(src, des);
        } catch (IOException e) {
            System.out.println("File not found");
            throw new RuntimeException(e);
        }
    }


}
