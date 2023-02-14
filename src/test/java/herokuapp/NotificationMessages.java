package herokuapp;

import framework.BaseTest;
import framework.PropertyReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class NotificationMessages extends BaseTest {
    private static final String NAV_MENU = "//a[text()='%s']";
    private static final By LINK_FOR_CLICK = By.xpath("//p//a");
    private static final By NOTIFICATION_MESSAGE = By.xpath("//div[@id='flash']");

    @Test
    public void viewMessageTest() {
        WebElement navMenu = driver.findElement(By.xpath(String.format(NAV_MENU, "Notification Messages")));
        navMenu.click();

        driver.findElement(LINK_FOR_CLICK).click();

        WebElement notification = new WebDriverWait(driver, Duration.ofSeconds(new PropertyReader("config.properties").getIntProperty("timeout.for.page.load")))
                .until(ExpectedConditions.visibilityOf(driver.findElement(NOTIFICATION_MESSAGE)));
        if (!notification.isDisplayed()) {
            System.out.println("ERROR: No one notification message!");
        }
        else if (driver.findElement(NOTIFICATION_MESSAGE).getText().contains("Action successful")){
            System.out.println("Action successful");
        }
        else if (driver.findElement(NOTIFICATION_MESSAGE).getText().contains("Action unsuccesful, please try again")){
            System.out.println("Action unsuccesful, please try again");
        }
        else {
            System.out.println("Etc. message");
        }
    }
}
