package library.pages;

import library.pageobjects.Form;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ContactFormPage extends PageWithCommonComponents {


    public static final String CONTACT_URL = "https://demos.bellatrix.solutions/contact-form/";

  //  WebElement formContainer = driver.findElement(By.cssSelector("div.wpforms-field-container"));


    public ContactFormPage(WebDriver webDriver) {
        super(webDriver);
        this.driver = webDriver;
    }


//    public FormSectionWithName getFormSectionWithName(String sectionName) {
//        List<FormSectionWithName> sectionsWithNames = getSectionsWithNames();
//        for (FormSectionWithName section : sectionsWithNames) {
//            if (sectionName.equalsIgnoreCase(section.getSectionName())) { // Case-insensitive match
//                return section;
//            }
//        }
//        throw new IllegalArgumentException("Section with name " + sectionName + " not found");
//    }

//    public List<FormSectionWithName> getSectionsWithNames() {
//        WebElement formContainer = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("div.wpforms-field-container"))); //
//        return new Form(formContainer, driver).getSectionsWithNames();
//    }

    public Form getForm () {
        WebElement formContainer = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("div.wpforms-field-container")));
        return new Form(formContainer, driver);
    }

}
