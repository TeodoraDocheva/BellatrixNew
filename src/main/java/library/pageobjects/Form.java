package library.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class Form extends PageObject {


    private List<WebElement> sectionElements;

    public Form(WebElement objectContainer, WebDriver driver) {
        super(objectContainer, driver);
        this.sectionElements = objectContainer.findElements(By.cssSelector("div.wpforms-field"));

    }

    public List<FormSectionWithoutName> getNamelessSections() {
        List<FormSectionWithoutName> results = new ArrayList<>();

        for (WebElement element : sectionElements) {
            if (element.findElements(By.cssSelector("label:first-child")).isEmpty()) { // checks if current web element section has no label
                FormSectionWithoutName tempSection = new FormSectionWithoutName(element, driver);
                results.add(tempSection);
            }
        }

        return results;
    }

    public List<FormSectionWithName> getSectionsWithNames() {
        List<FormSectionWithName> results = new ArrayList<>();

        for (WebElement element : sectionElements) {
            if (element.findElements(By.cssSelector("label:first-child")).isEmpty() == false) { // checks if the current web element section has a label
                FormSectionWithName tempSection = new FormSectionWithName(element, driver);
                results.add(tempSection);
            }
        }

        return results;
    }


}
