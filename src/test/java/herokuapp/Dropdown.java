package herokuapp;

import framework.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

public class Dropdown extends BaseTest {
    private static final String NAV_MENU = "//a[text()='%s']";
    private static final By TAG_SELECT = By.tagName("select");
    private static final By TAG_OPTION = By.tagName("option");
    private static final String OPTION_FOR_XPATH = "//option[@value='%s']";

    @Test
    public void selectOptionTest(){
        WebElement navMenu = driver.findElement(By.xpath(String.format(NAV_MENU, "Dropdown")));
        navMenu.click();

        List<WebElement> elements = driver.findElements(TAG_OPTION);
        System.out.println("Elements in dropdown list:");
        for (int i = 0; i < elements.size(); i++){
            System.out.println(i + 1 + ". " + elements.get(i).getText());
        }

        WebElement option1 = driver.findElement(By.xpath(String.format(OPTION_FOR_XPATH, "1")));
        driver.findElement(TAG_SELECT).click();
        option1.click();
        if (option1.isSelected()){
            System.out.println("Option 1 is selected!");
        }
        else {
            System.out.println("Option 1 isn't selected...");
        }

        WebElement option2 = driver.findElement(By.xpath(String.format(OPTION_FOR_XPATH, "2")));
        driver.findElement(TAG_SELECT).click();
        option2.click();
        if (option2.isSelected()){
            System.out.println("Option 2 is selected!");
        }
        else {
            System.out.println("Option 2 isn't selected...");
        }
    }
}
