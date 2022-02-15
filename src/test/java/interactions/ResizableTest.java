package interactions;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import test_base.TestBase;

public class ResizableTest extends TestBase {
    @Test
    public void shouldResize() throws InterruptedException {
        driver.get("https://seleniumui.moderntester.pl/resizable.php");
        Actions action = new Actions(driver);
        WebElement dragRight = driver.findElement(By.cssSelector(".ui-resizable-e"));
        WebElement dragBottom = driver.findElement(By.cssSelector(".ui-resizable-s"));
        action.clickAndHold(dragRight).moveByOffset(27,0).release().perform();
        action.clickAndHold(dragBottom).moveByOffset(0,27).release().perform();
        resizeRightAndBottomFrame(dragRight, dragBottom, action, 27, 27);
        //nie wie czy to błąd, ale: przy klikaniu myszka ramka sie cofa o ~17 pikseli w gląb.

    }

    private void resizeRightAndBottomFrame(WebElement dragRight, WebElement dragBottom, Actions action, int x, int y) throws InterruptedException {
        action.clickAndHold(dragRight).moveByOffset(x,0).release().perform();
        action.clickAndHold(dragBottom).moveByOffset(0,y).release().perform();
    }
}
