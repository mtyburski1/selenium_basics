package basics;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import test_base.TestBase;


public class SimpleAlertPopUpTest extends TestBase {
    @Test
    public void popUpAlert(){
        getOnAlertsPage();
        driver.findElement(By.id("simple-alert")).click();
        driver.switchTo().alert().accept();
        Assert.assertEquals(driver.findElement(By.id("simple-alert-label")).getText(),"OK button pressed");
    }
    public static void getOnAlertsPage(){
        driver.get("https://seleniumui.moderntester.pl/");
        driver.findElement(By.cssSelector(".dropdown-toggle")).click();
        driver.findElement(By.id("alerts-item")).click();
    }
}
