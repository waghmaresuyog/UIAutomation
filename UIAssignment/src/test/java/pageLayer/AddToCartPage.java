package pageLayer;

import demoblazeApplicationTest.DemoblazeTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

public class AddToCartPage extends DemoblazeTest {

    public AddToCartPage(){
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//a[contains(text(),'Add to cart')]")
    private WebElement addToCart;
    public void clickAddToCart(){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        addToCart.click();
        System.out.println("successful added to Cart ");
    }

    public void acceptPopup(){
        driver.switchTo().alert().accept();
    }

}
