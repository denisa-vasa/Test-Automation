import globals.Globals;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.*;
import utilities.BaseInformation;

public class RegisterTest {

    private final WebDriver driver = BaseInformation.getDriver();
    HomePage homePage = new HomePage();
    SignInPage signInPage = new SignInPage();
    FormPage formPage = new FormPage();

    @BeforeTest
    public void setup(){
        driver.get(Globals.homePageUrl);
    }

    @Test
    public void testLoginButton() {
        homePage.clickLoginButton();
    }

    @Test(dependsOnMethods = "testLoginButton")
    public void testRegister() {
        signInPage.clickRegisterButton1();

        // Title of the page
        String title = driver.getTitle();
        System.out.println("The title of the page is: " + title);
    }

    @Test(dependsOnMethods = "testRegister")
    public void testRadioButtons() {
        // Click the male radio button
        formPage.clickRadioButtonMale();
        formPage.clickRadioButtonFemale();
    }

    @Test(dependsOnMethods = "testRadioButtons")
    public void testTextFields() {
        formPage.fillFirstNameTextField();
        formPage.fillLastNameField();
    }

    @Test(dependsOnMethods = "testTextFields")
    public void testDropDown() {
        formPage.selectDropDown1();
        formPage.selectDropDown2();
        formPage.selectDropDown3();
    }

    @Test(dependsOnMethods = "testDropDown")
    public void testEmailAndCompany() {
        formPage.fillEmail();
        formPage.fillCompany();
    }

    @Test(dependsOnMethods = "testEmailAndCompany")
    public void testCheckBox() {
        formPage.clickCheckBox();
    }

    @Test(dependsOnMethods = "testCheckBox")
    public void testTextFieldPassword() {
        formPage.fillPassword();
        formPage.fillConfirmPassword();
    }

    @Test(dependsOnMethods = "testTextFieldPassword")
    public void testRegisterButtonForm() {
        formPage.clickRegisterButton2();

        // Verify that registration is successful
        Assert.assertTrue(formPage.isRegistrationSuccessful(), "Registration was not successful.");
    }

    @AfterTest
    public void terminate() {
        driver.quit();
    }
}