package browser;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Driver {
    static Logger log = Logger.getLogger(Driver.class);
    WebDriver driver;
    String browser;
    public Driver(String browser) {
        this.browser = browser;
    }

    public WebDriver setDriver() {
        if (browser.equalsIgnoreCase("firefox")) {
            log.info("Executing on FireFox");

            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        } else if (browser.equalsIgnoreCase("chrome")) {
            log.info("Executing on CHROME");

            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("ie")) {
            log.info("Executing on IE");
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
        }
        return driver;
    }

}
