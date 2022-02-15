package basics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import pl.seleniumui.moderntester.MyFirstTest;
import test_base.TestBase;

import java.util.List;

public class IframeTest extends TestBase {
    @Test
    public void shouldFillIframes(){
        driver.get("https://seleniumui.moderntester.pl/");
        driver.findElement(By.cssSelector(".dropdown-toggle")).click();
        driver.findElement(By.cssSelector("#iframes-item")).click();
        driver.switchTo().frame("iframe1");
        driver.findElement(By.id("inputFirstName3")).sendKeys("Jan");
        driver.findElement(By.id("inputSurname3")).sendKeys("Kowalski");
        driver.switchTo().defaultContent();
        driver.switchTo().frame("iframe2");
        driver.findElement(By.id("inputLogin")).sendKeys("jan123");
        driver.findElement(By.id("inputPassword")).sendKeys("321jan");
        Select continents = new Select(driver.findElement(By.id("inlineFormCustomSelectPref")));
        continents.selectByValue("africa");
        List<WebElement> expYears = driver.findElements(By.name("gridRadios"));
        MyFirstTest.getRandomWebElement(expYears).click();
        driver.switchTo().defaultContent();
        driver.findElement(By.cssSelector(".dropdown-toggle")).click();
    }
}
