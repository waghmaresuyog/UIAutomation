package demoblazeApplicationTest;

import browser.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.annotations.Parameters;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import pageLayer.AddToCartPage;
import pageLayer.HomePage;


import java.time.Duration;

import static config.GetUrl.commonUrl;

public class DemoblazeTest {
   public static WebDriver driver;
   public WebDriverWait wait;
    private static Logger log = Logger.getLogger(DemoblazeTest.class);
    public static HomePage  homePage;

    @Parameters("browser")
    @BeforeTest
    public void openBrowser(String browser) throws Exception {
        PropertyConfigurator.configure("src\\test\\resources\\log4j2.properties");
        Driver driver = new Driver(browser);
        this.driver = driver.setDriver();
        this.driver.manage().window().maximize();

    }

    @Test(priority = 1)
    public static void openUrl(){
        driver.get(commonUrl());
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        log.info("Open the demoblaze software Testing Url");
        System.out.println(commonUrl());
        log.info("Read URL from file ");
    }

    @Test(priority = 2)
    public static void clickOnPhone() throws InterruptedException {
        homePage = new HomePage(driver);
        Thread.sleep(3000);
        homePage.clickPhone();
        log.info("Clicked on Phone");
        homePage.clickOnSamsungGalaxyS6();
        log.info("Clicked on samsung galaxy s6");

    }
    @Test(priority = 3)
    public static void addtoCard() throws InterruptedException {
        AddToCartPage addToCartPage = new AddToCartPage();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        addToCartPage.clickAddToCart();
        Thread.sleep(3000);
        addToCartPage.acceptPopup();
        log.info("successful accept popup");
    }


    @AfterTest
    public void Close() throws InterruptedException {
        Thread.sleep(3000);
        log.info("Broswer Close");
        driver.quit();
    }
}
