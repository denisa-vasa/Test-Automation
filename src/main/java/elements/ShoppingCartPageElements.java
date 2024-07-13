package elements;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.BaseInformation;

import java.util.List;

public class ShoppingCartPageElements {

    public ShoppingCartPageElements() {
        PageFactory.initElements(BaseInformation.getDriver(), this);
    }

    @FindBy(css = "a[href='/cart']")
    public WebElement shoppingCartMenu;

    @FindBy(css = "button.button-1.cart-button")
    public WebElement goToCartButton;

    @FindBy(className = "product-subtotal")
    public List<WebElement> productSubtotalElements;

    @FindBy(className = "value-summary")
    public WebElement totalPriceElement;
}
