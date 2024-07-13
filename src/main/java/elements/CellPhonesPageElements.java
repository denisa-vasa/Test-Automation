package elements;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.BaseInformation;

import java.util.List;

public class CellPhonesPageElements {

    public CellPhonesPageElements() {
        PageFactory.initElements(BaseInformation.getDriver(), this);
    }

    @FindBy(id = "products-orderby")
    public WebElement sort;

    @FindBy(xpath = "//button[@class='button-2 add-to-wishlist-button' and @title='Add to wishlist']")
    public List<WebElement> wishlist;

    @FindBy(css = "a[href='/wishlist']")
    public WebElement wishListMenu;
}
