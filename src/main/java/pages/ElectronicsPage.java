package pages;

import elements.ElectronicsPageElements;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import utilities.BaseInformation;

public class ElectronicsPage {

    public ElectronicsPage() {
        PageFactory.initElements(BaseInformation.getDriver(), this);
    }

    ElectronicsPageElements electronicsPageElements = new ElectronicsPageElements();

    public void clickCellPhones(){
        electronicsPageElements.cellPhones.click();
    }

    public boolean isCellPhonesTitleDisplayed() {
        try {
            return BaseInformation.getDriver().findElement(By.xpath("//h1")).isDisplayed();
        } catch (org.openqa.selenium.NoSuchElementException e) {
            return false;
        }
    }
}
