package pages;

import elements.WishlistPageElements;
import org.openqa.selenium.support.PageFactory;
import utilities.BaseInformation;

public class WishlistPage {

    public WishlistPage() {
        PageFactory.initElements(BaseInformation.getDriver(), this);
    }

    WishlistPageElements wishlistPageElements = new WishlistPageElements();

    public void clickAddToCartCheckBoxes(){
        wishlistPageElements.addToCartCheckBox.click();
    }

    public void clickAddToCartButton(){
        wishlistPageElements.addToCartButton.click();
    }
}
