package widgets;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import test_base.TestBase;

import java.time.Duration;

public class ProgressBarTest extends TestBase {
    @Test
    public void shouldLoadAProgressBar(){
        driver.get("https://seleniumui.moderntester.pl/progressbar.php");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.textToBe(By.cssSelector(".progress-label"), "Complete!"));
    }
}
