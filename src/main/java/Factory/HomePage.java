package Factory;

import library.BasePage;
import library.ProductsList;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends BasePage {

    private WebElement productListElement = driver.findElement(By.cssSelector("#main ul.products"));
    public static final String HOME_URL = "https://demos.bellatrix.solutions/";

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void navigateTo() {
        this.driver.get(HOME_URL);
    }

    public boolean isURLLoaded() {
        return wait.until(ExpectedConditions.urlToBe(HOME_URL));
    }

    public ProductsList productsList = new ProductsList(productListElement, driver);

    public String getProductName() {
        return "";
    }

    public String getProductPrice() {
        return "";
    }

    public void navigateToContactForm() {
        var contactFormButton = driver.findElement(By.cssSelector("li.page-item-3342"));
        contactFormButton.click();
    }

}
