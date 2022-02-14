package others;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.testng.annotations.Test;
import test_base.TestBase;

import java.io.File;

public class HighSiteTest extends TestBase {

    @Test
    public void shouldScroll() throws Exception {
        driver.get("https://seleniumui.moderntester.pl/high-site.php");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,2000)", "");
        driver.findElement(By.id("scroll-button")).click();
        wait.until(c -> driver.findElement(By.id("scroll-button")).isDisplayed());
        takeSnapShot(driver, "src/main/resources/downloads/ss");
    }

    public static void takeSnapShot(WebDriver webdriver, String fileWithPath) throws Exception {

        TakesScreenshot scrShot = ((TakesScreenshot) webdriver);
        File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);
        File DestFile = new File(fileWithPath);
        FileUtils.copyFile(SrcFile, DestFile);
    }
}
