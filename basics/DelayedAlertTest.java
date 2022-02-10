package basics;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import test_base.TestBase;

import java.time.Duration;

public class DelayedAlertTest extends TestBase {
    @Test
    public void shouldWaitForAlert(){
        SimpleAlertPopUpTest.getOnAlertsPage();
        driver.findElement(By.id("delayed-alert")).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.alertIsPresent());
        driver.switchTo().alert().accept();
        String elementText = driver.findElement(By.id("delayed-alert-label")).getText();
        Assert.assertEquals(elementText, "OK button pressed");
    }
}
