package pages;

import elements.CellPhonesPageElements;
import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.BaseInformation;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CellPhonesPage {

    public CellPhonesPage() {
        PageFactory.initElements(BaseInformation.getDriver(), this);
    }

    CellPhonesPageElements cellPhonesPageElements = new CellPhonesPageElements();
    List<Double> sortedPrices = new ArrayList<>();

    public void dropDownLowToHigh() {
        Select lowToHigh = new Select(cellPhonesPageElements.sort);
        lowToHigh.selectByVisibleText("Price: Low to High");

        List<WebElement> priceElements = BaseInformation.getDriver().findElements(By.className("price"));

        List<Double> prices = new ArrayList<>();

        for (WebElement element : priceElements) {
            String priceText = element.getText().replace("$", "").replace(",", "");

            // Check if the priceText is not empty before parsing
            if (!priceText.isEmpty()) {
                try {
                    double price = Double.parseDouble(priceText);
                    prices.add(price);
                } catch (NumberFormatException e) {
                    // Handle the case when the conversion fails (e.g., log the error or skip the element)
                    System.err.println("Error parsing price: " + priceText);
                }
            } else {
                // Handle the case when the priceText is empty (e.g., log a message or skip the element)
                System.err.println("Empty price text encountered.");
            }
        }

        Collections.sort(prices);
    }

    public boolean isSorted() {
        for (int i = 0; i < sortedPrices.size() - 1; i++) {
            if (sortedPrices.get(i) > sortedPrices.get(i + 1)) {
                return false;
            }
        }
        return true;
    }

    public void clickWishListButtons() {
        List<WebElement> wishlistButtons = cellPhonesPageElements.wishlist;

        for (int i = 0; i < wishlistButtons.size(); i++) {
            try {
                // Refresh the element reference inside the loop
                WebElement button = cellPhonesPageElements.wishlist.get(i);

                // Scroll into view to make sure the button is clickable
                ((JavascriptExecutor) BaseInformation.getDriver()).executeScript("arguments[0].scrollIntoView(true);", button);

                // Wait for the element to be clickable before clicking
                new WebDriverWait(BaseInformation.getDriver(), Duration.ofSeconds(10))
                        .until(ExpectedConditions.elementToBeClickable(button));

                // Click the button
                button.click();

                // You may need to wait for any overlay or loading indicators to disappear
                // Insert wait code here if necessary

            } catch (StaleElementReferenceException e) {
                // Handle the exception if needed
                System.err.println("Error refreshing element reference: " + e.getMessage());
            } catch (ElementClickInterceptedException e) {
                // Handle the exception if needed
                System.err.println("Error clicking wishlist button: " + e.getMessage());
            }
        }
    }

    public boolean isNotificationDisplayed() {
        try {
            // Wait for the notification to be visible before checking if it is displayed
            WebDriverWait wait = new WebDriverWait(BaseInformation.getDriver(), Duration.ofSeconds(10));
            WebElement notificationElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("content")));

            return notificationElement.isDisplayed();
        } catch (org.openqa.selenium.NoSuchElementException | org.openqa.selenium.TimeoutException e) {
            return false;
        }
    }

    public boolean isNumberOfProductsDisplayed() {
        try {
            return BaseInformation.getDriver().findElement(By.className("wishlist-qty")).isDisplayed();
        } catch (org.openqa.selenium.NoSuchElementException e) {
            return false;
        }
    }

    public void clickWishList() {
        cellPhonesPageElements.wishListMenu.click();
    }

    public boolean isNumDisplayedShoppingCart() {
        try {
            return BaseInformation.getDriver().findElement(By.className("cart-qty")).isDisplayed();
        } catch (org.openqa.selenium.NoSuchElementException e) {
            return false;
        }
    }
}
