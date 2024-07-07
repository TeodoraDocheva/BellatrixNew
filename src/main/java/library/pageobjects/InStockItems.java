package library.pageobjects;

import library.pageobjects.AbstractProduct;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class InStockItems extends AbstractProduct {

    public InStockItems(WebElement objectContainer, WebDriver driver) {

        super(objectContainer, driver);
    }

    public void addToCart() {
       clickMainButton();
    }

    public void viewCart() {
        List<WebElement> viewCartButtons = searchContext.findElements(By.cssSelector("a.added_to_cart"));
        if (viewCartButtons.isEmpty()){
            addToCart();
        }
        WebElement viewCartButton = searchContext.findElement(By.cssSelector("a.added_to_cart"));
        viewCartButton.click();
    }

    public String getName() {
        return searchContext.findElement(By.cssSelector(".woocommerce-loop-product__title")).getText();
    }

    public String getPrice() {
        return searchContext.findElement(By.cssSelector(".price")).getText();
    }

}


