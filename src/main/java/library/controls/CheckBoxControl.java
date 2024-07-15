package library.controls;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Objects;

public class CheckBoxControl extends FormControl {

   // private List<WebElement> options = searchContext.findElements(By.cssSelector("div#wpforms-3347-field_4-container"));

    private WebElement inputElement = searchContext.findElement(By.cssSelector("input"));

    public CheckBoxControl(WebElement objectContainer, WebDriver driver) {

        super(objectContainer, driver);
    }

    @Override
    public void setData(String data) {
        boolean inputData = Boolean.parseBoolean(data);
        boolean isSelected = inputElement.isSelected();

        if (inputData) {
            if (isSelected == false) {
                inputElement.click();
            }
        }

        if (inputData == false) {
            if (isSelected) {
                inputElement.click();
            }

        }
        System.out.println(isSelected);

    }

}
