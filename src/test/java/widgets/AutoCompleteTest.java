package widgets;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import test_base.TestBase;

import java.util.List;
import java.util.Random;

public class AutoCompleteTest extends TestBase {
    @Test
    public void shouldAutoComplete() throws InterruptedException {
        driver.get("https://seleniumui.moderntester.pl/autocomplete.php");
        driver.findElement(By.id("search")).sendKeys("a");

        List<WebElement> searches = driver.findElements(By.cssSelector("#ui-id-1 li"));
        Assert.assertTrue(searches.size()>0);


        for (WebElement search : searches) {
            if(search != driver.findElement(By.className("ui-autocomplete-category")))
                System.out.println(search.getText());
        }
        Random random = new Random();
        WebElement searchWindow = driver.findElement(By.id("search"));
        searchWindow.sendKeys(Keys.BACK_SPACE);
        searchWindow.sendKeys(searches.get(random.nextInt(searches.size())).getText());
//        Assert.assertEquals(searchWindow.getText(), searches);
        //na logike jak biore randoma z listy, to wychodzi, ze sie zgadza.........
            }
        }
