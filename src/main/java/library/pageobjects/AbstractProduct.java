package library.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public abstract class AbstractProduct extends PageObject {

    protected WebElement nameElement = searchContext.findElement(By.cssSelector("h2"));
    protected WebElement imageElement = searchContext.findElement(By.cssSelector("img"));
    protected WebElement priceElement = searchContext.findElement(By.cssSelector(".price"));
    protected WebElement buttonElement = searchContext.findElement(By.cssSelector("a.button"));

    public AbstractProduct(WebElement objectContainer, WebDriver driver) {
        super(objectContainer, driver);
    }

    public String getName() {
        return nameElement.getText();
    }

    public String getPrice() {
        return priceElement.getText();
    }


    protected void clickMainButton() {
        buttonElement.click();
    }

    public void clickImage() {
        imageElement.click();
    }

    public void clickPrice() {priceElement.click();}


}
