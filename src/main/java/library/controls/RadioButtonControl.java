package library.controls;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Objects;

public class RadioButtonControl extends FormControl{


   // private List<WebElement> options = searchContext.findElements(By.cssSelector("li"));

    private WebElement inputElement = searchContext.findElement(By.cssSelector("input"));
    public RadioButtonControl(WebElement objectContainer, WebDriver driver) {
        super(objectContainer, driver);
    }

    @Override
    public void setData(String data) {
        boolean bool = Boolean.parseBoolean(data);
        inputElement.click();
    }
}
