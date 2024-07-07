package library.controls;

import library.pageobjects.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public abstract class FormControl extends PageObject {

    //protected WebElement nameElement = searchContext.findElement(By.cssSelector("article#post-3342")); // ne e vqrno
//    protected WebElement nameElement = searchContext.findElement(By.cssSelector("div content div[id*=container] div > div, div[id*=container] input, div[id*=container] li"));
    protected WebElement nameElement = searchContext.findElement(By.cssSelector("label"));
    public FormControl(WebElement objectContainer, WebDriver driver) {

        super(objectContainer, driver);
        searchContext = objectContainer;
    }

    public String getLabel() {
        return nameElement.getText();

    }

    public abstract void setData(String data);
//2 vida sekcii - s ime i bez ime FormSection samo sus search context zza sekciite

}
