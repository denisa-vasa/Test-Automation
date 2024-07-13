package pages;

import elements.SignInPageElements;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import utilities.BaseInformation;

public class SignInPage {

    public SignInPage() {
        PageFactory.initElements(BaseInformation.getDriver(), this);
    }

    SignInPageElements signInPageElements = new SignInPageElements();

    public void clickRegisterButton1(){
        signInPageElements.registerButton1.click();
    }

    public void fillEmail(){
        signInPageElements.email.sendKeys("massie6751@jafm8vaj.cashbenties.com");
    }

    public void fillPassword(){
        signInPageElements.password.sendKeys("kookie");
    }

    public void clickLoginButton(){
        signInPageElements.login.click();
    }

    public boolean isWelcomeTitleDisplayed() {
        // Example: Check for the presence of a welcome message
        try {
            // Modify the locator based on your actual application structure
            return BaseInformation.getDriver().findElement(By.xpath("//h2[text()='Welcome to our store']")).isDisplayed();
        } catch (org.openqa.selenium.NoSuchElementException e) {
            return false;
        }
    }

    public boolean isLogOutDisplayed() {
        try {
            return BaseInformation.getDriver().findElement(By.className("ico-logout")).isDisplayed();
        } catch (org.openqa.selenium.NoSuchElementException e) {
            return false;
        }
    }
}
