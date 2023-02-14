package herokuapp;

import framework.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.time.Duration;

public class Checkboxes extends BaseTest {
    private static final String NAV_MENU = "//a[text()='%s']";
    private static final String CHECKBOX_ELEMENT = "//input['%s']";

    @Test
    public void markingCheckboxesTest(){
        WebElement navMenu = driver.findElement(By.xpath(String.format(NAV_MENU, "Checkboxes")));
        navMenu.click();

        WebElement checkbox1 = driver.findElement(By.xpath(String.format(CHECKBOX_ELEMENT, "1")));
        WebElement checkbox2 = driver.findElement(By.xpath(String.format(CHECKBOX_ELEMENT, "2")));
            if (!checkbox1.isSelected()) {
                checkbox1.click();
            }
            if (checkbox1.isSelected()) {
                System.out.println("checkbox1 is selected!");
            }
            if (checkbox2.isSelected()) {
                checkbox2.click();
            }
            if (!checkbox2.isSelected()) {
                System.out.println("checkbox2 is not selected!");
            }
    }
}
