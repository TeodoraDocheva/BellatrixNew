package library.controls;

import library.pageobjects.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public abstract class FormControl extends PageObject {

    protected WebElement nameElement = searchContext.findElement(By.cssSelector("label"));
    public FormControl(WebElement objectContainer, WebDriver driver) {

        super(objectContainer, driver);
        searchContext = objectContainer;
    }

    public String getLabel() {
        return nameElement.getText();

    }
    public abstract void setData(String data);

}
