package widgets;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;
import test_base.TestBase;

public class SliderTest extends TestBase {
    @Test
    public void shouldSliderWorks(){
        driver.get("https://seleniumui.moderntester.pl/slider.php");
        driver.findElement(By.id("custom-handle")).click();
        changeTheSliderValue(50);
        changeTheSliderValue(80);
        changeTheSliderValue(30);
        changeTheSliderValue(0);

    }

    private void changeTheSliderValue(int value) {
        for (int i = 0; i < value; i++) {
            driver.findElement(By.id("custom-handle")).sendKeys(Keys.ARROW_RIGHT);
        }
        System.out.println(driver.findElement(By.cssSelector("div[style='left: " + value +"%;']")).isDisplayed());
        for (int i = 0; i < value; value--) {
            driver.findElement(By.id("custom-handle")).sendKeys(Keys.ARROW_LEFT);
        }
    }
}
