package basics;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import test_base.TestBase;

public class ConfirmAlertBoxTest extends TestBase {

    @Test
    public void ConfirmAlertShouldWork(){
        SimpleAlertPopUpTest.getOnAlertsPage();
        driver.findElement(By.cssSelector("#confirm-alert")).click();
        driver.switchTo().alert().accept();
        Assert.assertEquals(driver.findElement(By.cssSelector("#confirm-label")).getText(), "You pressed OK!");
        driver.findElement(By.cssSelector("#confirm-alert")).click();
        driver.switchTo().alert().dismiss();
        Assert.assertEquals(driver.findElement(By.cssSelector("#confirm-label")).getText(), "You pressed Cancel!");
    }
}
