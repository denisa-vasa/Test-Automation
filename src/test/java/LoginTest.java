import globals.Globals;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.DashBoardPage;
import pages.HomePage;
import pages.SignInPage;
import utilities.BaseInformation;

public class LoginTest {

    private final WebDriver driver = BaseInformation.getDriver();
    HomePage homePage = new HomePage();
    SignInPage signInPage = new SignInPage();
    DashBoardPage dashBoardPage = new DashBoardPage();

    @BeforeTest
    public void setup(){
        driver.get(Globals.homePageUrl);
    }

    @Test
    public void testLoginButtonMenu() {
        homePage.clickLoginButton();
    }

    @Test(dependsOnMethods = "testLoginButtonMenu")
    public void testEmailTextField(){
        signInPage.fillEmail();
    }

    @Test(dependsOnMethods = "testEmailTextField")
    public void testPasswordTextField(){
        signInPage.fillPassword();
    }

    @Test(dependsOnMethods = "testPasswordTextField")
    public void testLoginButtonSignIn(){
        signInPage.clickLoginButton();

        // Verify that the welcome title and log out menu are displayed
        Assert.assertTrue(signInPage.isWelcomeTitleDisplayed(), "Welcome title is not displayed.");
        Assert.assertTrue(signInPage.isLogOutDisplayed(), "Log out menu is displayed.");
    }

    @Test(dependsOnMethods = "testLoginButtonSignIn")
    public void testLogOutMenu(){
        dashBoardPage.clickLogOutMenu();
    }

    @AfterTest
    public void terminate() {
        driver.quit();
    }
}
