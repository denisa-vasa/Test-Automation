package utilities;

import globals.Globals;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseInformation {

    private static WebDriver driver;

    public static WebDriver getDriver() {
        if(driver==null) {
            String browserType = Globals.browserType.toLowerCase();

            switch (browserType) {
                case "chrome" -> {
                    System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
                    driver = new ChromeDriver();
                    driver.manage().window().maximize();
                }
                case "firefox" -> System.out.println("Do nothing");
                default -> throw new WebDriverException();
            }
        }
        return driver;
    }
}
