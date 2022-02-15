package basics;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import test_base.TestBase;

import java.util.ArrayList;

public class WindowsAndTabsTest extends TestBase {
    @Test
    public void shouldCloseWindowsAndTabs(){
        driver.get("https://seleniumui.moderntester.pl/windows-tabs.php");
        driver.findElement(By.id("newBrowserWindow")).click();
        String winHandleBefore = driver.getWindowHandle();
        switchToNewWindow();
        driver.close();
        driver.switchTo().window(winHandleBefore);
        driver.findElement(By.id("newMessageWindow")).click();
        switchToNewWindow();
        System.out.println(driver.findElement(By.cssSelector("body")).getText());
        driver.close();
        driver.switchTo().window(winHandleBefore);
        driver.findElement(By.id("newBrowserTab")).click();
        ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());
        driver.switchTo().window(tabs2.get(1));
        driver.close();
        driver.switchTo().window(tabs2.get(0));
    }

    private void switchToNewWindow() {
        for(String winHandle : driver.getWindowHandles()) {
            driver.switchTo().window(winHandle);
        }
    }
}
