package library;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utils.ControlFactory;

import java.util.List;

public class ContactForm extends BasePage {


    public static final String CONTACT_URL = "https://demos.bellatrix.solutions/contact-form/";

    private List<WebElement> controlElements; // = driver.findElements(By.cssSelector("input"));
    private List<WebElement> sectionElements; // => get sections - to be linked to get control
    private ControlFactory factory;


    public ContactForm(WebDriver webDriver) {
        super(webDriver);
        this.driver = webDriver;
        this.navigateToContact();
        this.controlElements = driver.findElements(By.cssSelector("div[id*=container] input"));
        this.factory = new ControlFactory(controlElements, driver);

    }

    public void navigateToContact() {
        this.driver.get(CONTACT_URL);
    }

    public boolean isContactURLLoaded() {
        return wait.until(ExpectedConditions.urlToBe(CONTACT_URL));
    }

    public FormControl getFormControl(String name) throws Exception {
        return factory.getControl(name);
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
