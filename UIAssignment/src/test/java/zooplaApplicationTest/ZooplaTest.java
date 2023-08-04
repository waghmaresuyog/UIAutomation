package zooplaApplicationTest;

import browser.Driver;
import config.GetUrl;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.annotations.Parameters;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;


import java.time.Duration;

import static config.GetUrl.commonUrl;

public class ZooplaTest {
    WebDriver driver;
    WebDriverWait wait;
    private static Logger log = Logger.getLogger(ZooplaTest.class);

    @Parameters("browser")
    @BeforeTest
    public void browser(String browser) throws Exception {
        PropertyConfigurator.configure("src\\test\\resources\\log4j2.properties");
        Driver driver = new Driver(browser);
        this.driver = driver.setDriver();
        this.driver.manage().window().maximize();
        this.driver.get(commonUrl());
        wait = new WebDriverWait(this.driver, Duration.ofSeconds(20));
        log.info("Open the Zoopla software Testing Url");
    }

    @Test
    public static void printurl(){
        System.out.println(commonUrl());
        log.info("Read URL from file ");
    }

    @AfterTest
    public void Close() {
        log.info("Broswer Close");
        driver.quit();
    }
}
