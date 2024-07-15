package library.pages;

import library.pageobjects.Form;
import library.pageobjects.FormSectionWithName;
import library.pageobjects.FormSectionWithoutName;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class ContactFormPage extends PageWithCommonComponents {


    public static final String CONTACT_URL = "https://demos.bellatrix.solutions/contact-form/";

    private List<FormSectionWithName> formSectionWithNames;


    public ContactFormPage(WebDriver webDriver) {
        super(webDriver);
        this.driver = webDriver;
        setSectionsWithNames();
    }


   public FormSectionWithName getFormSectionWithName(String sectionName) {
       List<FormSectionWithName> sectionsWithNames = formSectionWithNames;
       for (FormSectionWithName section : sectionsWithNames) {
           if (sectionName.equalsIgnoreCase(section.getSectionName())) { // Case-insensitive match
               return section;
           }
       }
       throw new IllegalArgumentException("Section with name " + sectionName + " not found");
   }

   private void setSectionsWithNames() {
       if (formSectionWithNames == null) {
           WebElement formContainer = driver.findElement(By.cssSelector("div.wpforms-field-container"));
           this.formSectionWithNames = new Form(formContainer, driver).getSectionsWithNames();
       }

   }

   public FormSectionWithoutName getFormSectionWithoutName() {
       WebElement formContainer = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("div.wpforms-field-container")));
       return new Form(formContainer, driver).getNamelessSections().get(0);
   }

}
