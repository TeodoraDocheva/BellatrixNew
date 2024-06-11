package library;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public abstract class PageObject {

    protected WebElement searchContext;
    protected WebDriver driver;

    public PageObject(WebElement objectContainer, WebDriver driver) {
        this.driver = driver;
        searchContext = objectContainer;
    }

    public void initialize() {

    }
}
