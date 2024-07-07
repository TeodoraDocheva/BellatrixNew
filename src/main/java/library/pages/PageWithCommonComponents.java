package library.pages;


import library.pageobjects.NavigationMenu;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PageWithCommonComponents extends BasePage{

    private WebElement navigationElement = driver.findElement(By.cssSelector("div.storefront-primary-navigation"));
    public PageWithCommonComponents(WebDriver webDriver) {
        super(webDriver);
    }

    public NavigationMenu getNavigationMenu() {
        return new NavigationMenu(navigationElement,driver);
    }


}
