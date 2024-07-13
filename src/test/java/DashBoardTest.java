import globals.Globals;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.CellPhonesPage;
import pages.DashBoardPage;
import pages.ElectronicsPage;
import pages.WishlistPage;
import utilities.BaseInformation;

public class DashBoardTest {

    private final WebDriver driver = BaseInformation.getDriver();
    DashBoardPage dashBoardPage = new DashBoardPage();
    LoginTest loginTest = new LoginTest();
    ElectronicsPage electronicsPage = new ElectronicsPage();
    CellPhonesPage cellPhonesPage = new CellPhonesPage();
    WishlistPage wishlistPage = new WishlistPage();

    @BeforeTest
    public void setup() {
        driver.get(Globals.homePageUrl);
        loginTest.testLoginButtonMenu();
        loginTest.testEmailTextField();
        loginTest.testPasswordTextField();
        loginTest.testLoginButtonSignIn();
    }

    @Test
    public void testHoverOverElectronics(){
        dashBoardPage.hoverElectronics();
    }

    @Test(dependsOnMethods = "testHoverOverElectronics")
    public void testClickElectronics(){
        dashBoardPage.clickElectronics();
    }

    @Test(dependsOnMethods = "testClickElectronics")
    public void testClickCellPhones(){
        electronicsPage.clickCellPhones();

        // Verify that we have navigated to the Cell Phones page
        Assert.assertTrue(electronicsPage.isCellPhonesTitleDisplayed(), "Cell Phones title is not displayed.");
    }

    @Test(dependsOnMethods = "testClickCellPhones")
    public void testDropDownSort() {
        cellPhonesPage.dropDownLowToHigh();

        // Check if the prices are sorted in ascending order
        Assert.assertTrue(cellPhonesPage.isSorted(), "Items are not sorted by price: Low to High");
    }

    @Test(dependsOnMethods = "testDropDownSort")
    public void testWishListButtons() {
        cellPhonesPage.clickWishListButtons();

        //Check if the notification is displayed when an element is added
        Assert.assertTrue(cellPhonesPage.isNotificationDisplayed(), "Notification after adding an element is not displayed.");
        //Check if the wishlist number of products displays number three
        Assert.assertTrue(cellPhonesPage.isNumberOfProductsDisplayed(), "Number of products in wishlist is not displayed.");
    }

    @Test(dependsOnMethods = "testWishListButtons")
    public void testWishListMenu(){
        cellPhonesPage.clickWishList();
    }

    @Test(dependsOnMethods = "testWishListMenu")
    public void testAddToCartCheckBoxes(){
        wishlistPage.clickAddToCartCheckBoxes();
    }

    @Test(dependsOnMethods = "testAddToCartCheckBoxes")
    public void testAddToCartButton(){
        wishlistPage.clickAddToCartButton();

        //Check if the wishlist number of products displays 0
        Assert.assertTrue(cellPhonesPage.isNumberOfProductsDisplayed(), "Number of products in wishlist does not display (0).");
        //Check if the shopping cart displays 3
        Assert.assertTrue(cellPhonesPage.isNumDisplayedShoppingCart(), "Number of products in shopping cart is not displayed.");
    }

    @Test(dependsOnMethods = "testAddToCartButton")
    public void close(){
        driver.close();
    }

    @AfterTest
    public void terminate() {
        driver.quit();
    }
}
