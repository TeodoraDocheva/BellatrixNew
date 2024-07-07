package library.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class NavigationMenu extends PageObject {

   private List<WebElement> navigationButtonElements = searchContext.findElements(By.cssSelector("ul[class=nav-menu] li"));

    public NavigationMenu(WebElement objectContainer, WebDriver driver) {
        super(objectContainer, driver);
    }

    public void navigateTo(String buttonName) {

        for (var button : navigationButtonElements) {
            if (button.getText().equals(buttonName)) {
                button.click();
                break;
            }


        }

    }


}
