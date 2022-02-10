package basics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import test_base.TestBase;

import java.util.List;

public class TableTest extends TestBase {

    @Test
            public void shouldPrintTable() {
        driver.get("https://seleniumui.moderntester.pl/");
        driver.findElement(By.cssSelector(".dropdown-toggle")).click();
        driver.findElement(By.id("table-item")).click();
        List<WebElement> mountains = driver.findElements(By.cssSelector("tbody tr"));
        Assert.assertTrue(mountains.size()>0);
        printMountainsTable(mountains);
    }

    private void printMountainsTable(List<WebElement> mountains) {
        for (WebElement mountain : mountains){
            System.out.print(mountain.findElement(By.cssSelector("th")).getText() + " ");
            System.out.print(mountain.findElements(By.cssSelector("td")).get(0).getText() + " ");
            String td = mountain.findElements(By.cssSelector("td")).get(2).getText();
            int height = Integer.parseInt(mountain.findElements(By.cssSelector("td")).get(3).getText());
            if(td.contains("Switzerland") && height > 4000) {
                System.out.println(mountain.findElements(By.cssSelector("td")).get(1).getText());
            }else
                System.out.println();
        }
    }
}
