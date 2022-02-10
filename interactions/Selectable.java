package interactions;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import test_base.TestBase;

import java.util.ArrayList;
import java.util.List;

public class Selectable extends TestBase {
    @Test
    public void shouldSelect() {
        //nie dzialaaa
        driver.get("https://seleniumui.moderntester.pl/selectable.php");

        List<WebElement> selectable = driver.findElements(By.cssSelector("div ol li"));
        System.out.println(selectable.size());
        Assert.assertTrue(selectable.size() > 0);

        var action = new Actions(driver);
        action.keyDown(Keys.CONTROL);

        for (var select : selectable) {
            select.click();
        }
    }
}

