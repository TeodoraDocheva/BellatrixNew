package library.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class FormSectionWithName extends FormSectionWithoutName {

    private WebElement sectionElement;
    private WebDriverWait wait;

    public FormSectionWithName(WebElement sectionElement, WebDriver driver) {
        super(sectionElement, driver);
        this.sectionElement = sectionElement;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public String getSectionName() {
        return sectionElement.findElement(By.cssSelector("label")).getText();
    }

//    public void setData(String data) {
//        WebElement inputElement = sectionElement.findElement(By.cssSelector("input"));
//        inputElement.clear();
//        inputElement.sendKeys(data);
//    }
//
//    public FormSectionWithName getFormSectionWithName(String sectionName) {
//        for (FormSectionWithName section : getSectionsWithNames()) {
//            if (sectionName.equalsIgnoreCase(section.getSectionName())) {
//                return section;
//            }
//        }
//        throw new IllegalArgumentException("Section with name " + sectionName + " not found");
//    }



}
