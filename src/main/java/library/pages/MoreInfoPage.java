package library.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MoreInfoPage extends PageWithCommonComponents {

    public static final String moreInfo_URL = "https://demos.bellatrix.solutions/product/proton-m/";

    public MoreInfoPage(WebDriver webDriver) {
        super(webDriver);
    }

    public boolean isMoreInfoURLLoaded() {

        return wait.until(ExpectedConditions.urlToBe(moreInfo_URL));
    }
}
