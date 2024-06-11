package Factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MoreInfo {

    public static final String moreInfo_URL = "https://demos.bellatrix.solutions/product/proton-m/";
    private final WebDriver webDriver;

    private final WebDriverWait wait;

    public MoreInfo(WebDriver driver) {
        this.webDriver = driver;
        this.wait = new WebDriverWait(this.webDriver, Duration.ofSeconds(15));
    }

    public void navigateTo() {
        this.webDriver.get(moreInfo_URL);
    }

    public boolean isMoreInfoURLLoaded() {

        return wait.until(ExpectedConditions.urlToBe(moreInfo_URL));
    }
}
