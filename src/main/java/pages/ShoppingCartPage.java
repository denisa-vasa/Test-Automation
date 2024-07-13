package pages;

import elements.ShoppingCartPageElements;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import utilities.BaseInformation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ShoppingCartPage {

    public ShoppingCartPage() {
        PageFactory.initElements(BaseInformation.getDriver(), this);
    }

    ShoppingCartPageElements shoppingCartPageElements = new ShoppingCartPageElements();

    public void hoverShoppingCartMenu(){
        Actions actions = new Actions(BaseInformation.getDriver());
        actions.moveToElement(shoppingCartPageElements.shoppingCartMenu).perform();
    }

    public void clickGoToCartButton(){
        shoppingCartPageElements.goToCartButton.click();
    }

    public boolean isGoToCartButton() {
        try {
            return BaseInformation.getDriver().findElement(By.cssSelector("button.button-1.cart-button")).isDisplayed();
        } catch (org.openqa.selenium.NoSuchElementException e) {
            return false;
        }
    }

    public boolean isShoppingCart() {
        try {
            return BaseInformation.getDriver().findElement(By.tagName("h1")).isDisplayed();
        } catch (org.openqa.selenium.NoSuchElementException e) {
            return false;
        }
    }

    public boolean isButtonUpdate() {
        try {
            return BaseInformation.getDriver().findElement(By.id("updatecart")).isDisplayed();
        } catch (org.openqa.selenium.NoSuchElementException e) {
            return false;
        }
    }

    public boolean isButtonContinue() {
        try {
            return BaseInformation.getDriver().findElement(By.name("continueshopping")).isDisplayed();
        } catch (org.openqa.selenium.NoSuchElementException e) {
            return false;
        }
    }

    public boolean isButtonEstimate() {
        try {
            return BaseInformation.getDriver().findElement(By.id("open-estimate-shipping-popup")).isDisplayed();
        } catch (org.openqa.selenium.NoSuchElementException e) {
            return false;
        }
    }

    public double sumOfItemPrices() {
        double sum = 0;
        for (WebElement productSubtotalElement : shoppingCartPageElements.productSubtotalElements) {
            String priceText = productSubtotalElement.getText();
            double priceValue = extractPriceValue(priceText);
            sum += priceValue;
        }
        return sum;
    }

    public double extractTotalPrice() {
        String totalPriceText = shoppingCartPageElements.totalPriceElement.getText();
        return extractPriceValue(totalPriceText);
    }

    private double extractPriceValue(String priceText) {
        Pattern pattern = Pattern.compile("\\$([0-9,.]+)");
        Matcher matcher = pattern.matcher(priceText);
        if (matcher.find()) {
            String priceValueStr = matcher.group(1).replace(",", "");
            return Double.parseDouble(priceValueStr);
        }
        return 0;
    }

}
