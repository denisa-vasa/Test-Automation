package elements;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.BaseInformation;

public class DashBoardPageElements {

    public DashBoardPageElements() {
        PageFactory.initElements(BaseInformation.getDriver(), this);
    }

    @FindBy(className = "ico-logout")
    public WebElement logout;

    @FindBy(xpath = "//img[contains(@alt, 'Electronics')]")
    public WebElement electronics;
}
