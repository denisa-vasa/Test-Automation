package elements;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.BaseInformation;

public class ElectronicsPageElements {

    public ElectronicsPageElements() {
        PageFactory.initElements(BaseInformation.getDriver(), this);
    }

    @FindBy(linkText = "Cell phones")
    public WebElement cellPhones;
}
