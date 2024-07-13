package elements;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.BaseInformation;

public class HomePageElements {

    public HomePageElements() {
        PageFactory.initElements(BaseInformation.getDriver(), this);
    }

    @FindBy(css = "a[href='/login?returnUrl=%2F']")
    public WebElement loginButton;
}
