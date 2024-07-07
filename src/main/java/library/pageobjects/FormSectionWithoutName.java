package library.pageobjects;

import library.controls.FormControl;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import library.controls.factory.ControlFactory;

import java.util.List;

public class FormSectionWithoutName extends PageObject {


    private ControlFactory factory;

    private List<WebElement> controlElements;


    public FormSectionWithoutName(WebElement element, WebDriver driver) {
        super(element, driver);
        controlElements = searchContext.findElements(By.cssSelector("div.wpforms-field-row-block, li[class*=choice]")); // div.wpforms-field-row-block //div.wpforms-field input
        factory = new ControlFactory(controlElements, driver);
    }

    public FormControl getControl(String name) throws Exception {
       return factory.getControl(name);

    }

    public void printElementLabels() {
        for (var element:controlElements ) {
            System.out.println(element.getText());
        }

    }
}
