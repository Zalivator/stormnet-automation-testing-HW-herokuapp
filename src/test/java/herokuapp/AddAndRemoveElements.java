package herokuapp;

import framework.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class AddAndRemoveElements extends BaseTest {
    private static final String NAV_MENU = "//a[text()='%s']";
    private static final By BUTTON_ADD_ELEMENT = By.tagName("button");
    private static final String BUTTON_DELETE_ELEMENT = "//button[@class='added-manually']['%s']";

    @Test
    public void addAndRemoveElementsTest() {
        WebElement navMenu = driver.findElement(By.xpath(String.format(NAV_MENU, "Add/Remove Elements")));
        navMenu.click();

        int count = 0;
        WebElement addElement = driver.findElement(BUTTON_ADD_ELEMENT);
        for (int i = 0; i < 2; i++){
            addElement.click();
            count++;
        }
        WebElement deleteElement = driver.findElement(By.xpath(String.format(BUTTON_DELETE_ELEMENT, "1")));
        deleteElement.click();
        count--;

        System.out.println("Count of elements: " + count);

    }

}
