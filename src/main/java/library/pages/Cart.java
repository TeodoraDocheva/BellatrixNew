package library.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Cart extends PageWithCommonComponents {

    public static final String CART_URL = "https://demos.bellatrix.solutions/cart/";

    public Cart(WebDriver webDriver) {
        super(webDriver);
    }

    public boolean isCartURLLoaded() {
        return wait.until(ExpectedConditions.urlToBe(CART_URL));
    }
}
