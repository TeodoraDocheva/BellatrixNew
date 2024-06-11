package Factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Cart {

    public static final String CART_URL = "https://demos.bellatrix.solutions/cart/";
    private final WebDriver webDriver;
    private final WebDriverWait wait;

    public Cart(WebDriver driver) {
        this.webDriver = driver;
        this.wait = new WebDriverWait(this.webDriver, Duration.ofSeconds(15));
    }

    public void navigateTo() {
        this.webDriver.get(CART_URL);
    }

    public boolean isCartURLLoaded() {
        return wait.until(ExpectedConditions.urlToBe(CART_URL));
    }
}
