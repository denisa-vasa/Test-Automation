package pages;

import elements.DashBoardPageElements;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import utilities.BaseInformation;

public class DashBoardPage {

    public DashBoardPage() {
        PageFactory.initElements(BaseInformation.getDriver(), this);
    }

    DashBoardPageElements dashBoardPageElements = new DashBoardPageElements();

    public void clickLogOutMenu(){
        dashBoardPageElements.logout.click();
    }

    public void hoverElectronics(){
        Actions actions = new Actions(BaseInformation.getDriver());
        actions.moveToElement(dashBoardPageElements.electronics).perform();
    }

    public void clickElectronics(){
        dashBoardPageElements.electronics.click();
    }
}
