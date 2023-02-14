package herokuapp;

import framework.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class Hovers extends BaseTest {
    private static final String NAV_MENU = "//a[text()='%s']";
    private static final String USER_IMAGE = "//img[@alt='User Avatar']['%s']";
    private static final String USER_LINK = "//h5[text()='%s']/../a";
    private static final By NOT_FOUND_TITLE = By.tagName("h1");

    @Test
    public void hoversTest() {
        WebElement navMenu = driver.findElement(By.xpath(String.format(NAV_MENU, "Hovers")));
        navMenu.click();

        Actions action = new Actions(driver);
        action.moveToElement(driver.findElement(By.xpath(String.format(USER_IMAGE, 1))))
                .click(driver.findElement(By.xpath(String.format(USER_LINK, "name: user1")))).build().perform();
        if (driver.findElement(NOT_FOUND_TITLE).getText().equals("Not Found")){
            System.out.println(driver.findElement(NOT_FOUND_TITLE).getText());
        }
        else {
            System.out.println("No errors");
        }
        driver.navigate().back();

        action.moveToElement(driver.findElement(By.xpath(String.format(USER_IMAGE, 2))))
                .click(driver.findElement(By.xpath(String.format(USER_LINK, "name: user2")))).build().perform();
        if (driver.findElement(NOT_FOUND_TITLE).getText().equals("Not Found")){
            System.out.println(driver.findElement(NOT_FOUND_TITLE).getText());
        }
        else {
            System.out.println("No errors");
        }
        driver.navigate().back();

        action.moveToElement(driver.findElement(By.xpath(String.format(USER_IMAGE, 3))))
                .click(driver.findElement(By.xpath(String.format(USER_LINK, "name: user3")))).build().perform();
        if (driver.findElement(NOT_FOUND_TITLE).getText().equals("Not Found")){
            System.out.println(driver.findElement(NOT_FOUND_TITLE).getText());
        }
        else {
            System.out.println("No errors");
        }
    }
}
