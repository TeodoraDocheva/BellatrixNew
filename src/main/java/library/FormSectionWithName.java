package library;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FormSectionWithName extends FormSectionWithoutName {

    private WebElement sectionElement;

    public FormSectionWithName(WebElement sectionElement, WebDriver driver) {
        super(sectionElement, driver);
        this.sectionElement = sectionElement;
    }

    public String getSectionName() {
        return sectionElement.findElement(By.cssSelector("label")).getText();
    }

    public void setData(String data) {
        WebElement inputElement = sectionElement.findElement(By.cssSelector("input"));
        inputElement.clear();
        inputElement.sendKeys(data);
    }
}
