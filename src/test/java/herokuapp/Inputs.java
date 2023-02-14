package herokuapp;

import framework.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class Inputs extends BaseTest {
    private static final String NAV_MENU = "//a[text()='%s']";
    private static final By TAG_INPUT = By.tagName("input");

    @Test
    public void inputValuesTest() {
        WebElement navMenu = driver.findElement(By.xpath(String.format(NAV_MENU, "Inputs")));
        navMenu.click();
        WebElement input = driver.findElement(TAG_INPUT);

        input.click();
        input.sendKeys("wteutwtue");
        input.clear();

        input.click();
        input.sendKeys("123124151");
        input.clear();

        for (int i = 0; i < 10; i++) {
            input.sendKeys(Keys.ARROW_UP);
        }
        for (int i = 0; i < 5; i++) {
            input.sendKeys(Keys.ARROW_DOWN);
        }
    }
}