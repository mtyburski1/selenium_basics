package widgets;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import test_base.TestBase;

import java.util.List;

public class AccordionTest extends TestBase {
    @Test
    public void shouldPrintText() {
        driver.get("https://seleniumui.moderntester.pl/accordion.php");

        List<WebElement> openAccordions = driver.findElements(By.cssSelector("div h3"));
        Assert.assertTrue(openAccordions.size() > 0);

        List<WebElement> accordionsText = driver.findElements(By.cssSelector("div .ui-corner-bottom"));
        Assert.assertTrue(accordionsText.size() > 0);

        printTextFromAccordion(openAccordions, accordionsText);
    }

    private void printTextFromAccordion(List<WebElement> openAccordions, List<WebElement> accordionsText) {
        for (WebElement webElement : openAccordions) {
            if(webElement != openAccordions.get(0)) {
                webElement.click();
            }
            for (WebElement element : accordionsText) {
                System.out.println(element.findElement(By.cssSelector("p")).getText());
                if(element == accordionsText.get(2)){
                        System.out.println(element.findElement(By.cssSelector("ul")).getText());
                    }
                }

            }
    }

}

