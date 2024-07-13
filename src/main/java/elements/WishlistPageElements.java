package elements;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.BaseInformation;

public class WishlistPageElements {

    public WishlistPageElements() {
        PageFactory.initElements(BaseInformation.getDriver(), this);
    }

    @FindBy(name = "addtocart")
    public WebElement addToCartCheckBox;

    @FindBy(name = "addtocartbutton")
    public WebElement addToCartButton;
}
