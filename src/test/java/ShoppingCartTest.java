import globals.Globals;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.ShoppingCartPage;
import utilities.BaseInformation;

public class ShoppingCartTest {

    private final WebDriver driver = BaseInformation.getDriver();
    DashBoardTest dashBoardTest = new DashBoardTest();
    ShoppingCartPage shoppingCartPage = new ShoppingCartPage();

    @BeforeTest
    public void setup(){
        driver.get(Globals.homePageUrl);
        dashBoardTest.testHoverOverElectronics();
        dashBoardTest.testClickElectronics();
        dashBoardTest.testClickCellPhones();
        dashBoardTest.testDropDownSort();
        dashBoardTest.testWishListButtons();
        dashBoardTest.testWishListMenu();
        dashBoardTest.testAddToCartCheckBoxes();
        dashBoardTest.testAddToCartButton();
    }

    @Test
    public void testHoverShoppingCart(){
        shoppingCartPage.hoverShoppingCartMenu();

        //Verify that the GoTo Cart button is displayed
        Assert.assertTrue(shoppingCartPage.isGoToCartButton(), "The Go To Cart button is displayed.");
    }

    @Test(dependsOnMethods = "testHoverShoppingCart")
    public void testGoToShoppingCart(){
        shoppingCartPage.clickGoToCartButton();

        //Verify that we have navigated to Shopping Cart
        Assert.assertTrue(shoppingCartPage.isShoppingCart(), "The Shopping Cart title is displayed.");
        //Verify that following buttons are displayed
        Assert.assertTrue(shoppingCartPage.isButtonUpdate(), "This button is not displayed.");
        Assert.assertTrue(shoppingCartPage.isButtonContinue(), "This button is not displayed.");
        Assert.assertTrue(shoppingCartPage.isButtonEstimate(), "This button is not displayed.");
    }

    @Test(dependsOnMethods = "testGoToShoppingCart")
    public void verifyTotalPrice() {
        double sumOfItemPrices = shoppingCartPage.sumOfItemPrices();
        double totalPriceValue = shoppingCartPage.extractTotalPrice();

        // Use a delta to handle precision issues
        double delta = 0.001; // Adjust as needed based on your requirements

        // Provide a more informative error message with actual values
        Assert.assertEquals(sumOfItemPrices, totalPriceValue, delta,
                "Sum of item prices does not match total price on the shopping cart page. Actual Sum: "
                        + sumOfItemPrices + ", Actual Total Price: " + totalPriceValue);
    }


    @Test(dependsOnMethods = "verifyTotalPrice")
    public void close(){
        driver.close();
    }

    @AfterTest
    public void terminate() {
        driver.quit();
    }
}
