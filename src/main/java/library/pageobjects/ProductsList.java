package library.pageobjects;

import library.pageobjects.InStockItems;
import library.pageobjects.OutOfStockItems;
import library.pageobjects.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class ProductsList extends PageObject {


    private List<WebElement> inStockElement = searchContext.findElements(By.cssSelector("li.sale"));

    private List<WebElement> outOfStockElement = searchContext.findElements(By.cssSelector("li.outofstock"));

    public ProductsList(WebElement objectContainer, WebDriver driver) {

        super(objectContainer, driver);
    }

    //rename items to item
    public List<InStockItems> getInStockItems() {
        List<InStockItems> items = new ArrayList<>();
        for (WebElement element : inStockElement) {
            InStockItems tempItem = new InStockItems(element, driver);
            items.add(tempItem);
        }

        return items;
    }

    public List<OutOfStockItems> getOutOfStockItems() {
        List<OutOfStockItems> items = new ArrayList<>();
        for (WebElement element : outOfStockElement) {
            OutOfStockItems tempItem = new OutOfStockItems(element, driver);
            items.add(tempItem);
        }
        return items;
    }

    public InStockItems getInStockItemByName(String name) {
        return getInStockItems().stream()
                .filter((item)->item.getName().equals(name))
                .findFirst()
                .orElse(null);
    }

    public OutOfStockItems getOutOfStockItemByName(String name) {

        OutOfStockItems resultItem = null;

        for (OutOfStockItems item : getOutOfStockItems()) {
            if (item.getName().equals(name)) {
                resultItem = item;
                break;
            }
        }
        return resultItem;
    }

    public InStockItems getInStockItemByPrice(String price) {
        return getInStockItems().stream()
                .filter((item)->item.getName().equals(price))
                .findFirst()
                .orElse(null);
    }
}
