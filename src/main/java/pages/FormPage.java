package pages;

import elements.FormPageElements;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import utilities.BaseInformation;

import java.util.List;

public class FormPage {

    public FormPage() {
        PageFactory.initElements(BaseInformation.getDriver(), this);
    }

    FormPageElements formPageElements = new FormPageElements();

    public void clickRadioButtonMale() {
        formPageElements.radio1.click();
    }

    public void clickRadioButtonFemale() {
        formPageElements.radio2.click();
    }

    public void fillFirstNameTextField() {
        formPageElements.firstName.sendKeys("test01");
    }

    public void fillLastNameField() {
        formPageElements.lastname.sendKeys("test01");
    }

    public void fillEmail() {
        formPageElements.email.sendKeys("massie6751@jafm8vaj.cashbenties.com");
    }

    public void fillCompany() {
        formPageElements.company.sendKeys("polis");
    }

    public void fillPassword() {
        formPageElements.password.sendKeys("kookie");
    }

    public void fillConfirmPassword() {
        formPageElements.confirmPassword.sendKeys("kookie");
    }

    public void selectDropDown1(){
        Select drp1 = new Select(formPageElements.day);
        List<WebElement> options = drp1.getOptions();

        for(WebElement option : options){
            drp1.selectByVisibleText(option.getText());
        }
    }

    public void selectDropDown2(){
        Select drp2 = new Select(formPageElements.month);
        List<WebElement> options = drp2.getOptions();

        for(WebElement option : options){
            drp2.selectByVisibleText(option.getText());
        }
    }

    public void selectDropDown3(){
        Select drp3 = new Select(formPageElements.year);
        List<WebElement> options = drp3.getOptions();

        for(WebElement option : options){
            drp3.selectByVisibleText(option.getText());
        }
    }

    public void clickCheckBox(){
        formPageElements.checkBox.click();
    }

    public void clickRegisterButton2(){
        formPageElements.registerButton2.click();
    }

    public boolean isRegistrationSuccessful() {
        try {
            return BaseInformation.getDriver().findElement(By.className("result")).isDisplayed();
        } catch (org.openqa.selenium.NoSuchElementException e) {
            return false;
        }
    }
}
