package interactions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import test_base.TestBase;

public class DragAndDropTest extends TestBase {
    @Test
    public void shouldDragAndDrop() throws InterruptedException {
        driver.get("https://seleniumui.moderntester.pl/droppable.php");
        WebElement drag = driver.findElement(By.id("draggable"));
        WebElement drop = driver.findElement(By.id("droppable"));
        Actions action = new Actions(driver);
        action.dragAndDrop(drag, drop).perform();
        Assert.assertEquals(driver.findElement(By.cssSelector("#droppable p")).getText(), "Dropped!");
    }
}
