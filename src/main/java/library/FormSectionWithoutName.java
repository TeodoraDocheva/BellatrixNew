package library;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.ControlFactory;

import java.util.List;

public class FormSectionWithoutName extends PageObject {


    private ControlFactory factory;

    private List<WebElement> controlElements;


    public FormSectionWithoutName(WebElement element, WebDriver driver) {
        super(element, driver);
        controlElements = driver.findElements(By.cssSelector("div.wpforms-field-row-block"));
        factory = new ControlFactory(controlElements, driver);
    }

    public FormControl getControl(String name) throws Exception {
       return factory.getControl(name);

    }
}
