package library.pageobjects;

import library.pageobjects.AbstractProduct;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class OutOfStockItems extends AbstractProduct {
    public OutOfStockItems(WebElement objectContainer, WebDriver driver) {
        super(objectContainer, driver);
    }

        //        this.name = searchContext.findElement(By.cssSelector(".woocommerce-loop-product__title")).getText();
        //        this.price = searchContext.findElement(By.cssSelector(".price")).getText();
        //        this.onSale = !searchContext.findElements(By.cssSelector(".onsale")).isEmpty();




}