import library.pageobjects.FormSectionWithName;
import library.pageobjects.FormSectionWithoutName;
import library.pageobjects.InStockItems;
import library.pageobjects.OutOfStockItems;
import library.pages.Cart;
import library.pages.HomePage;
import library.pages.MoreInfoPage;
import library.pages.ContactFormPage;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class AvailabilityTest extends BaseTest {

    @DataProvider(name = "itemsDetails")
    public Object[][] getData() {
        return new Object[][]{
                {"Falcon 9", "600.00€ 50.00€"},
                {"Proton Rocket", "6,500,000.00€ 4,500,000.00€"},
                {"Proton-M", "15.00€"},
                {"Saturn V", "143.00€ 120.00€"},
                {"Falcon Heavy", "1,500.00€ 1,200.00€"}
        };
    }

    @Test
    public void addToCartTest() {
        webDriver.get(HomePage.HOME_URL);
        HomePage homePage = new HomePage(webDriver);
        Cart cartPage = new Cart(webDriver);
        InStockItems item = homePage.productsList.getInStockItemByName("Falcon 9");

        item.viewCart();

        cartPage.isCartURLLoaded();
        Assert.assertTrue(cartPage.isCartURLLoaded(), "Cart page is not loaded");

    }


    @Test(dataProvider = "itemsDetails")
    public void namePriceTest(String productName, String productPrice) {

        webDriver.get(HomePage.HOME_URL);
        HomePage homePage = new HomePage(webDriver);

        InStockItems inStockItem = homePage.productsList.getInStockItemByName(productName);
        OutOfStockItems outOfStockItem = homePage.productsList.getOutOfStockItemByName(productName);

        if (inStockItem != null) {
            String actualProductName = inStockItem.getName();
            String actualProductPrice = inStockItem.getPrice();

            Assert.assertEquals(actualProductName, productName, "Product name does not match.");
            Assert.assertEquals(actualProductPrice, productPrice, "Product price does not match.");

        } else if (outOfStockItem != null) {
            String actualProductName = outOfStockItem.getName();
            String actualProductPrice = outOfStockItem.getPrice();

            Assert.assertEquals(actualProductName, productName, "Product name does not match.");
            Assert.assertEquals(actualProductPrice, productPrice, "Product price does not match.");

        } else {
            Assert.fail("Product with name " + productName + " not found.");
        }
    }

    @Test
    public void readMoreTest() {
        webDriver.get(HomePage.HOME_URL);
        HomePage homePage = new HomePage(webDriver);
        MoreInfoPage moreInfo = new MoreInfoPage(webDriver);

        OutOfStockItems item = homePage.productsList.getOutOfStockItemByName("Proton-M");
        item.clickImage();

        Assert.assertTrue(moreInfo.isMoreInfoURLLoaded(), "More info is not loaded");

    }

    @Test
    public void clickOnPictureTest() {
        webDriver.get(HomePage.HOME_URL);
        HomePage homePage = new HomePage(webDriver);
        MoreInfoPage moreInfo = new MoreInfoPage(webDriver);

        OutOfStockItems item = homePage.productsList.getOutOfStockItemByName("Proton-M");
        item.clickImage();

        Assert.assertTrue(moreInfo.isMoreInfoURLLoaded(), "More info is not loaded");

    }

    @Test
    public void contactTest() throws Exception {
        webDriver.get(HomePage.HOME_URL);
        HomePage homePage = new HomePage(webDriver);
        homePage.navigateToContactForm();
        ContactFormPage contactForm = new ContactFormPage(webDriver);


        FormSectionWithName firstNameSection = contactForm.getFormSectionWithName("Name *");
        firstNameSection.getControl("First").setData("Teodora");
        firstNameSection.getControl("Last").setData("Docheva");

        FormSectionWithoutName firstNamelessSection = contactForm.getFormSectionWithName("Email *");
        firstNamelessSection.getControl("Email *").setData("Docheva");



    }


    @Test
    public void dummyTest() {
        webDriver.get(HomePage.HOME_URL);
        HomePage homePage = new HomePage(webDriver);
        homePage.navigateToContactForm();
        ContactFormPage contactForm = new ContactFormPage(webDriver);

//       for (var section : contactForm.getSectionsWithNames()) {
//           System.out.println(section.getSectionName());
//           section.printElementLabels();
//       }


    }

    @Test
    public void dummyTest2() throws Exception {
        webDriver.get(HomePage.HOME_URL);
        HomePage homePage = new HomePage(webDriver);
        homePage.getNavigationMenu().navigateTo("Contact Form");
        ContactFormPage contactForm = new ContactFormPage(webDriver);

        var form = contactForm.getForm();
        //  form.getSectionsWithNames().get(1).getControl("Bronze – $199.95").setData(true);


//        for (var nameless : form.getNamelessSections()) {
//            nameless.printElementLabels();
//
//        }
//
//        for (var sectionWithName : form.getSectionsWithNames()) {
//            sectionWithName.printElementLabels();

        //       }


    }

}
