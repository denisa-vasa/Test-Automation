package elements;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.BaseInformation;

public class SignInPageElements {

    public SignInPageElements() {
        PageFactory.initElements(BaseInformation.getDriver(), this);
    }

    @FindBy(css = "button.button-1.register-button")
    public WebElement registerButton1;

    @FindBy(id = "Email")
    public WebElement email;

    @FindBy(id = "Password")
    public WebElement password;

    @FindBy(xpath = "//button[@class='button-1 login-button']")
    public WebElement login;
}
