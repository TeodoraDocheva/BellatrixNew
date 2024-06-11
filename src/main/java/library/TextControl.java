package library;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import javax.swing.*;

public class TextControl extends FormControl {
    public TextControl(WebElement objectContainer, WebDriver driver) {
        super(objectContainer, driver);
    }

    @Override
    public void setData(String data) {
        WebElement input = searchContext.findElement(By.cssSelector("input")); //text
        input.clear();
        input.sendKeys(data);
    }

}
