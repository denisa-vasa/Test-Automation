package elements;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.BaseInformation;

public class FormPageElements {

    public FormPageElements() {
        PageFactory.initElements(BaseInformation.getDriver(), this);
    }

    @FindBy(id = "gender-male")
    public WebElement radio1;

    @FindBy(id = "gender-female")
    public WebElement radio2;

    @FindBy(id = "FirstName")
    public WebElement firstName;

    @FindBy(id = "LastName")
    public WebElement lastname;

    @FindBy(id = "Email")
    public WebElement email;

    @FindBy(id = "Company")
    public WebElement company;

    @FindBy(id = "Password")
    public WebElement password;

    @FindBy(id = "ConfirmPassword")
    public WebElement confirmPassword;

    @FindBy(name = "DateOfBirthDay")
    public WebElement day;

    @FindBy(name = "DateOfBirthMonth")
    public WebElement month;

    @FindBy(name = "DateOfBirthYear")
    public WebElement year;

    @FindBy(id = "Newsletter")
    public WebElement checkBox;

    @FindBy(id = "register-button")
    public WebElement registerButton2;
}
