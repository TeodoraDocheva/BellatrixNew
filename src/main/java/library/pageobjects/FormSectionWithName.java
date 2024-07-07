package library.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

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


    public FormSectionWithName getFormSectionWithName(String sectionName) {
       List<FormSectionWithName> sectionsWithNames = getSectionsWithNames();
       for (FormSectionWithName section : sectionsWithNames) {
           if (sectionName.equalsIgnoreCase(section.getSectionName())) { // Case-insensitive match
               return section;
           }
       }
       throw new IllegalArgumentException("Section with name " + sectionName + " not found");
   }

   public List<FormSectionWithName> getSectionsWithNames() {
       WebElement formContainer = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("div.wpforms-field-container"))); //
       return new Form(formContainer, driver).getSectionsWithNames();
   }


}
