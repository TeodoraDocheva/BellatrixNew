package utils;

import library.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ControlFactory {
    private List<WebElement> controlElements;
    private WebDriver driver;

    public ControlFactory(List<WebElement> elements, WebDriver driver) {
        this.driver = driver;
        controlElements = elements;  //this.

    }

    public FormControl getControl(String controlName) throws Exception {

        FormControl control = null;

        List<FormControl> allControls = getControls();

        for (FormControl controlElement : allControls) {

            String currentControlName = controlElement.getLabel();
            if (Objects.equals(currentControlName, controlName)) {
                control = controlElement;
                break;
            }
        }

        if (control == null) {
            throw new Exception("Control is empty");
        }

        return control;
    }


    private List<FormControl> getControls() throws Exception {
        List<FormControl> controls = new ArrayList<>();

        for (WebElement element : controlElements) {
            FormControl tempControl = getControlFromElement(element);
            controls.add(tempControl);
        }

        return controls;
    }

    private FormControl getControlFromElement(WebElement element) throws Exception {

        FormControl control;

        String dataFormGroupType = element.findElement(By.cssSelector("input")).getAttribute("type"); //div.form-group

        switch (dataFormGroupType) {

            case "text" :
                control = new TextControl(element, driver);
                break;
            case "checkbox" :
                control = new CheckBoxControl(element, driver);
                break;
        //    case "email" :
        //        control = new TextControl(element, driver);
        //        break;
            case "radio" :
                control = new RadioButtonControl(element, driver);
                break;
            default:
                throw new Exception("Data type not supported");
        }

        return control;
    }

}
