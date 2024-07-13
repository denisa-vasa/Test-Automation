package pages;

import elements.HomePageElements;
import org.openqa.selenium.support.PageFactory;
import utilities.BaseInformation;

public class HomePage {

    public HomePage() {
        PageFactory.initElements(BaseInformation.getDriver(), this);
    }

    HomePageElements homePageElements = new HomePageElements();

    public void clickLoginButton() {
        homePageElements.loginButton.click();
    }
}
