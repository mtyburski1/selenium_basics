package pl.seleniumui.moderntester;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import test_base.TestBase;

import java.io.File;
import java.util.List;
import java.util.Random;

public class MyFirstTest extends TestBase {
    static Random random = new Random();
    File fileToUpload = new File("src/main/resources/test_file.txt");


    @Test
    public void completeAFormPass() {
        driver.get("https://seleniumui.moderntester.pl/");

        driver.findElement(By.cssSelector(".dropdown-toggle")).click();
        driver.findElement(By.id("form-item")).click();
        driver.findElement(By.id("inputFirstName3")).sendKeys("majkel");
        driver.findElement(By.id("inputLastName3")).sendKeys("tybi");
        driver.findElement(By.id("inputEmail3")).sendKeys("blabla@gmail.com");
        List<WebElement> genders = driver.findElements(By.name("gridRadiosSex"));
        getRandomWebElement(genders).click();
        driver.findElement(By.id("inputAge3")).sendKeys("21");
        List<WebElement> expYears = driver.findElements(By.name("gridRadiosExperience"));
        getRandomWebElement(expYears).click();
        driver.findElement(By.id("gridCheckAutomationTester")).click();
        Select continents = new Select(driver.findElement(By.id("selectContinents")));
        continents.selectByValue("europe");
        Select selectSeleniumCommands = new Select(driver.findElement(By.id("selectSeleniumCommands")));
        selectSeleniumCommands.selectByValue("wait-commands");
        driver.findElement(By.id("chooseFile")).sendKeys(fileToUpload.getAbsolutePath());
        driver.findElement(By.id("additionalInformations")).sendKeys("Dzień dobry, witam, siema");
        driver.findElement(By.cssSelector(".btn-primary")).click();
        Assert.assertEquals(driver.findElement(By.id("validator-message")).getText(),"Form send with success");

    }

    public static WebElement getRandomWebElement(List<WebElement> webElementList){
        return webElementList.get(random.nextInt(webElementList.size()));
    }

}
