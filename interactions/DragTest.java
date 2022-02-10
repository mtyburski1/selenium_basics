package interactions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import test_base.TestBase;

import javax.swing.*;

public class DragTest extends TestBase {
    @Test
    public void shouldDrag(){
        driver.get("https://seleniumui.moderntester.pl/draggable.php");
        WebElement drag = driver.findElement(By.id("draggable"));
        Actions action = new Actions(driver);
        drag(drag, action, 1150, -200);
        drag(drag, action, 0, 550);
        drag(drag,action, -700, -200);
        drag(drag,action, -650, 220);


    }

    private void drag(WebElement drag, Actions action, int x, int y) {
        action.clickAndHold(drag).moveByOffset(x, y).release().perform();
    }
}
