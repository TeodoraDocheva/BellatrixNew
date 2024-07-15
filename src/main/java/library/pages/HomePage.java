package library.pages;

import library.pageobjects.ProductsList;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v85.page.Page;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends PageWithCommonComponents {

    private WebElement productListElement = driver.findElement(By.cssSelector("#main ul.products"));
    public static final String HOME_URL = "https://demos.bellatrix.solutions/";

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public ProductsList productsList = new ProductsList(productListElement, driver);

    public void navigateToContactForm() {
        var contactFormButton = driver.findElement(By.cssSelector("li.page-item-3342"));
        contactFormButton.click();
    }

}
