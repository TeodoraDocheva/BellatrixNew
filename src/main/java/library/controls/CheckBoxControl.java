package library.controls;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Objects;

public class CheckBoxControl extends FormControl {

    private List<WebElement> options = searchContext.findElements(By.cssSelector("div#wpforms-3347-field_4-container")); // locator

    public CheckBoxControl(WebElement objectContainer, WebDriver driver) {

        super(objectContainer, driver);
    }



    @Override
    public void setData(String data) {
        WebElement selectedOption = null;
        for (WebElement option : options ) {
            String tempName = option.getText();

            if (Objects.equals(tempName, data)) {
                selectedOption = option;
            }
        }

        if (selectedOption == null) {

            throw new IllegalArgumentException("Option not found");
        }

        WebElement checkboxButton = selectedOption.findElement(By.cssSelector("value"));
        checkboxButton.click();
    }

}
