package basics;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import test_base.TestBase;

public class PromptAlertBoxTest extends TestBase {

    @Test
    public void promptAlert(){
        SimpleAlertPopUpTest.getOnAlertsPage();
        driver.findElement(By.id("prompt-alert")).click();
        driver.switchTo().alert().sendKeys("Lord Vader");
        driver.switchTo().alert().accept();
        Assert.assertEquals(driver.findElement(By.id("prompt-label")).getText(),"Hello Lord Vader! How are you today?");

    }

}
